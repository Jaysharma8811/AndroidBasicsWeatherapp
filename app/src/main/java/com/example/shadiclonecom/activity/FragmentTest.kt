package com.example.shadiclonecom.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.shadiclonecom.R
import com.example.shadiclonecom.fragments.FragmentC
import com.example.shadiclonecom.fragments.FragmentPartTwo
import com.example.shadiclonecom.fragments.LearnFragment

class FragmentTest : AppCompatActivity() {
lateinit var btnA :Button
    lateinit var btnB :Button
    lateinit var btnc :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
        btnc=findViewById(R.id.fragbtnC)
        btnA=findViewById(R.id.fragbtnA)
        btnB=findViewById(R.id.fragbtnB)


        changefragment(FragmentC(),0,1)


        btnA.setOnClickListener {
           changefragment(LearnFragment().getInstance("Jayhh","sharma"),1,0)
        }
        btnB.setOnClickListener {
           changefragment(FragmentPartTwo(),1,0)
        }
        btnc.setOnClickListener { changefragment(FragmentC(),1,1) }

    }

    @SuppressLint("SuspiciousIndentation")
    fun changefragment(fragment:Fragment, flag:Int,check:Int){
        val fm:FragmentManager=supportFragmentManager
        val  ft:FragmentTransaction=fm.beginTransaction()

if (check==1) {

    Log.d("checktheinside","insisre if")
    val bundel: Bundle = Bundle()
    bundel.putString("arg1", "My name is jay")
    bundel.putInt("arg2", 23)
    fragment.setArguments(bundel)
}
        Log.d("checktheinside","outside if+$fragment")




    if(flag==0) {
        ft.add(R.id.frameContainer,fragment,null)
//        val name:String?=fm.getBackStackEntryAt(0).getName()
//        fm.popBackStack(name,FragmentManager.POP_BACK_STACK_INCLUSIVE)
//
//        ft.addToBackStack(name)


    } else {
        ft.replace(R.id.frameContainer, fragment)
        ft.addToBackStack(null)
    }

        ft.commit()
    }

}