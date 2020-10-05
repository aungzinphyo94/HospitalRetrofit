package com.myanmaritc.typicoderetrofit.api

import com.myanmaritc.typicoderetrofit.model.Hospital
import com.myanmaritc.typicoderetrofit.model.HospitalsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HospitalApiInterface {

    @GET("hospital")
    fun getAllHospital(): Call<Hospital>


    //Path = {id}  //hospital/3
    @GET("hospital/{id}")
    fun getDetails(
        @Path("id") id: String
    ): Call<HospitalsItem>

}