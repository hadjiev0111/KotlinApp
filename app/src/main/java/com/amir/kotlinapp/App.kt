package com.amir.kotlinapp

import android.app.Application
import com.amir.kotlinapp.data.repository.Repository

class App : Application() {

    companion object{
        lateinit var repository: Repository
    }

    override fun onCreate() {
        super.onCreate()
        repository = Repository()
    }


}