package net.miaoued.wordlecheater

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ResultShowActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_show)

        findViewById<ListView>(R.id.resultListView).apply {
            adapter = ArrayAdapter(
                this@ResultShowActivity,
                android.R.layout.simple_list_item_1,
                intent.getStringArrayListExtra("validWordList")!!.toList()
            )
        }

        findViewById<Button>(R.id.backFromResultButton).setOnClickListener {
            finish()
        }
    }
}