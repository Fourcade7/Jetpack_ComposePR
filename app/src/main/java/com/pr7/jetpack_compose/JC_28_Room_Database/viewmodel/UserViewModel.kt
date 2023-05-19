package com.pr7.jetpack_compose.JC_28_Room_Database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pr7.jetpack_compose.JC_28_Room_Database.data.repository.UserRepository
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.AppDatabase
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.User
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel constructor(
    val context: Application
) : AndroidViewModel(context) {

    val userDao: UserDao =AppDatabase.getInstance(context).userDao()
    val userRepository:UserRepository= UserRepository(userDao)
    var mutableLiveData=MutableLiveData<List<User>>()

    fun getAllUsers(): MutableLiveData<List<User>> {

        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getAllUsers().collect{
                mutableLiveData.postValue(it)
            }
        }
        return mutableLiveData
    }
   fun save(user: User){
       viewModelScope.launch(Dispatchers.IO) {
           userRepository.save(user)
       }
    }
    fun update(user: User)=viewModelScope.launch(Dispatchers.IO){
        userRepository.update(user)
    }
   fun delete(user: User)=viewModelScope.launch(Dispatchers.IO){
        userRepository.delete(user)
    }
    fun deleteAlluser()=viewModelScope.launch(Dispatchers.IO){
        userRepository.deleteAlluser()
    }

}