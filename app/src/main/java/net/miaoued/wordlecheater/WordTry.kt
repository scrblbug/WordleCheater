package net.miaoued.wordlecheater

data class WordTry(
    val word: Array<Char>,
    val status: Array<Int>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WordTry

        if (!word.contentEquals(other.word)) return false
        if (!status.contentEquals(other.status)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = word.contentHashCode()
        result = 31 * result + status.contentHashCode()
        return result
    }

    companion object {
        val LETTER_NOT_IN_USE = 0
        val LETTER_IN_USE = 1
        val LETTER_CORRECT = 2
        val DEFAULT_STATUS = arrayOf(0, 0, 0, 0, 0)
    }
}