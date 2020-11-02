package com.project.data.repository

import com.project.data.api.ApiService
import com.project.data.Post
import com.project.domain.model.repository.PostsRepository


class PostsRepositoryImp(private val apiService: ApiService) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }
}
