package com.example.shemajamebeli8.viewModels

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli8.api.RetrofitService
import com.example.shemajamebeli8.models.Moedl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val itemsLiveData = MutableLiveData<Moedl>().apply {
        mutableListOf<Moedl>()
    }

    val _itemsLiveData : MutableLiveData<Moedl> = itemsLiveData



    fun init(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getItems()
            }
        }

    }

    private suspend fun  getItems(){


        val itemsList = RetrofitService.RetrofitService().getList()
        if (itemsList.isSuccessful){
            val items = itemsList.body()
            d("msg","${items}")
            itemsLiveData.postValue(items)
        }else {
            itemsList.code()
        }


    }

}