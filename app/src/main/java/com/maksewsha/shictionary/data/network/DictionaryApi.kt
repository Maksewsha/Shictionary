package com.maksewsha.shictionary.data.network

import com.maksewsha.shictionary.data.models.WordDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    @GET("./{word}")
    suspend fun getWord(@Path("word") word: String): WordDataModel
}