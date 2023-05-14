package com.randomuser.data.network

import com.randomuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/")
    fun getUsers(): Call<UserResponse>

}