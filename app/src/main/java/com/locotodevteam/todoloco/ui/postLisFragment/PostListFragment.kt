package com.locotodevteam.todoloco.ui.postLisFragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.locotodevteam.todoloco.R
import com.locotodevteam.todoloco.adapter.PostAdapter
import com.locotodevteam.todoloco.databinding.FragmentPostListBinding
import com.locotodevteam.todoloco.ui.mainActivity.MainActivity
import com.locotodevteam.todoloco.ui.mainActivity.MainViewModel

class PostListFragment : Fragment(), PostAdapter.PostListener {

    private lateinit var postListBinding: FragmentPostListBinding
    private lateinit var recycler: RecyclerView
    private val mainViewModel: MainViewModel by activityViewModels()

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
        (activity as MainActivity).setSupportActionBar(postListBinding.myToolbar.toolbar)
        initCalls()
        initRecyclerView()
        initObservers()
        initListener()
    }

    private fun initCalls(){
        mainViewModel.getAllPosts()
    }

    private fun initListener() {
        postListBinding.myToolbar.btnInfo.setOnClickListener {
            val action = PostListFragmentDirections.actionPostListToInfoFragment()
            findNavController().navigate(action)
        }
    }

    private fun initRecyclerView(){
        recycler = postListBinding.rvPosts
        recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recycler.adapter = PostAdapter(emptyList(),this)
    }

    private fun initObservers(){
        mainViewModel.posts.observe(viewLifecycleOwner) {
            recycler.adapter = PostAdapter(it, this)
        }
    }

    override fun didSelectPost(postId: String) {
        //TODO: mover a la vista del detalle
    }

}