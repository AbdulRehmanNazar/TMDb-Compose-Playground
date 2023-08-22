package com.sample.tmdb.domain

import android.content.Context
import com.sample.tmdb.data.response.NetworkCreditWrapper
import com.sample.tmdb.data.response.asCastDomainModel
import com.sample.tmdb.data.response.asCrewDomainModel
import com.sample.tmdb.domain.model.DetailWrapper
import com.sample.tmdb.domain.model.TMDbItemDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

abstract class BaseDetailRepository<T : TMDbItemDetails>(
    context: Context,
    ioDispatcher: CoroutineDispatcher
) : BaseRepository<DetailWrapper<T>>(context, ioDispatcher) {

    protected abstract suspend fun getDetails(id: Int): T

    protected abstract suspend fun getCredit(id: Int): NetworkCreditWrapper

    override suspend fun getSuccessResult(id: Any?): DetailWrapper<T> {
        val detailsDeferred: Deferred<T>
        val creditDeferred: Deferred<NetworkCreditWrapper>
        coroutineScope {
            detailsDeferred = async { getDetails(id as Int) }
            creditDeferred = async { getCredit(id as Int) }
        }
        val details = detailsDeferred.await()
        val networkCreditWrapper = creditDeferred.await()

        val cast = networkCreditWrapper.cast.asCastDomainModel()
        val crew = networkCreditWrapper.crew.asCrewDomainModel()

        return DetailWrapper(cast, crew, details)
    }
}