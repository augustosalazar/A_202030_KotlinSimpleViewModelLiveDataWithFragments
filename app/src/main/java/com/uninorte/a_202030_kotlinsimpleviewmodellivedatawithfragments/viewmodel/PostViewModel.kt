package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.PostRepository
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.api.Post
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private val repository = PostRepository()
    val posts = mutableListOf<Post>()
    val postsLiveData = MutableLiveData<List<Post>>()

    init {
        getPost()
    }

    private fun getPosts() {
        viewModelScope.launch {
            posts.addAll(repository.getPosts())
            postsLiveData.postValue(posts)
        }
    }


     fun getPost() {
        viewModelScope.launch {
            val post = repository.getPost()
            posts.add(post)
            postsLiveData.postValue(posts)
        }
    }

}