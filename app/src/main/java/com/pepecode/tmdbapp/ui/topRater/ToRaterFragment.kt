package com.pepecode.tmdbapp.ui.topRater

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pepecode.tmdbapp.R
import com.pepecode.tmdbapp.ui.popular.PopularAdapter
import com.pepecode.tmdbapp.viewModels.MoviesViewModel


class ToRaterFragment : Fragment() {

    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var rv: RecyclerView
    private lateinit var adapter: PopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_to_rater, container, false)
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        rv = view.findViewById(R.id.rv_top)
        val layoutManager = LinearLayoutManager(activity)
        adapter = PopularAdapter(activity!!.baseContext)
        val dividerItemDecoration = DividerItemDecoration(
            rv.context,
            layoutManager.orientation
        )
        rv.addItemDecoration(dividerItemDecoration)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(activity)

        moviesViewModel.getTopRaters("es", 1)
        moviesViewModel.topRaterMovies.observe(this, Observer {movies ->
            adapter.setItems(movies)
        })

        return view
    }


}