package com.example.shadiclonecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.shadiclonecom.R
import com.example.shadiclonecom.fragments.FragmentC
import com.example.shadiclonecom.fragments.FragmentPartTwo
import com.example.shadiclonecom.fragments.LearnFragment
import com.google.android.material.navigation.NavigationView

class DrawerNavigation : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
     lateinit var navigationView:NavigationView
    lateinit var toolBar:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_navigation)
    drawerLayout=findViewById(R.id.drawerlayout)
        navigationView=findViewById(R.id.navigationView)
        toolBar=findViewById(R.id.toolbar)

        setSupportActionBar(toolBar)
        val toggle =ActionBarDrawerToggle(this,
            drawerLayout,toolBar, R.string.openDrawer, R.string.closeDrawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        changefragment(FragmentC(),0)
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemA ->{
                    changefragment(FragmentC(),1)
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.itemB ->{
                    changefragment(LearnFragment(),1)
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    true

                }

                else -> {changefragment(FragmentPartTwo(),1)
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    true}
            }

        }

    }
    fun changefragment(fragment: Fragment, flag:Int){
        val fm: FragmentManager =supportFragmentManager
        val  ft: FragmentTransaction =fm.beginTransaction()


        if(flag==0) {
            ft.add(R.id.drawerFrameContainer,fragment)
        } else
            ft.replace(R.id.drawerFrameContainer,fragment)

        ft.commit()
    }

}