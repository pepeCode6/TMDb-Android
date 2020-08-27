package com.pepecode.tmdbapp.ui.popular

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pepecode.tmdbapp.R
import com.pepecode.tmdbapp.viewModels.MoviesViewModel


class PopularFragment : Fragment() {

    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var rvPopular: RecyclerView
    private lateinit var adapter: PopularAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_popular, container, false)
        val layoutManager = LinearLayoutManager(activity)
        rvPopular = view.findViewById(R.id.rv_popular_movies)

        adapter = PopularAdapter(activity!!.baseContext)
        val dividerItemDecoration = DividerItemDecoration(
            rvPopular.context,
            layoutManager.orientation
        )
        rvPopular.addItemDecoration(dividerItemDecoration)

        rvPopular.adapter = adapter
        rvPopular.layoutManager = LinearLayoutManager(activity)





        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        moviesViewModel.getPopulars("es", 1)
        moviesViewModel.popularMovies.observe(this, Observer {movies ->
            adapter.setItems(movies)
            movies.forEach {movie ->
                Log.d("movie: ", movie.title)
                Log.d("movie: ", " ============================= ")
            }
        })
        return view
    }


}