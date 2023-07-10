package com.example.weathermd.presenters

import com.example.weathermd.view.MainView

class MainPresenter : BasePresenter<MainView>(){
//TODO тут будет переменная репозитория

    override fun enable() {

    }

    fun refresh(lat: String, lon: String){
        viewState.setLoading(true)
        // TODO тут будет обращение к репозиторию

    }
}