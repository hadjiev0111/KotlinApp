package com.amir.kotlinapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.amir.kotlinapp.`object`.Constants.API_KEY
import com.amir.kotlinapp.`object`.Constants.CHANNEL_ID
import com.amir.kotlinapp.`object`.Constants.PART
import com.amir.kotlinapp.data.model.VideoInfo
import com.amir.kotlinapp.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Response

class Repository {

    var playlistsLiveData : MutableLiveData<MutableList<VideoInfo.Info>> = MutableLiveData()


    fun loadPlaylists():MutableLiveData<MutableList<VideoInfo.Info>>{
        ApiClient.getInstance().getPlaylists(PART, CHANNEL_ID, API_KEY).enqueue(object : retrofit2.Callback<VideoInfo>{
            override fun onResponse(
                call: Call<VideoInfo>,
                response: Response<VideoInfo>
            ) {
                val data = response.body()
                val list = data!!.items
                playlistsLiveData.value = list
            }

            override fun onFailure(call: Call<VideoInfo>, t: Throwable) {
            }
        })
        return playlistsLiveData
    }
}