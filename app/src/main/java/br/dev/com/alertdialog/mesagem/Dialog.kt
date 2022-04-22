package br.dev.com.alertdialog.mensagem

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import br.dev.com.alertdialog.R
import br.dev.com.alertdialog.databinding.DaialogCustomBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


open class Dialog {

    private var titulo  = "Facial Maps"
    private lateinit var texto   : String

    // Databinding
    fun DialogBinding(context: Context, text: String){
        this.texto = text
        //inflarDialogBinding(context)
        setarTextoInfladoBinding(context , inflarDialogBinding(context) )
    }
    private fun inflarDialogBinding(context: Context): DaialogCustomBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.daialog_custom, null, false
        )
    }
    private fun setarTextoInfladoBinding(context: Context , binding: DaialogCustomBinding){

        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context , R.style.NewDialog)

        binding.tvTitle.text = titulo
        binding.tvDetail.text = texto
        binding.btDone.setOnClickListener { dialog!!.dismiss() }
        //dialog?.window?.setBackgroundDrawableResource(android.R.color.darker_gray);

        builder.setView(binding.root)
        // create and show the alert dialog
        dialog = builder.create()
        dialog.show()

    }

    // findviewbyid
    fun Dialog(context: Context, text: String){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)

        // set the custom layout
        val view = (context as Activity).layoutInflater.inflate(R.layout.daialog_custom, null)

        // Get Views references from your layout
        val tvTitle  : TextView = view.findViewById(R.id.tv_title)
        val tvDetail : TextView = view.findViewById(R.id.tv_detail)
        val btDone   : FloatingActionButton = view.findViewById(R.id.bt_done)

        tvTitle.text = titulo
        tvDetail.text = text

        btDone.setOnClickListener {
            dialog?.dismiss()
        }

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        builder.setView(view)
        // create and show the alert dialog
        dialog = builder.create()
        dialog.show()
        Log.e("App" , "Teste")
    }

}