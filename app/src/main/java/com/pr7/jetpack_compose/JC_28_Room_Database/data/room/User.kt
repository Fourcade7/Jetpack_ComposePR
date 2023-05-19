package com.pr7.jetpack_compose.JC_28_Room_Database.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pr7.jetpack_compose.JC_28_Room_Database.Constants.TABLE_NAME


@Entity(tableName = TABLE_NAME)
class User constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val uid:Int,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "surname")
    val surname:String,
)