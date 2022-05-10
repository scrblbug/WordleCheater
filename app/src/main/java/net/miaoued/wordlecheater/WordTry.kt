package net.miaoued.wordlecheater

data class WordTry(
    val word: CharArray,
    val status: IntArray
) {

    override fun hashCode(): Int {
        var result = word.contentHashCode()
        result = 31 * result + status.contentHashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WordTry

        if (!word.contentEquals(other.word)) return false
        if (!status.contentEquals(other.status)) return false

        return true
    }

    companion object {
        const val LETTER_NOT_IN_USE = 0
        const val LETTER_IN_USE = 1
        const val LETTER_CORRECT = 2
        val DEFAULT_STATUS = intArrayOf(0, 0, 0, 0, 0)
    }
}