package com.maksewsha.shictionary.data.util

import com.maksewsha.shictionary.data.models.WordInfoData
import com.maksewsha.shictionary.domain.models.WordDomainModel
import com.maksewsha.shictionary.domain.models.WordInfoDomain
import com.maksewsha.shictionary.domain.util.EntityMapper

class DataToDomainMapper: EntityMapper<WordInfoData, WordInfoDomain> {
    override fun mapFromEntity(entity: WordInfoData): WordInfoDomain {
        when(entity){
            is WordInfoData.Success -> {
                return WordInfoDomain.Success(
                    wordInfo = WordDomainModel(
                        wordName = entity.wordData.wordName!!,
                        phonetics = entity.wordData.phonetics!!,
                        meanings = entity.wordData.meanings!!
                    )
                )
            }
            is WordInfoData.Fail -> {
                return WordInfoDomain.Fail(
                    error = entity.errorType
                )
            }
        }
    }
}