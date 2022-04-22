package br.dev.com.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.dev.com.alertdialog.databinding.ActivityMainBinding
import br.dev.com.alertdialog.mensagem.Dialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView( this, R.layout.activity_main )

        binding.btnFindID.setOnClickListener {
            callDialog()
        }
        binding.btnBinding.setOnClickListener {
            dialogBinding()
        }

    }

    private fun callDialog(){
        Dialog().Dialog(this@MainActivity,"Teste")
    }

    private fun dialogBinding(){
        Dialog().DialogBinding(this@MainActivity,"Teste")
    }

}