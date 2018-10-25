package com.periferia.metas_amway.login.presenters

import com.periferia.metas_amway.login.interfaces.Info
import com.periferia.metas_amway.login.models.RegisterInfoModel


class RegisterInfoPresenter(view:Info.View): Info.Presenter {

    private var view: Info.View
    private var model: Info.Model

    init {
        this.view = view
        model = RegisterInfoModel(this)
    }

    override fun saveData(id: String, name: String, birthday: String, country: String, city: String, email: String) {
        model.storageData(id,name,birthday,country,city,email)

    }

    override fun confirmStorage() {
        view.saveDataConfirmation()
    }
}