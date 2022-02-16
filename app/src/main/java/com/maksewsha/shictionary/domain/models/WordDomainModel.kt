package com.maksewsha.shictionary.domain.models

data class WordDomainModel(
    var wordName: String,
    var phonetics: List<WordModel.Phonetic>,
    var meanings: List<WordModel.Meaning>
) : WordModel

data class Phonetics(
    var text: String,
    var audio: String
) : WordModel.Phonetic

data class Meaning(
    var partOfSpeech: String,
    var definitions: List<WordModel.Meaning.Definition>
) : WordModel.Meaning

data class Definition(
    var definition: String,
    var example: String,
    var synonyms: List<String>
) : WordModel.Meaning.Definition