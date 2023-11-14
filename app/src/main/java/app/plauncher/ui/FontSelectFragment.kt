package app.plauncher.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import app.plauncher.MainViewModel
import app.plauncher.R
import app.plauncher.data.Constants
import app.plauncher.data.Prefs
import app.plauncher.databinding.FragmentFontSelectBinding
import app.plauncher.databinding.FragmentIconDrawerBinding

class FontSelectFragment : Fragment(), View.OnClickListener {

    private lateinit var prefs: Prefs
    private lateinit var viewModel: MainViewModel
    private var flagIsClockFont: Boolean = false

    private var _binding: FragmentFontSelectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFontSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = Prefs(requireContext())
        viewModel = activity?.run {
            ViewModelProvider(this)[MainViewModel::class.java]
        } ?: throw Exception("Invalid Activity")


        viewModel.flagIsClockFont.observe(viewLifecycleOwner, Observer {
            when (viewModel.flagIsClockFont.value) {
                true -> flagIsClockFont = true
                false -> flagIsClockFont = false
                else -> flagIsClockFont = false
            }
            Log.d("uday", flagIsClockFont.toString() + " = flagisclockfont")
        })


        initClickListeners()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.font1 -> updateFontName(Constants.Font.font1, flagIsClockFont)
            R.id.font2 -> updateFontName(Constants.Font.font2, flagIsClockFont)
            R.id.font3 -> updateFontName(Constants.Font.font3, flagIsClockFont)
            R.id.font4 -> updateFontName(Constants.Font.font4, flagIsClockFont)
            R.id.font5 -> updateFontName(Constants.Font.font5, flagIsClockFont)
            R.id.font6 -> updateFontName(Constants.Font.font6, flagIsClockFont)
            R.id.font7 -> updateFontName(Constants.Font.font7, flagIsClockFont)
            R.id.font8 -> updateFontName(Constants.Font.font8, flagIsClockFont)
            R.id.font9 -> updateFontName(Constants.Font.font9, flagIsClockFont)
            R.id.font10 -> updateFontName(Constants.Font.font10, flagIsClockFont)
            R.id.font11 -> updateFontName(Constants.Font.font11, flagIsClockFont)
        }
    }

    private fun updateFontName(fontName: String, isClockFont: Boolean) {
        if (isClockFont) {
            prefs.fontClockName = fontName
        }
        else {
            prefs.fontName = fontName
        }
        findNavController().popBackStack()
    }

    private fun initClickListeners() {
        binding.font1.setOnClickListener(this)
        binding.font2.setOnClickListener(this)
        binding.font3.setOnClickListener(this)
        binding.font4.setOnClickListener(this)
        binding.font5.setOnClickListener(this)
        binding.font6.setOnClickListener(this)
        binding.font7.setOnClickListener(this)
        binding.font8.setOnClickListener(this)
        binding.font9.setOnClickListener(this)
        binding.font10.setOnClickListener(this)
        binding.font11.setOnClickListener(this)
    }
}