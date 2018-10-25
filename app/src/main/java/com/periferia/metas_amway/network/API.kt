package com.periferia.metas_amway.network

import com.periferia.metas_amway.network.models.CodeAmway
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {


    //@get:GET("")

    @GET("users/user/{idEmpresario}")
    fun validatecode(@Path("idEmpresario") codigo:Long):Observable<CodeAmway>


}