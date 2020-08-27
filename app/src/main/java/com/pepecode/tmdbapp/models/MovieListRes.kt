package com.pepecode.tmdbapp.models

import com.pepecode.tmdbapp.models.MovieListItem

data class MovieListRes(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieListItem>
)


/*
*
*     "page": 1,
    "total_results": 7690,
    "total_pages": 385,
    "results": [
* */