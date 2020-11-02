package com.project.domain.model.usecase.base

import com.project.data.Hero
import com.project.domain.model.exception.ApiErrorHandle
import com.project.domain.model.repository.HeroRepository

class GetHeroUseCase constructor(
    private val postsRepository: HeroRepository,
    apiErrorHandle: ApiErrorHandle
) : BaseUseCase<List<com.project.data.Hero>, Any?>(apiErrorHandle) {

    override suspend fun execute(params: Any?): List<com.project.data.Hero> {
        return postsRepository.getHero()
    }
}