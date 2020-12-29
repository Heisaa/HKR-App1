package com.example.hkr_app1

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Score(score : Int) {
    val score = score
    var time: String

    init {
        val now = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm   dd.MM.yyyy.")
        time = now.format(formatter)
    }

}