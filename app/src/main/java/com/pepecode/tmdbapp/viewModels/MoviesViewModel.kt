package com.pepecode.tmdbapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pepecode.tmdbapp.models.MovieListItem
import com.pepecode.tmdbapp.repositiries.MovieRepository
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {

    private val movieRepository = MovieRepository()

    val popularMovies: MutableLiveData<List<MovieListItem>> = MutableLiveData()
    val topRaterMovies: MutableLiveData<List<MovieListItem>> = MutableLiveData()
    val nowPlayingMovies: MutableLiveData<List<MovieListItem>> = MutableLiveData()

    fun getPopulars(lan: String, page: Int) {
        viewModelScope.launch {
            val response = movieRepository.getPopular(lan, page)
            if ( response.isSuccessful ) {
                popularMovies.value = response.body()!!.results
            } else {
                print("error en la llamada xD")
            }
        }
    }

    fun getTopRaters(lan: String, page: Int) {
        viewModelScope.launch {
            val response = movieRepository.getTopRater(lan, page)
            if ( response.isSuccessful ) {
                topRaterMovies.value = response.body()!!.results
            } else {
                print("error en la llamada xD")
            }
        }
    }

    fun getNowPlayings(lan: String, page: Int) {
        viewModelScope.launch {
            val response = movieRepository.getNowPlaying(lan, page)
            if ( response.isSuccessful ) {
                nowPlayingMovies.value = response.body()!!.results
            } else {
                print("error en la llamada xD")
            }
        }
    }




}