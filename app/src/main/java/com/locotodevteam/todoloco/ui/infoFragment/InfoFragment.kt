package com.locotodevteam.todoloco.ui.infoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.locotodevteam.todoloco.R
import com.locotodevteam.todoloco.databinding.FragmentInfoBinding
import com.locotodevteam.todoloco.ui.mainActivity.MainActivity

class InfoFragment : Fragment() {

    lateinit var infoBinding: FragmentInfoBinding

    companion object{
        val instance = InfoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_info, container, false)
        infoBinding = FragmentInfoBinding.bind(view)
        return infoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setSupportActionBar(infoBinding.infoToolbar.toolbar)
        infoBinding.infoToolbar.btnInfo.visibility = View.GONE
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}