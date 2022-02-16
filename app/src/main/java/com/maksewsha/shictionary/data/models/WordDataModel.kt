package com.maksewsha.shictionary.data.models

import com.google.gson.annotations.SerializedName
import com.maksewsha.shictionary.domain.models.WordModel

data class WordDataModel(
    @SerializedName("word")
    var wordName: String?,
    @SerializedName("phonetics")
    var phonetics: List<WordModel.Phonetic>?,
    @SerializedName("meanings")
    var meanings: List<WordModel.Meaning>?
) : WordModel

data class Phonetics(
    @SerializedName("text")
    var text: String?,
    @SerializedName("audio")
    var audio: String?
) : WordModel.Phonetic

data class Meaning(
    @SerializedName("partOfSpeech")
    var partOfSpeech: String?,
    @SerializedName("definitions")
    var definitions: List<WordModel.Meaning.Definition>?
) : WordModel.Meaning

data class Definition(
    @SerializedName("definition")
    var definition: String?,
    @SerializedName("example")
    var example: String?,
    @SerializedName("synonyms")
    var synonyms: List<String>?
) : WordModel.Meaning.Definition