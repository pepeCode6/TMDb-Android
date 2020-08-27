package com.pepecode.tmdbapp.repositiries

import com.pepecode.tmdbapp.api.RetrofitInstance
import com.pepecode.tmdbapp.models.MovieListRes
import com.pepecode.tmdbapp.utils.Constants.Companion.API_KEY
import retrofit2.Response

class MovieRepository {

    suspend fun getPopular( lan: String, page: Int): Response<MovieListRes> {
        return RetrofitInstance.api.makePopularRequest(API_KEY, lan, page)
    }

    suspend fun getTopRater( lan: String, page: Int): Response<MovieListRes> {
        return RetrofitInstance.api.makeTopRaterRequest(API_KEY, lan, page)
    }

    suspend fun getNowPlaying( lan: String, page: Int): Response<MovieListRes> {
        return RetrofitInstance.api.makeNowPlayingRequest(API_KEY, lan, page)
    }


}