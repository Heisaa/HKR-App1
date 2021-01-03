package com.example.hkr_app1

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Score(score : Int, difficulty: String?) {
    val score = score
    val difficulty = difficulty
    var time: String

    init {
        val now = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm   dd.MM.yyyy.")
        time = now.format(formatter)
    }

}