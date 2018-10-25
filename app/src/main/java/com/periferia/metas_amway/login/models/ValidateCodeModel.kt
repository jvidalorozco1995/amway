package com.periferia.metas_amway.login.models

import android.util.Log
import android.widget.Toast
import com.periferia.metas_amway.login.interfaces.Code
import com.periferia.metas_amway.network.API
import com.periferia.metas_amway.network.RetrofitClient
import com.periferia.metas_amway.network.models.CodeAmway
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ValidateCodeModel(presenter:Code.Presenter) : Code.Model{

    private val presenter : Code.Presenter

    private var composite: CompositeDisposable

    private val api:API

    init {
        this.presenter = presenter
        val retrofit= RetrofitClient.instance
        api = retrofit.create(API::class.java)
        composite = CompositeDisposable()
    }


    override fun validateCode(code: Long) {
        /*if (code.substring(0,3).equals("123")) {
            presenter.validCode("Colombia")
        } else if (code.substring(0,3).equals("345")){
            presenter.validCode("Brasil")
        } else {
            presenter.validCode("las demas")
        }*/
        Log.wtf("SERVICE","START")

        composite.add(api.validatecode(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result -> setCountry(code, result.codigoOperacion)},
                        { error -> presenter.error(error.message!!)})
        )
    }

    fun setCountry(code: Long, operation:Int){
        Log.wtf("SELECTION", "$operation ")
        val tem: String = code.toString()
        when {
            tem.substring(0,3).equals("380") -> presenter.validCode("ARGENTINA",operation)
            tem.substring(0,3).equals("310") -> presenter.validCode("BRAZIL",operation)
            tem.substring(0,3).equals("400") -> presenter.validCode("CHILE",operation)
            tem.substring(0,3).equals("190") -> presenter.validCode("COLOMBIA",operation)
            tem.substring(0,3).equals("290") -> presenter.validCode("COSTA RICA",operation)
            tem.substring(0,3).equals("510") -> presenter.validCode("EL SALVADOR",operation)
            tem.substring(0,3).equals("260") -> presenter.validCode("GUATEMALA",operation)
            tem.substring(0,3).equals("520") -> presenter.validCode("HONDURAS",operation)
            tem.substring(0,3).equals("170") -> presenter.validCode("MEXICO",operation)
            tem.substring(0,3).equals("230") -> presenter.validCode("PANAMA",operation)
            tem.substring(0,3).equals("440") -> presenter.validCode("URUGUAY",operation)
            tem.substring(0,3).equals("600") -> presenter.validCode("VENEZUELA",operation)
        }

    }
}