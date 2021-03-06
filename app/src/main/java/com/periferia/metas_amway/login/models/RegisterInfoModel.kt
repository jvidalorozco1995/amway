package com.periferia.metas_amway.login.models

import com.periferia.metas_amway.login.interfaces.Info

class RegisterInfoModel(presenter: Info.Presenter): Info.Model {

    private val presenter: Info.Presenter = presenter


    override fun storageData(id: String, name: String, birthday: String, country: String, city: String, email: String) {
        presenter.confirmStorage()
    }
}