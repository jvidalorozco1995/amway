package com.periferia.metas_amway.login.views

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


import com.periferia.metas_amway.R
import com.periferia.metas_amway.login.interfaces.Code
import com.periferia.metas_amway.login.presenters.ValidateCodePresenter


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ValidationCode.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ValidationCode.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ValidationCode : androidx.fragment.app.Fragment(), Code.View {

    private var currentIndex: Int = 0
    private var touched: Boolean = false
    private lateinit var presenter:Code.Presenter



    private lateinit var btn_guardar:Button


    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_validation_code, container, false)
        presenter = ValidateCodePresenter(this)


        return view
    }




    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }



    override fun successfulValidation(country: String) {
        val bundle = Bundle()
        bundle.putString("country", country)
        val registro = RegisterInfo()
        registro.arguments = bundle
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.contenedor_registro, registro)
                .addToBackStack(null).commit()

    }

    override fun loginValidation() {
        val login = LogIn()
        val transaction = fragmentManager!!
                .beginTransaction()
        transaction.replace(R.id.contenedor_registro, login)
                .addToBackStack("aa").commit()
    }

    override fun error(erro:String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Codigo Invalido")
        builder.setMessage("Codigo Amway No valido")
        builder.setNeutralButton("Cancel"){_,_ ->}
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ValidationCode.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ValidationCode().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
