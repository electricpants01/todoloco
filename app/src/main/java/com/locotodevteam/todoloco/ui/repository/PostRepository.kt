package com.locotodevteam.todoloco.ui.repository

import com.locotodevteam.todoloco.data.PostApi
import com.locotodevteam.todoloco.data.RetrofitSingleton
import com.locotodevteam.todoloco.model.Post
import retrofit2.Response

class PostRepository {

    suspend fun getAllPosts(): Response<List<Post.PostItem>>?{
        return RetrofitSingleton().getRetrofitInstance()?.create(PostApi::class.java)?.getAllPosts()
    }
}