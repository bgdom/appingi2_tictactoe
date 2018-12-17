package com.epita.dom.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() , View.OnClickListener{
    val tab = Array(9, {0})
    var turn: Int ?= null
    var name : String ?= null

    fun isGameFinished(): Int {
        var res = 0
        if (tab[0]!= 0 &&  tab[0]== tab[3] && tab[3]== tab[6])
            res=tab[0]
        if (tab[1]!= 0 &&  tab[1]== tab[4] && tab[4]== tab[7])
            res=tab[1]
        if (tab[2]!= 0 &&  tab[2]== tab[5]  && tab[5] == tab[8])
            res=tab[2]
        if (tab[0]!= 0 &&  tab[0]== tab[1] && tab[1]== tab[2])
            res=tab[0]
        if (tab[4]!= 0 &&  tab[4]== tab[5] && tab[5] == tab[3])
            res=tab[3]
        if (tab[7]!= 0 &&  tab[7]== tab[8] && tab[8]== tab[6])
            res=tab[6]
        if (tab[0]!= 0 &&  tab[0]== tab[4] && tab[4] == tab[8])
            res=tab[0]
        if (tab[2]!= 0 &&  tab[2]== tab[4] && tab[4]== tab[6])
            res=tab[2]

        if (res==1)
            return 1
        else if(res==2)
            return 2
        return 0
    }

    override fun onClick(v: View?) {
        var id: Int = v!!.tag.toString().toInt()
        if(tab[id] != 0)
            return

        val txt: TextView = v as TextView
        if(turn == 1) {
            txt.text = "X"
            tab[id] = 1
            turn = 2
        }else {
            turn = 1
            txt.text = "0"
            tab[id] = 2
        }

        val res = isGameFinished()
        if(res != 0){
            val intent = Intent(this@GameActivity, ScoreActivity::class.java)
            intent.putExtra("res_id", res)
            var n: String = ""
            if(res == 1)
                n = name!!
            else
                n= "Guest"
            intent.putExtra("name", n)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        turn = (1..2).random()

        name = intent.getStringExtra("name")
        txt_name_player.text = "O ($name)"

        txt_1_1.setOnClickListener(this@GameActivity)
        txt_1_2.setOnClickListener(this@GameActivity)
        txt_1_3.setOnClickListener(this@GameActivity)

        txt_2_1.setOnClickListener(this@GameActivity)
        txt_2_2.setOnClickListener(this@GameActivity)
        txt_2_3.setOnClickListener(this@GameActivity)

        txt_3_1.setOnClickListener(this@GameActivity)
        txt_3_2.setOnClickListener(this@GameActivity)
        txt_3_3.setOnClickListener(this@GameActivity)
    }
}
