package io.eworks.memory.ui.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.eworks.memory.databinding.FragmentSharedBinding

class SharedFragment : Fragment() {

    private var _binding: FragmentSharedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val sharedViewModel =
                ViewModelProvider(this).get(SharedViewModel::class.java)

        _binding = FragmentSharedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textShared
        sharedViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}