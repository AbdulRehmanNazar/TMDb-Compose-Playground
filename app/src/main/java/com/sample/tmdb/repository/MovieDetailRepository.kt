package com.sample.tmdb.repository

import android.content.Context
import com.sample.tmdb.data.network.MovieService
import com.sample.tmdb.data.response.asDomainModel
import com.sample.tmdb.di.IoDispatcher
import com.sample.tmdb.domain.repository.BaseDetailRepository
import com.sample.tmdb.domain.model.MovieDetails
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailRepository @Inject constructor(
    private val movieApi: MovieService,
    @ApplicationContext context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
) : BaseDetailRepository<MovieDetails>(context, ioDispatcher) {

    override suspend fun getDetails(id: Int): MovieDetails =
        movieApi.fetchMovieDetail(id).asDomainModel()

    override suspend fun getCredit(id: Int) = movieApi.movieCredit(id)
}