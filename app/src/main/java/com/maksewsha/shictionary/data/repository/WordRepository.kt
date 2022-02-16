package com.maksewsha.shictionary.data.repository

import android.content.SharedPreferences
import com.maksewsha.shictionary.data.models.WordInfoData
import com.maksewsha.shictionary.data.network.DictionaryApi
import com.maksewsha.shictionary.data.util.DataToDomainMapper
import com.maksewsha.shictionary.domain.models.WordInfoDomain
import com.maksewsha.shictionary.domain.repository.WordRepository

class WordRepository
constructor(private val dictionaryApi: DictionaryApi, private val sharedPrefs: SharedPreferences): WordRepository{

    private val mapper = DataToDomainMapper()

    override suspend fun getWord(word: String): WordInfoDomain{
        //TODO
    }
}