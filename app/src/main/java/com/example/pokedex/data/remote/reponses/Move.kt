package com.example.pokedex.data.remote.reponses

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)