package com.pr7.jetpack_compose.JC_28_Room_Database.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pr7.jetpack_compose.JC_28_Room_Database.Constants.DATABASE_NAME

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {


        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE!!
        }


    }
}