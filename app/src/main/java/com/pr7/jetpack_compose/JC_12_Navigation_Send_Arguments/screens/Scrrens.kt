package com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.screens

const val DETAIL_ARGUMENT_KEY = "id"

sealed class Scrrens constructor(
    val route: String
) {
    object Google : Scrrens("google_screen")
    object Yandex : Scrrens("yandex_screen/{$DETAIL_ARGUMENT_KEY}") {
        fun passId(id: Int): String {
            return "yandex_screen/$id"
        }
    }
}
