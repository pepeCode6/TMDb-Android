package com.pepecode.tmdbapp.models

data class MovieListItem (
    val popularity: Double,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
)


/*
  "popularity": 13.186,
            "vote_count": 1276,
            "video": false,
            "poster_path": "/oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg",
            "id": 696374,
            "adult": false,
            "backdrop_path": "/969BfPHGJcjg2aUv60g5uiiXFzf.jpg",
            "original_language": "en",
            "original_title": "Gabriel's Inferno",
            "genre_ids": [
                10749
            ],
            "title": "Gabriel's Inferno",
            "vote_average": 9,
            "overview": "El enigmático y atractivo profesor Gabriel Emerson, reconocido especialista en Dante, es un hombre torturado por su pasado y orgulloso del prestigio que ha conseguido, aunque también es consciente de que es un imán para el pecado y, en especial, para la lujuria.",
            "release_date": "2020-05-29"
 */
