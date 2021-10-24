package com.locotodevteam.todoloco.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.locotodevteam.todoloco.R
import com.locotodevteam.todoloco.adapter.PostAdapter
import com.locotodevteam.todoloco.databinding.FragmentPostListBinding
import com.locotodevteam.todoloco.ui.viewmodel.MainViewModel

class PostList : Fragment(), PostAdapter.PostListener {

    lateinit var postListBinding: FragmentPostListBinding
    lateinit var recycler: RecyclerView
    val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_post_list, container, false)
        postListBinding = FragmentPostListBinding.bind(view)
        return postListBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("chris","se esta creanbdo")
        initCalls()
        initRecyclerView()
        initObservers()
    }

    fun initCalls(){
        mainViewModel.getAllPosts()
    }

    fun initRecyclerView(){
        recycler = postListBinding.rvPosts
        recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recycler.adapter = PostAdapter(emptyList(),this)
    }

    fun initObservers(){
        mainViewModel.posts.observe(viewLifecycleOwner,{
            recycler.adapter = PostAdapter(it,this)
        })
    }



    override fun didSelectPost(postId: String) {
        //TODO: mover a la vista del detalle
    }

}