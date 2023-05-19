package com.pr7.jetpack_compose.JC_27_Retrofit


import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getAllPosts(): ArrayList<PostModel>

}