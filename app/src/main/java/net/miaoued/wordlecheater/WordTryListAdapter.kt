package net.miaoued.wordlecheater

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WordTryListAdapter(private val data: MutableList<WordTry>)
    : RecyclerView.Adapter<WordTryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordTryViewHolder {
        return WordTryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.word_try,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: WordTryViewHolder, position: Int) {
        for (i in 0..4) {
            holder.letters[i].text = data[position].letters[i].toString()
            when (data[position].status[i]) {
                WordTry.LETTER_NOT_IN_USE ->
                    holder.letters[i].setBackgroundColor(Color.GRAY)
                WordTry.LETTER_IN_USE ->
                    holder.letters[i].setBackgroundColor(Color.YELLOW)
                WordTry.LETTER_CORRECT ->
                    holder.letters[i].setBackgroundColor(Color.GREEN)
            }

            holder.letters[i].setOnClickListener {
                data[position].changeStatus(i)
                notifyItemChanged(position)
            }
        }

        holder.removeButton.setOnClickListener {
            data.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, data.size)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
