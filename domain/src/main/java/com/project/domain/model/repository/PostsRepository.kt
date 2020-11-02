package com.project.domain.model.repository

import com.project.data.Post

interface PostsRepository {
    suspend fun getPosts(): List<com.project.data.Post>
}