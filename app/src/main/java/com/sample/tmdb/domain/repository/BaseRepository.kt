package com.sample.tmdb.domain.repository

import android.content.Context
import com.sample.tmdb.R
import com.sample.tmdb.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository<T>(
    private val context: Context,
    private val ioDispatcher: CoroutineDispatcher
) {
    protected abstract suspend fun getSuccessResult(id: Any?): T

    fun getResult(id: Any?): Flow<Resource<T>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(getSuccessResult(id)))
        } catch (t: Throwable) {
            emit(Resource.Error(context.getString(R.string.failed_loading_msg)))
        }
    }.flowOn(ioDispatcher)
}