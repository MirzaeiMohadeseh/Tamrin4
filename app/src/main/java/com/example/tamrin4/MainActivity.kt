package com.example.tamrin4

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
    lateinit var button: Button
    lateinit var persionnumButton: Button
    lateinit var todayButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        // Referencing and Initializing the button
        button = findViewById(R.id.clickBtn)
        persionnumButton= findViewById(R.id.persionnumButton)
        todayButton =findViewById(R.id.todaybutton)
        // Setting onClick behavior to the button
        button.setOnClickListener{
        // Initializing the popup menu and giving the reference as current context
        val popupMenu = PopupMenu(this@MainActivity, button)
        // Inflating popup menu from popup_menu.xml file
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId) {
                    R.id.home -> {
                        val intent = Intent(
                            this@MainActivity,
                            HomeActivity::class.java
                        )
                        startActivity(intent)
                        true
                    }
                    R.id.aboutus -> {
                        val intent = Intent(
                            this@MainActivity,
                            AboutUsActivity::class.java
                        )
                        startActivity(intent)
                        true
                    }
                    R.id.contactus -> {
                        val intent = Intent(
                            this@MainActivity,
                            ContactUsActivity::class.java
                        )
                        startActivity(intent)
                        true
                    }
                    R.id.home,R.id.aboutus,R.id.contactus->{
                        // Toast message on menu item clicked
                        Toast.makeText(this@MainActivity,
                            "You Clicked "+
                                    menuItem.title,
                            Toast.LENGTH_SHORT)
                            .show()
                        true
                    }


                    else -> false
                }

            }
            // Showing the popup menu
            popupMenu.show()
        }
        todayButton.setOnClickListener{
            val intent=Intent(
                this@MainActivity,
                TodayDate::class.java
            )
            startActivity(intent)
        }
        persionnumButton.setOnClickListener{
            val intent=Intent(
                this@MainActivity,
                PersianNum::class.java
            )
            startActivity(intent)
        }
    }

}