package com.d.pivp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flag = true
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.userFragment,
                R.id.mapFragment,
                R.id.homeFragment,
                R.id.settingFragment,
                R.id.trailerFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    //using for navigate back
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.logout_menu, menu)

        val shareItem = menu!!.findItem(R.id.item_add)
        // show the button when some condition is true
        if (flag) {
            shareItem.isVisible = true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_logout -> {
                userLogout()
                true
            }
            R.id.item_add -> {
                addTrailer()
                true
            }
            R.id.item_calender -> {
                setting()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setting() {

    }

    public fun addTrailer() {
       Toast.makeText(applicationContext,"Click",Toast.LENGTH_LONG).show()
    }

    private fun userLogout() {

    }

}
