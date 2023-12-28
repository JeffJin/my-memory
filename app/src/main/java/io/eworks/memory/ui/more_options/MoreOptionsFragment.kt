package io.eworks.memory.ui.more_options

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.eworks.memory.databinding.FragmentMoreOptionsBinding

class MoreOptionsFragment : Fragment() {
    private var _binding: FragmentMoreOptionsBinding? = null

    private val binding get() = _binding!!


    companion object {
        fun newInstance() = MoreOptionsFragment()
    }

    private lateinit var viewModel: MoreOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel =
            ViewModelProvider(this).get(MoreOptionsViewModel::class.java)

        _binding = FragmentMoreOptionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMoreOptions
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MoreOptionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}