package com.maksewsha.shictionary.domain.repository

import com.maksewsha.shictionary.domain.models.WordInfoDomain

interface WordRepository {
    suspend fun getWord(word: String): WordInfoDomain
}