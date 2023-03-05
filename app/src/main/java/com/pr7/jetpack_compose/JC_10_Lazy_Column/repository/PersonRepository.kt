package com.pr7.jetpack_compose.JC_10_Lazy_Column.repository

import com.pr7.jetpack_compose.JC_10_Lazy_Column.model.Person

class PersonRepository  {

    fun getallData():List<Person>{
        val mylist= listOf(
            Person(id = 0, name = "Pr",),
            Person(id = 1, name = "Ae",),
            Person(id = 2, name = "Ps",),
            Person(id = 3, name = "Ai",),
        )
        return mylist
    }
}