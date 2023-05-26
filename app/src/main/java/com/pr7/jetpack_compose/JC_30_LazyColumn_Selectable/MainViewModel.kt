package com.pr7.jetpack_compose.JC_30_LazyColumn_Selectable

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class MainViewModel constructor():ViewModel() {


    val mutableLiveData=MutableLiveData<ArrayList<Laptop>>()
    fun additem(laptop:Laptop){
        val emptyarraylist=ArrayList(mutableLiveData.value.orEmpty())
        emptyarraylist.add(laptop)
        mutableLiveData.value=emptyarraylist

    }
    fun deleteitem(laptop: Laptop){
        val emptyarraylist=ArrayList(mutableLiveData.value.orEmpty())
        emptyarraylist.remove(laptop)
        mutableLiveData.value?.removeAll(emptyarraylist)
    }


    //use flow
    val mutablestateflow= MutableStateFlow(ArrayList<Laptop>())

    fun insertitem(laptop: Laptop){
        val emptyarraylist=mutablestateflow.value
        emptyarraylist.add(laptop)
        mutablestateflow.value=emptyarraylist
    }
    fun removeitem(laptop: Laptop){
        val emptyarraylist=mutablestateflow.value
        emptyarraylist.remove(laptop)
        mutablestateflow.value=emptyarraylist

    }

}