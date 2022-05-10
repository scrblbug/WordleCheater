package net.miaoued.wordlecheater

import android.content.Context

class WordValidator(context: Context) {
    private val validWordList = context.assets.open("validwords.txt")
        .bufferedReader().use(){
            it.readLines()
        }

    val letterUsable = List(5){IntArray(26){0}}


}
