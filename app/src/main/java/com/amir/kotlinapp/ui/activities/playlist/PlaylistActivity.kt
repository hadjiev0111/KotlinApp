package com.amir.kotlinapp.ui.activities.playlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amir.kotlinapp.R
import com.amir.kotlinapp.data.model.VideoInfo
import com.amir.kotlinapp.ui.activities.disconnect.DisconnectActivity
import com.amir.kotlinapp.ui.adapters.PlaylistsAdapter
import com.amir.kotlinapp.utils.isConnected
import kotlinx.android.synthetic.main.activity_playlist.*

class PlaylistActivity : AppCompatActivity() {

    private lateinit var model : PlaylistsViewModel

    private lateinit var adapter: PlaylistsAdapter

    private val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)
        if (!this.isConnected(this)){
            var intent = Intent(this, DisconnectActivity::class.java)
            startActivity(intent)
        }
        initAdapter()
        populateAdapter()
        model = PlaylistsViewModel()
        model.setPlaylists()
        model.playlists.observe(this, Observer {
            adapter.addItems(it!!)
        })

    }

    private fun populateAdapter(){
        var testSnippet = VideoInfo.Snippet(title = "Название Тест", description = "Описание Тест")
        var test = VideoInfo.Info("1", testSnippet)

        var testSnippet2 =
            VideoInfo.Snippet(title = "Название Тест2", description = "Описание Тест2")
        var test2 = VideoInfo.Info("2", testSnippet2)

        var list = mutableListOf<VideoInfo.Info>()
        list.add(test)
        list.add(test2)
        adapter.addItems(list)
    }

    private fun initAdapter() {
        adapter = PlaylistsAdapter()
        layoutManager.orientation = RecyclerView.VERTICAL
        rv_playlist.layoutManager = layoutManager
        rv_playlist.itemAnimator = DefaultItemAnimator()
        rv_playlist.adapter = adapter
        rv_playlist.isNestedScrollingEnabled = true
    }


}                                                                                                                                                                                                                                                                                                                                                              //amir lox