package com.locotodevteam.todoloco.data

import com.locotodevteam.todoloco.model.Post
import com.locotodevteam.todoloco.model.PostDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("/posts")
    suspend fun getAllPosts(): Response<List<Post.PostItem>>

    @GET("/posts/{id}")
    suspend fun getPostDetail(@Path("id")id: String): Response<PostDetail>
}