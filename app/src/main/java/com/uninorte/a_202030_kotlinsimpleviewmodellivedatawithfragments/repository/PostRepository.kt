package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository

import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.api.PostsApiService

class PostRepository {
    private val apiService = PostsApiService()

    suspend fun getPosts() = apiService.getPosts()

    suspend fun getPost() = apiService.getPost()
}