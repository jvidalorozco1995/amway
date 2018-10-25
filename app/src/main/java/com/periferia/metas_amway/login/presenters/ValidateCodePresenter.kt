package com.periferia.metas_amway.login.presenters

import com.periferia.metas_amway.login.interfaces.Code
import com.periferia.metas_amway.login.models.ValidateCodeModel

class ValidateCodePresenter(view:Code.View) : Code.Presenter {


    private val view:Code.View
    private val model:Code.Model

    init {
        this.view = view
        model = ValidateCodeModel(this)
    }


    override fun validateCode(code: Long) {
        model.validateCode(code)
    }

    override fun validCode(country: String, operation:Int) {
        if (operation == 219) {
            view.loginValidation()
        }else{
            //coigo amway sin registros
            view.successfulValidation(country)
        }

    }


    override fun error(error: String) {
        view.error(error)
    }
}