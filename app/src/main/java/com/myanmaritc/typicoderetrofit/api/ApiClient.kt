package com.myanmaritc.typicoderetrofit.api

import com.myanmaritc.typicoderetrofit.model.Hospital
import com.myanmaritc.typicoderetrofit.model.HospitalsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "http://hospitalguideapi.dsv.hoz.mybluehost.me/api/"

    private val apiInterface: HospitalApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            HospitalApiInterface::class.java
        )
    }

    fun getAllHospital(): Call<Hospital> {
        return apiInterface.getAllHospital();
    }

    fun getDetail(id: String): Call<HospitalsItem> {
        return apiInterface.getDetails(id)
    }

}