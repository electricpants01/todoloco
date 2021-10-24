package com.locotodevteam.todoloco.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locotodevteam.todoloco.model.Post
import com.locotodevteam.todoloco.ui.repository.PostRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val posts = MutableLiveData<List<Post.PostItem>>()
    val repository = PostRepository()

    fun getAllPosts(){
        viewModelScope.launch {
            val response = repository.getAllPosts()
            response?.let { response ->
                if(response.isSuccessful){
                    response?.body()?.let {
                        posts.postValue(it)
                    }
                }else{
                    // return a bad Fetch message
                }
            }
        }
    }
}