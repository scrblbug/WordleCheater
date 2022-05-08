package net.miaoued.wordlecheater

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordTryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val letters = arrayOf<TextView>(
        itemView.findViewById(R.id.letter1),
        itemView.findViewById(R.id.letter2),
        itemView.findViewById(R.id.letter3),
        itemView.findViewById(R.id.letter4),
        itemView.findViewById(R.id.letter5)
    )

    val removeButton: Button = itemView.findViewById<Button>(R.id.removeButton)
}