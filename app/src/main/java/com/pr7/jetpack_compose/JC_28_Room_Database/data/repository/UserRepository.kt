package com.pr7.jetpack_compose.JC_28_Room_Database.data.repository

import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.User
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.UserDao
import kotlinx.coroutines.flow.Flow


class UserRepository constructor(
    val userDao: UserDao
) {
    fun getAllUsers():Flow<List<User>>{
        return userDao.getAllUsers()
    }
    suspend fun save(user: User){
        userDao.insertUser(user)
    }
    suspend fun update(user: User){
        userDao.updateUser(user)
    }
    suspend fun delete(user: User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAlluser(){
        userDao.deleteAllUsers()
    }

}