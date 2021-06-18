package com.example.shemajamebeli8.models

data class Match(
    val matchDate: Long?,
    val matchSummary: MatchSummary?,
    val matchTime: Double?,
    val stadiumAdress: String?,
    val team1: Team1?,
    val team2: Team2?
)