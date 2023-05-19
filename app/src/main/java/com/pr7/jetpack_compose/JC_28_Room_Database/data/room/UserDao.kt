package com.pr7.jetpack_compose.JC_28_Room_Database.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.pr7.jetpack_compose.JC_28_Room_Database.Constants.TABLE_NAME
import kotlinx.coroutines.flow.Flow

//Room 🔗 Coroutines
//DAO methods can now be marked as suspending to ensure that they are not executed on the main thread.
@Dao
interface UserDao {
   // On the other hand, getAllUsers() functions of UserDao returns a coroutine Flow.  Therefore, there is no requirement to write a suspending function for that.
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllUsers(): Flow<List<User>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAllUsers()
    @Query("SELECT * FROM $TABLE_NAME WHERE id=:idd ")
    suspend fun loadbyid(idd:Int): User
}