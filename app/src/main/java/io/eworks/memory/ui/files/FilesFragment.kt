package io.eworks.memory.ui.files

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.eworks.memory.databinding.FragmentFilesBinding

class FilesFragment : Fragment() {

    private var _binding: FragmentFilesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val filesViewModel =
                ViewModelProvider(this).get(FilesViewModel::class.java)

        _binding = FragmentFilesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFiles
        filesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}