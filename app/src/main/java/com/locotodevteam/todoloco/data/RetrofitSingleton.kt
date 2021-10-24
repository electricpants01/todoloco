package com.locotodevteam.todoloco.data

import com.locotodevteam.todoloco.utils.API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitSingleton {

    private var retrofit: Retrofit? = null

    companion object {
        private const val BASE_URL = API_URL
    }

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}