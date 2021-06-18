package com.example.shemajamebeli8.api

import com.example.shemajamebeli8.models.Moedl
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET("v3/48bb936e-261a-4471-a362-3bbb3b9a2a58")
    suspend fun getList (): Response<Moedl>
}