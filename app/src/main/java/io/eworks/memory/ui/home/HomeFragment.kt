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
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return setupUi()
    }

    private fun setupUi(): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var categorySpinner: Spinner = binding.spinnerCategoryVideo
        val categories = CommonService.loadCategories()
        val adapterCategories = ArrayAdapter<Category>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                categories.values.toList()
            )

        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapterCategories

        val fab: FloatingActionButton = binding.floatingActionButton
        activity?.let {
            fab.setOnClickListener { _ ->
                val activityIntent = Intent(it.baseContext, SlideUpOptionsActivity::class.java)
                activityIntent.putExtra("key1", "value1")
                activityIntent.putExtra("key2", "value2")
                startActivity(activityIntent)
            }
        }
        return root;
    }

    private fun setupMenu() {
        val menuHost: MenuHost = requireActivity()

        // Add menu items without using the Fragment Menu APIs
        // Note how we can tie the MenuProvider to the viewLifecycleOwner
        // and an optional Lifecycle.State (here, RESUMED) to indicate when
        // the menu should be visible

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here

                menuInflater.inflate(R.menu.main_bar_menu, menu)
                setupSearchView(menu)
            }

            override fun onMenuItemSelected(item: MenuItem): Boolean {
                return when (item.itemId) {
                    R.id.app_bar_search -> {
                        Log.d("App Main Toolbar", "Search clicked")
                        true
                    }

                    R.id.action_settings_account -> {
                        Log.d("App Main Toolbar", "Settings clicked")

                        true
                    }

                    R.id.action_more_help -> {
                        Log.d("App Main Toolbar", "Help clicked")

                        true
                    }

                    R.id.action_more_about -> {
                        Log.d("App Main Toolbar", "About Options clicked")

                        true
                    }

                    else -> return true
                }

            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // The usage of an interface lets you inject your own implementation
       setupMenu()
    }

    private fun setupSearchView(menu: Menu) {
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val appBarSearch = menu.findItem(R.id.app_bar_search)
        val tempView = appBarSearch?.actionView
        val searchView = tempView as SearchView
        val component = ComponentName(requireContext(), SearchResultsActivity::class.java)

        val searchableInfo = searchManager.getSearchableInfo(component)
        searchView.setSearchableInfo(searchableInfo)
    }

    private fun clearToolbarMenu() {
        binding.homeToolbar.menu.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearToolbarMenu()
        _binding = null
    }
}