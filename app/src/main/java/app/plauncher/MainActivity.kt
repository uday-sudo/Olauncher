package app.plauncher

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import app.plauncher.data.Constants
import app.plauncher.data.Prefs
import app.plauncher.databinding.ActivityMainBinding
import app.plauncher.helper.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: Prefs
    private lateinit var navController: NavController
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onBackPressed() {
        if (navController.currentDestination?.id != R.id.mainFragment)
            super.onBackPressed()
    }

    override fun attachBaseContext(context: Context) {
        val newConfig = Configuration(context.resources.configuration)
        newConfig.fontScale = Prefs(context).textSizeScale
        applyOverrideConfiguration(newConfig)
        super.attachBaseContext(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        prefs = Prefs(this)
        AppCompatDelegate.setDefaultNightMode(prefs.appTheme)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (prefs.firstOpen) {
            viewModel.firstOpen(true)
            prefs.firstOpen = false
        }

        initClickListeners()
        initObservers(viewModel)
        viewModel.getAppList()
        setupOrientation()

        window.addFlags(FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onStop() {
        backToHomeScreen()
        super.onStop()
    }

    override fun onUserLeaveHint() {
        backToHomeScreen()
        super.onUserLeaveHint()
    }

    override fun onNewIntent(intent: Intent?) {
        backToHomeScreen()
        super.onNewIntent(intent)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (prefs.dailyWallpaper &&
            AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        ) {
            setPlainWallpaper()
            viewModel.setWallpaperWorker()
        }
        recreate()
    }

    private fun initClickListeners() {
        binding.ivClose.setOnClickListener {
            binding.messageLayout.visibility = View.GONE
        }
    }

    private fun initObservers(viewModel: MainViewModel) {
        viewModel.launcherResetFailed.observe(this) {
            openLauncherChooser(it)
        }
        viewModel.resetLauncherLiveData.observe(this) {
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q)
            resetDefaultLauncher()
//            else
//                showLauncherSelector(Constants.REQUEST_CODE_LAUNCHER_SELECTOR)
        }
        viewModel.showDialog.observe(this) {
            when (it) {
                Constants.Dialog.RATE -> {
                    showMessageDialog(getString(R.string.app_name), getString(R.string.rate_us_message), getString(R.string.rate_now)) {
                        binding.messageLayout.visibility = View.GONE
                        prefs.rateClicked = true
                        rateApp()
                    }
                }

                Constants.Dialog.SHARE -> {
                    showMessageDialog(getString(R.string.app_name), getString(R.string.share_message), getString(R.string.share_now)) {
                        binding.messageLayout.visibility = View.GONE
                        shareApp()
                    }
                }

                Constants.Dialog.HIDDEN -> {
                    showMessageDialog(getString(R.string.hidden_apps), getString(R.string.hidden_apps_message), getString(R.string.okay)) {
                        binding.messageLayout.visibility = View.GONE
                    }
                }

                Constants.Dialog.KEYBOARD -> {
                    showMessageDialog(getString(R.string.app_name), getString(R.string.keyboard_message), getString(R.string.okay)) {
                        binding.messageLayout.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun showMessageDialog(title: String, message: String, action: String, clickListener: () -> Unit) {
        binding.tvTitle.text = title
        binding.tvMessage.text = message
        binding.tvAction.text = action
        binding.tvAction.setOnClickListener { clickListener() }
        binding.messageLayout.visibility = View.VISIBLE
    }

    @SuppressLint("SourceLockedOrientationActivity")
    private fun setupOrientation() {
        if (isTablet(this)) return
        // In Android 8.0, windowIsTranslucent cannot be used with screenOrientation=portrait
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.O)
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun backToHomeScreen() {
        binding.messageLayout.visibility = View.GONE
        if (navController.currentDestination?.id != R.id.mainFragment)
            navController.popBackStack(R.id.mainFragment, false)
    }

    private fun setPlainWallpaper() {
        if (this.isDarkThemeOn())
            setPlainWallpaper(this, android.R.color.black)
        else setPlainWallpaper(this, android.R.color.white)
    }

    private fun openLauncherChooser(resetFailed: Boolean) {
        if (resetFailed) {
            val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                Intent(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS)
            else {
                showToast(getString(R.string.search_for_Launcher_or_home_app), Toast.LENGTH_LONG)
                Intent(Settings.ACTION_SETTINGS)
            }
            startActivity(intent)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            Constants.REQUEST_CODE_ENABLE_ADMIN -> {
                if (resultCode == Activity.RESULT_OK)
                    prefs.lockModeOn = true
            }

            Constants.REQUEST_CODE_LAUNCHER_SELECTOR -> {
                resetDefaultLauncher()
            }
        }
    }
}