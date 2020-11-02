package com.project.data.api

import com.project.data.Hero
import com.project.data.Post
import retrofit2.http.GET


interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): List<Post>



    //Fetch Heroes response
    @GET("marvel")
    suspend  fun getHero(): List<Hero>
}