package com.project.data.repository

import com.project.data.api.ApiService
import com.project.data.Hero
import com.project.domain.model.repository.HeroRepository

class HeroRepositoryImp(private val apiService: ApiService) : HeroRepository {

    override suspend fun getHero(): List<Hero> {
        return apiService.getHero()
    }
}