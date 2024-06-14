package com.example.shadiclonecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.shadiclonecom.R
import com.example.shadiclonecom.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerTabLayout : AppCompatActivity() {
    lateinit var viewPager:ViewPager2
    lateinit var tabLayout:TabLayout
    lateinit var adapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_tab_layout)
        viewPager=findViewById(R.id.viewPager)
        tabLayout=findViewById(R.id.tablayout)

        adapter= ViewPagerAdapter(this,tabLayout.tabCount)
        viewPager.adapter=adapter

       TabLayoutMediator(tabLayout,viewPager){
           tab,pos->when(pos){
               0->tab.text="A"
               1->tab.text="B"
               else->tab.text="C"
           }
       }.attach()




    }
}