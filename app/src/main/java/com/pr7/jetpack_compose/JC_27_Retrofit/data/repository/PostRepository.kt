package com.pr7.jetpack_compose.JC_27_Retrofit

class PostRepository {


    suspend fun getAllData():ArrayList<PostModel>{
        val response= RetrofitInstance.getApi().getAllPosts()
        return  response
    }


}