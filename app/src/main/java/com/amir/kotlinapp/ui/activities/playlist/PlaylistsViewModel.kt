package com.amir.kotlinapp.ui.activities.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amir.kotlinapp.App
import com.amir.kotlinapp.data.model.VideoInfo

class PlaylistsViewModel : ViewModel() {

    var playlists = MutableLiveData<MutableList<VideoInfo.Info>>()
    fun setPlaylists(){
        playlists = App.repository.loadPlaylists()
    }
}