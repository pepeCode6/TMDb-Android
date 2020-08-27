package com.pepecode.tmdbapp.api

import com.pepecode.tmdbapp.models.MovieListRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDbApi {

    @GET("movie/popular")
    suspend fun makePopularRequest(
        @Query("api_key") apiKey: String,
        @Query("language") lan: String,
        @Query("page") page: Int
    ): Response<MovieListRes>

    @GET("movie/top_rated")
    suspend fun makeTopRaterRequest(
        @Query("api_key") apiKey: String,
        @Query("language") lan: String,
        @Query("page") page: Int
    ): Response<MovieListRes>

    @GET("movie/now_playing")
    suspend fun makeNowPlayingRequest(
        @Query("api_key") apiKey: String,
        @Query("language") lan: String,
        @Query("page") page: Int
    ): Response<MovieListRes>

}

/*
    @POST("AsistenciasL2L/api/_LoginAsis")
    suspend fun doLogin( @Body loginReq: LoginReq ) : Response<LoginRes>

@Query("userId") userId: Int,
 */