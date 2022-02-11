package com.maksewsha.shictionary.data.network

import com.maksewsha.shictionary.data.models.WordData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface DisctionaryApi {
    @GET("./{word}")
    fun getWord(@Path("word") word: String): Deferred<WordData>
}