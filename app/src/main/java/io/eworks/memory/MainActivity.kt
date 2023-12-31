package io.eworks.memory

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import io.eworks.memory.databinding.ActivityMainBinding
import io.eworks.memory.ui.files.FilesFragment
import io.eworks.memory.ui.home.HomeFragment
import io.eworks.memory.ui.home.images.ImageFragment
import io.eworks.memory.ui.more_options.MoreOptionsFragment
import io.eworks.memory.ui.shared.SharedFragment

class MainActivity : AppCompatActivity(),
    HomeFragment.OnFragmentInteractionListener, ImageFragment.OnFragmentInteractionListener {

    private lateinit var binding: ActivityMainBinding

//    private val homeFragment: HomeFragment;
//    private val sharedFragment: SharedFragment;
//    private val moreOptionsFragment: MoreOptionsFragment;
//    private val filesFragment: FilesFragment;

//    init {
//        Log.d("MainActivity", "init fragments")
//        homeFragment = HomeFragment()
//        sharedFragment = SharedFragment()
//        moreOptionsFragment = MoreOptionsFragment()
//        filesFragment = FilesFragment()
//    }

//    private val mOnNavItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
//
//        when (item.itemId) {
//            R.id.navigation_home -> transaction.replace(R.id.main_container, homeFragment)
//            R.id.navigation_shared -> transaction.replace(R.id.main_container, sharedFragment)
//            R.id.navigation_more -> transaction.replace(R.id.main_container, moreOptionsFragment)
//            R.id.navigation_files -> transaction.replace(R.id.main_container, filesFragment)
//        }
//        transaction.commit()
//        true
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_files,
            R.id.navigation_shared,
            R.id.navigation_more))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        navView.setOnItemSelectedListener(mOnNavItemSelectedListener)
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.main_container, homeFragment)
//        transaction.commit()
    }

    override fun messageFromParentFragment(uri: Uri?) {
        Log.i("TAG", "received communication from parent fragment");
    }

    override fun messageFromChildFragment(uri: Uri?) {
        Log.i("TAG", "received communication from child fragment");
    }
}