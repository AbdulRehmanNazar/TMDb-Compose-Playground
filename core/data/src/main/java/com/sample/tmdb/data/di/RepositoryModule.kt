package com.sample.tmdb.data.di

import com.sample.tmdb.common.base.BaseRepository
import com.sample.tmdb.domain.model.*
import com.sample.tmdb.data.repository.*
import com.sample.tmdb.data.repository.movie.BookmarkMovieDetailsRepositoryImpl
import com.sample.tmdb.data.repository.movie.BookmarkMovieRepository
import com.sample.tmdb.data.repository.movie.DiscoverMoviesPagingRepository
import com.sample.tmdb.data.repository.movie.MovieDetailRepository
import com.sample.tmdb.data.repository.movie.MovieFeedRepository
import com.sample.tmdb.data.repository.movie.NowPlayingMoviesPagingRepository
import com.sample.tmdb.data.repository.movie.PopularMoviesPagingRepository
import com.sample.tmdb.data.repository.movie.SearchMoviesPagingRepository
import com.sample.tmdb.data.repository.movie.SimilarMoviesPagingRepository
import com.sample.tmdb.data.repository.movie.TopRatedMoviesPagingRepository
import com.sample.tmdb.data.repository.movie.TrendingMoviesPagingRepository
import com.sample.tmdb.data.repository.movie.UpcomingMoviesPagingRepository
import com.sample.tmdb.data.repository.tvshow.AiringTodayTvSeriesPagingRepository
import com.sample.tmdb.data.repository.tvshow.BookmarkTVShowDetailsRepositoryImpl
import com.sample.tmdb.data.repository.tvshow.BookmarkTVShowRepository
import com.sample.tmdb.data.repository.tvshow.DiscoverTvSeriesPagingRepository
import com.sample.tmdb.data.repository.tvshow.OnTheAirTvSeriesPagingRepository
import com.sample.tmdb.data.repository.tvshow.PopularTvSeriesPagingRepository
import com.sample.tmdb.data.repository.tvshow.SearchTvSeriesPagingRepository
import com.sample.tmdb.data.repository.tvshow.SimilarTvSeriesPagingRepository
import com.sample.tmdb.data.repository.tvshow.TVShowDetailRepository
import com.sample.tmdb.data.repository.tvshow.TVShowFeedRepository
import com.sample.tmdb.data.repository.tvshow.TopRatedTvSeriesPagingRepository
import com.sample.tmdb.data.repository.tvshow.TrendingTvSeriesPagingRepository
import com.sample.tmdb.domain.utils.Discover
import com.sample.tmdb.domain.utils.Latest
import com.sample.tmdb.domain.utils.NowPlaying
import com.sample.tmdb.domain.utils.Popular
import com.sample.tmdb.domain.utils.Search
import com.sample.tmdb.domain.utils.TopRated
import com.sample.tmdb.domain.utils.Trending
import com.sample.tmdb.domain.repository.BaseDetailRepository
import com.sample.tmdb.domain.repository.BaseFeedRepository
import com.sample.tmdb.domain.repository.BasePagingRepository
import com.sample.tmdb.domain.repository.BookmarkItemDetailsRepository
import com.sample.tmdb.domain.utils.Similar
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindMovieFeedRepository(movieFeedRepository: MovieFeedRepository): BaseFeedRepository<Movie>

    @Singleton
    @Binds
    internal abstract fun bindTVShowFeedRepository(tvShowFeedRepository: TVShowFeedRepository): BaseFeedRepository<TVShow>

    @Singleton
    @Binds
    internal abstract fun bindMovieDetailRepository(movieDetailRepository: MovieDetailRepository): BaseDetailRepository<MovieDetails>

    @Singleton
    @Binds
    internal abstract fun bindTVShowDetailRepository(tvShowDetailRepository: TVShowDetailRepository): BaseDetailRepository<TvDetails>

    @Singleton
    @Trending
    @Binds
    internal abstract fun bindTrendingMoviesRepository(trendingMoviesPagingRepository: TrendingMoviesPagingRepository): BasePagingRepository<Movie>

    @Singleton
    @Popular
    @Binds
    internal abstract fun bindPopularMoviesRepository(popularMoviesPagingRepository: PopularMoviesPagingRepository): BasePagingRepository<Movie>

    @Singleton
    @NowPlaying
    @Binds
    internal abstract fun bindNowPlayingMoviesRepository(nowPlayingMoviesPagingRepository: NowPlayingMoviesPagingRepository): BasePagingRepository<Movie>

    @Singleton
    @Latest
    @Binds
    internal abstract fun bindUpcomingMoviesRepository(upcomingMoviesPagingRepository: UpcomingMoviesPagingRepository): BasePagingRepository<Movie>

    @Singleton
    @TopRated
    @Binds
    internal abstract fun bindTopRatedMoviesRepository(topRatedMoviesPagingRepository: TopRatedMoviesPagingRepository): BasePagingRepository<Movie>

    @Singleton
    @Discover
    @Binds
    internal abstract fun bindDiscoverMoviesRepository(discoverMoviesPagingRepository: DiscoverMoviesPagingRepository): BasePagingRepository<Movie>

    @Singleton
    @Similar
    @Binds
    internal abstract fun bindSimilarMoviesRepository(similarMoviesPagingRepository: SimilarMoviesPagingRepository): BasePagingRepository<Movie>


    @Singleton
    @Search
    @Binds
    internal abstract fun bindSearchMoviesRepository(searchMoviesPagingRepository: SearchMoviesPagingRepository): BasePagingRepository<Movie>

    @Singleton
    @Trending
    @Binds
    internal abstract fun bindTrendingTVShowRepository(trendingTvSeriesPagingRepository: TrendingTvSeriesPagingRepository): BasePagingRepository<TVShow>

    @Singleton
    @Popular
    @Binds
    internal abstract fun bindPopularTVShowRepository(popularTvSeriesPagingRepository: PopularTvSeriesPagingRepository): BasePagingRepository<TVShow>

    @Singleton
    @NowPlaying
    @Binds
    internal abstract fun bindAiringTodayTVShowRepository(airingTodayTvSeriesPagingRepository: AiringTodayTvSeriesPagingRepository): BasePagingRepository<TVShow>

    @Singleton
    @Latest
    @Binds
    internal abstract fun bindOnTheAirTVShowRepository(onTheAirTvSeriesPagingRepository: OnTheAirTvSeriesPagingRepository): BasePagingRepository<TVShow>

    @Singleton
    @TopRated
    @Binds
    internal abstract fun bindTopRatedTVShowRepository(topRatedTvSeriesPagingRepository: TopRatedTvSeriesPagingRepository): BasePagingRepository<TVShow>

    @Singleton
    @Discover
    @Binds
    internal abstract fun bindDiscoverTVShowRepository(discoverTvSeriesPagingRepository: DiscoverTvSeriesPagingRepository): BasePagingRepository<TVShow>

    @Singleton
    @Similar
    @Binds
    internal abstract fun bindSimilarTVShowRepository(similarTvSeriesPagingRepository: SimilarTvSeriesPagingRepository): BasePagingRepository<TVShow>


    @Singleton
    @Search
    @Binds
    internal abstract fun bindSearchTVShowRepository(searchTvSeriesPagingRepository: SearchTvSeriesPagingRepository): BasePagingRepository<TVShow>

    @Singleton
    @Binds
    internal abstract fun bindPersonRepository(personRepository: PersonRepository): BaseRepository<Person>

    @Singleton
    @Binds
    internal abstract fun bindBookmarkMovieDetailsRepository(bookmarkMovieDetailsRepository: BookmarkMovieDetailsRepositoryImpl): BookmarkItemDetailsRepository<Movie>

    @Singleton
    @Binds
    internal abstract fun bindBookmarkTVShowDetailsRepository(bookmarkTVShowDetailsRepository: BookmarkTVShowDetailsRepositoryImpl): BookmarkItemDetailsRepository<TVShow>

    @Singleton
    @Binds
    @JvmSuppressWildcards
    internal abstract fun bindBookmarkMovieRepository(bookmarkMovieRepository: BookmarkMovieRepository): BaseRepository<List<Movie>>

    @Singleton
    @Binds
    @JvmSuppressWildcards
    internal abstract fun bindBookmarkTVShowRepository(bookmarkTVShowRepository: BookmarkTVShowRepository): BaseRepository<List<TVShow>>

}