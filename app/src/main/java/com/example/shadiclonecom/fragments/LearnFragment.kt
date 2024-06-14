package com.example.shadiclonecom.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shadiclonecom.R

/**
 * A simple [Fragment] subclass.
 * Use the [LearnFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearnFragment
    : Fragment() {
    // TODO: Rename and change types of parameters
    private val param1: String? = "Arg1"
    private val param2: String? = "Arg2"

    public fun  getInstance(value1:String,value2:String):LearnFragment{
        val learnFragment:LearnFragment= LearnFragment()
       val bundle:Bundle=Bundle()
        bundle.putString(param1,value1)
        learnFragment.setArguments(bundle)
        return learnFragment


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view: View = inflater.inflate(R.layout.fragment_learn, container, false)
        val txtfrag: TextView =view.findViewById(R.id.fragtxt)
        txtfrag.text=getArguments()?.getString(param1)?:"hello"
        return view
    }


}