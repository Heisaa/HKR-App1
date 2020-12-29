package com.example.hkr_app1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val listViewScore = findViewById<ListView>(R.id.listScore)
        val scoreList = mutableListOf<Score>()
        val scoreNum = intent.getIntExtra("score", 0)

        val score = Score(scoreNum)
        scoreList.add(score)

        listViewScore.adapter = MyListAdapter(this, scoreList)
    }

    private class MyListAdapter(private val context: Context, private val scoreList: MutableList<Score>) : BaseAdapter() {
        override fun getCount(): Int {
            return scoreList.size
        }

        override fun getItem(position: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(context)
            val row = layoutInflater.inflate(R.layout.item_list, parent, false)

            val textScore = row.findViewById<TextView>(R.id.textScore)
            val textTime = row.findViewById<TextView>(R.id.textTime)

            textScore.text = "Score: ${scoreList.get(position).score.toString()}"
            textTime.text = scoreList.get(position).time

            return row
        }

    }
}