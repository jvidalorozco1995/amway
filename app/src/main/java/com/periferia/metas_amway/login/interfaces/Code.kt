package com.periferia.metas_amway.login.interfaces

interface Code {

    interface View {
        fun successfulValidation(country: String)
        fun loginValidation()
        fun error(error:String)
    }

    interface Presenter {
        fun validCode(country: String, operation:Int)
        fun validateCode(code: Long)
        fun error(error:String)
    }

    interface Model {
        fun validateCode(code: Long)
    }

}