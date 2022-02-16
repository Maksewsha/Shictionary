package com.maksewsha.shictionary.domain.models

sealed class WordInfoDomain {
    class Success(val wordInfo: WordModel): WordInfoDomain()
    class Fail(val error: ErrorType): WordInfoDomain()
}