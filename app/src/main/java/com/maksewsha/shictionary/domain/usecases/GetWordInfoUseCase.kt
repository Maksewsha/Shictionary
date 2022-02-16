package com.maksewsha.shictionary.domain.usecases

import com.maksewsha.shictionary.domain.models.WordInfoDomain
import com.maksewsha.shictionary.domain.repository.WordRepository

class GetWordInfoUseCase(private val wordRepository: WordRepository) {

    fun getWordInfo(word: String): WordInfoDomain{
        return wordRepository.getWord(word)
    }
}