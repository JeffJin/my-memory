package io.eworks.memory.ui.home

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.eworks.common.models.Category
import io.eworks.common.services.CommonService
import io.eworks.memory.R
import io.eworks.memory.databinding.FragmentHomeBinding
import io.eworks.memory.ui.SlideUpOptionsActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var categorySpinner: Spinner = binding.spinnerCategoryVideo
        val categories = CommonService.loadCategories()
        val adapterCategories = activity?.let {
            ArrayAdapter<Category>(
                it.baseContext,
                android.R.layout.simple_spinner_item,
                categories.values.toList()
            )
        }
        if (adapterCategories != null) {
            adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categorySpinner.adapter = adapterCategories
        }

        val fab: FloatingActionButton = binding.floatingActionButton
        activity?.let {
            fab.setOnClickListener { _ ->
                val activityIntent = Intent(it.baseContext, SlideUpOptionsActivity::class.java)
                activityIntent.putExtra("key1", "value1")
                activityIntent.putExtra("key2", "value2")
                startActivity(activityIntent)
            }
        }


        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_bar_menu, menu)

        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val appBarSearch = menu.findItem(R.id.app_bar_search)
        val tempView = appBarSearch?.actionView
        val searchView = tempView as SearchView
        val component = activity?.let {
            ComponentName(
                it.baseContext,
                SearchResultsActivity::class.java
            )
        }
        val searchableInfo = searchManager.getSearchableInfo(component)
        searchView.setSearchableInfo(searchableInfo)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.app_bar_search -> {
                // Navigate to settings screen.
                true
            }

            R.id.action_settings -> {
                // Navigate to settings screen.
                true
            }

            R.id.action_more_help -> {
                // Display help options popup.
                true
            }

            R.id.action_more_about -> {
                // Display help options popup.
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.homeToolbar.inflateMenu(R.menu.home_toolbar_menu)

//        binding.homeToolbar.setOnMenuItemClickListener {
//            when (it.itemId) {
//                R.id.video_toolbar_home -> {
//                    // Navigate to settings screen.
//                    Log.d("Home Fragment Toolbar", "Videos clicked")
//                    true
//                }
//
//                R.id.image_toolbar_home -> {
//                    // Save profile changes.
//                    Log.d("Home Fragment Toolbar", "Images clicked")
//                    true
//                }
//
//                R.id.doc_toolbar_home -> {
//                    // Save profile changes.
//                    Log.d("Home Toolbar", "Documents clicked")
//                    true
//                }
//
//                R.id.audio_toolbar_home -> {
//                    // Save profile changes.
//                    Log.d("Home Fragment Toolbar", "Audios clicked")
//                    true
//                }
//
//                else -> false
//            }
//        }
    }

    fun clearToolbarMenu() {
        binding.homeToolbar.menu.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}