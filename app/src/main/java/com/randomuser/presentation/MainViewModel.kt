package com.randomuser.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.randomuser.data.mapper.UserMapper
//import com.randomuser.data.mapper.UserMapper
import com.randomuser.data.model.UserResponse
import com.randomuser.data.network.ApiFactory
import com.randomuser.domain.UserDomain
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val user = UserDomain("Vitalii", "Kozel", "https://www.agroxxi.ru/images/kozel(4).jpg")

    private val _liveUser = MutableLiveData<UserDomain>()
    val liveUser: LiveData<UserDomain>
        get() = _liveUser

    fun loadUser() {
        ApiFactory.getUsers().enqueue(object : Callback<UserResponse> {

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val userResponse = response.body()?.results?.get(0)
                if (userResponse != null)
                    _liveUser.value = UserMapper.mapUserResponseToUser(userResponse)
//                    _liveUser.value = user
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                //Log.d("MainActivity", t.localizedMessage)
                _liveUser.value = user
            }

        })
    }
}