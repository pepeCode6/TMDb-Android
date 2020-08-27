package com.pepecode.tmdbapp.ui.popular

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pepecode.tmdbapp.R
import com.pepecode.tmdbapp.models.MovieListItem
import kotlinx.android.synthetic.main.movie_list_item.view.*

class PopularAdapter(private val context: Context): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private var moviesList: List<MovieListItem> = emptyList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.movie_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.itemView.tv_title.text = movie.title
        holder.itemView.tv_description.text = movie.overview
        holder.itemView.tv_release.text = movie.release_date
        holder.itemView.tv_vote.text = movie.vote_average.toString()

        Glide
            .with(context)
            .load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
            .into(holder.itemView.iv_poster)


    }

    fun setItems( movies: List<MovieListItem> ) {
        moviesList = movies
        notifyDataSetChanged()
    }

}