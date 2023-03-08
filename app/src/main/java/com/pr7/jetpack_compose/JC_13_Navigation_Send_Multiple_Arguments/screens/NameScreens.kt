package com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.screens

const val ARGUMENT_KEY="id"
const val ARGUMENT_KEY2="name"

sealed class NameScreens constructor(val route:String){
    object Adobe:NameScreens(route = "adobe_screen")
    object Youtube:NameScreens(route = "youtube_screen/{$ARGUMENT_KEY}/{$ARGUMENT_KEY2}"){
//        fun passId(id:Int):String{
//            return "youtube_screen/$id"
//        }
        fun passNamdAndId(
            id:Int,
            name:String
        ):String{
            return "youtube_screen/$id/$name"
        }
    }

}