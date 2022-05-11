package net.miaoued.wordlecheater

import android.content.Context

class WordValidator(private val mainContext: Context) {
    lateinit var validWordList: MutableList<String>
    init {
        reset()
    }

    private fun reset(){
        validWordList = mainContext.assets.open("validwords.txt")
            .bufferedReader().use(){
                it.readLines().toMutableList()
            }
    }

    private fun isValidOnWordTry(word:String, condition: WordTry): Boolean {
        var used = 0
        for (i in 0..4) {
            val letterIndex = word[i].code - 'A'.code
            used = used or (1 shl letterIndex)

            if (condition.usables[i] and (1 shl letterIndex) == 0) return false
        }
        if ((condition.mustUse and used) != condition.mustUse) return false

        return true
    }

    private fun filterByWordTry(wordTry: WordTry) {
        val newList = mutableListOf<String>()
        for (word in validWordList) {
            if (isValidOnWordTry(word, wordTry)) newList.add(word)
        }
        validWordList = newList
    }

    fun filterByWordTryList(wordTryList: MutableList<WordTry>) {
        for (wordTry in wordTryList) filterByWordTry(wordTry)
    }
}
