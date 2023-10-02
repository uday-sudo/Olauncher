package app.olauncher.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import app.olauncher.MainViewModel
import app.olauncher.R
import app.olauncher.data.Constants
import app.olauncher.data.Prefs
import app.olauncher.databinding.FragmentAppDrawerBinding
import app.olauncher.databinding.FragmentIconDrawerBinding

class IconDrawerFragment : Fragment(), View.OnClickListener {

    private lateinit var prefs: Prefs
    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentIconDrawerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentIconDrawerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = Prefs(requireContext())
        viewModel = activity?.run {
            ViewModelProvider(this)[MainViewModel::class.java]
        } ?: throw Exception("Invalid Activity")


        initClickListeners()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iconOption1 -> updateIconName(Constants.IC_SEARCH)
            R.id.iconOption2 -> updateIconName(Constants.IC_CIRCLE)
            R.id.iconOption3 -> updateIconName(Constants.IC_CAMERA)
            R.id.iconOption4 -> updateIconName(Constants.IC_GALLERY)
            R.id.iconOption5 -> updateIconName(Constants.IC_MAIL)
            R.id.iconOption6 -> updateIconName(Constants.IC_MESSAGE)
            R.id.iconOption7 -> updateIconName(Constants.IC_MUSIC)
            R.id.iconOption8 -> updateIconName(Constants.IC_PHONE)
            R.id.iconOption9 -> updateIconName(Constants.IC_WEB)
        }
    }

    private fun updateIconName(name: String) {
        viewModel.iconNameString.value = name
        findNavController().popBackStack()
    }

    private fun initClickListeners() {
        binding.iconOption1.setOnClickListener(this)
        binding.iconOption2.setOnClickListener(this)
        binding.iconOption3.setOnClickListener(this)
        binding.iconOption4.setOnClickListener(this)
        binding.iconOption5.setOnClickListener(this)
        binding.iconOption6.setOnClickListener(this)
        binding.iconOption7.setOnClickListener(this)
        binding.iconOption8.setOnClickListener(this)
        binding.iconOption9.setOnClickListener(this)
    }
}