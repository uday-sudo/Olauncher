package app.olauncher.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.olauncher.MainViewModel
import app.olauncher.R
import app.olauncher.data.Prefs
import app.olauncher.databinding.FragmentFontSelectBinding
import app.olauncher.databinding.FragmentIconDrawerBinding

class FontSelectFragment : Fragment(), View.OnClickListener {

    private lateinit var prefs: Prefs
    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentFontSelectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFontSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}