package com.example.shemajamebeli8.models

import com.google.gson.annotations.SerializedName

data class Action(
    val goalType: Int?,
    @SerializedName("player",alternate = ["player1"])
    val player1: Player1?,
    val player2: Player2?
)