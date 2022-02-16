package com.maksewsha.shictionary.data.models

import com.maksewsha.shictionary.domain.models.ErrorType
import com.maksewsha.shictionary.domain.models.WordModel

sealed class WordInfoData {

    class Success(val wordData: WordDataModel) : WordInfoData()
    class Fail(val errorType: ErrorType) : WordInfoData()

}