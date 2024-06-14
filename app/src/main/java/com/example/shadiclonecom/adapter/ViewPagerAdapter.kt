package com.example.shadiclonecom.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shadiclonecom.fragments.FragmentC
import com.example.shadiclonecom.fragments.FragmentPartTwo
import com.example.shadiclonecom.fragments.LearnFragment


class ViewPagerAdapter(fm:FragmentActivity, val count:Int):FragmentStateAdapter(fm){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       return  when(position){
           0->{
               FragmentC()
           }
           1->{
             FragmentPartTwo()
           }


           else -> {
               LearnFragment()
           }
       }
    }


}
