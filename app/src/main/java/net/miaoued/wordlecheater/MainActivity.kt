package net.miaoued.wordlecheater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordTryList = mutableListOf<WordTry>()
        val rv = findViewById<RecyclerView>(R.id.wordTryRecyclerView)
            .apply {
                layoutManager = LinearLayoutManager(this@MainActivity).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }
                adapter = WordTryListAdapter(wordTryList)
                itemAnimator = null
            }

        findViewById<Button>(R.id.addButton).setOnClickListener {
            addWordTry(
                wordTryList,
                findViewById<EditText>(R.id.wordEditText).text.toString()
            )
            rv.adapter!!.notifyDataSetChanged()
        }
    }

    private fun addWordTry(wordTryList: MutableList<WordTry>, wordString: String) {
        if (wordTryList.size >= 5) {
            return
        }

        val word = wordString.uppercase()
        val formatRegex = Regex("^[A-Z]{5}$")
        if (word.matches(formatRegex)) {
            wordTryList.add(
                WordTry(
                    word.toCharArray().toTypedArray(),
                    WordTry.DEFAULT_STATUS
                )
            )
        } else {
            Toast.makeText(
                this,
                getString(R.string.word_input_not_valid),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}