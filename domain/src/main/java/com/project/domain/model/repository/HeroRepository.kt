package com.project.domain.model.repository



interface HeroRepository {
    suspend fun getHero(): List<com.project.data.Hero>
}