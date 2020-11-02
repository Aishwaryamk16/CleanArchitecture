package com.project.domain.model.usecase.base

import com.project.data.Post
import com.project.domain.model.exception.ApiErrorHandle
import com.project.domain.model.repository.PostsRepository


class GetPostsUseCase constructor(
    private val postsRepository: PostsRepository,
    apiErrorHandle: ApiErrorHandle
) : BaseUseCase<List<com.project.data.Post>, Any?>(apiErrorHandle) {

    override suspend fun execute(params: Any?): List<com.project.data.Post> {
        return postsRepository.getPosts()
    }

}