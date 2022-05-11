package net.miaoued.wordlecheater

data class WordTry(
    val letters: CharArray,
    val status: IntArray
) {
    var mustUse = 0
    val usables = IntArray(5) {(1 shl 26) - 1}

    init {
        rebuild()
    }

    private fun rebuild() {
        for (i in 0..4) {
            val letterIndex = letters[i].code - 'A'.code
            when (status[i]) {
                LETTER_NOT_IN_USE -> {
                    for (j in 0..4) {
                        usables[j] = usables[j] and (((1 shl 26) - 1) xor (1 shl letterIndex)).inv()
                    }
                }

                LETTER_IN_USE -> {
                    usables[i] = usables[i] and (((1 shl 26) - 1) xor (1 shl letterIndex).inv())
                    mustUse = mustUse or (1 shl letterIndex)
                }

                LETTER_CORRECT -> {
                    usables[i] = usables[i] and (1 shl letterIndex)
                    mustUse = mustUse or (1 shl letterIndex)
                }
            }
        }
    }

    fun changeStatus(letterPosition: Int) {
        status[letterPosition] = (status[letterPosition] + 1) % 3
        rebuild()
    }

    override fun hashCode(): Int {
        var result = letters.contentHashCode()
        result = 31 * result + status.contentHashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WordTry

        if (!letters.contentEquals(other.letters)) return false
        if (!status.contentEquals(other.status)) return false

        return true
    }

    companion object {
        const val LETTER_NOT_IN_USE = 0
        const val LETTER_IN_USE = 1
        const val LETTER_CORRECT = 2
        val DEFAULT_STATUS = IntArray(5) {0}
    }
}