package com.locotodevteam.todoloco.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.locotodevteam.todoloco.R
import com.locotodevteam.todoloco.databinding.PostItemBinding
import com.locotodevteam.todoloco.model.Post

class PostAdapter(var posts: List<Post.PostItem>,val listener: PostListener): RecyclerView.Adapter<PostAdapter.PostHolder>() {

    class PostHolder(val view: View): RecyclerView.ViewHolder(view){
        val binding = PostItemBinding.bind(view)

        fun render(post: Post.PostItem){
            binding.txtPostId.text = "El ID es ${post.id}"
            binding.txtPostTitle.text = post.title
            binding.txtPostBody.text = post.body
        }
    }

    fun updatePosts(postList: List<Post.PostItem>){
        this.posts = postList
        notifyDataSetChanged()
    }


    interface PostListener{
        fun didSelectPost(postId: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false);
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val item: Post.PostItem = posts[position]
        holder.render(item)
        holder.binding.postCardview.setOnClickListener {
            listener.didSelectPost(item.id.toString())
        }
    }

    override fun getItemCount(): Int = posts.size
}