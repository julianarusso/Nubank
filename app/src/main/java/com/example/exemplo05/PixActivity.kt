package com.example.exemplo05

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class PixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix)
        setSupportActionBar(findViewById(R.id.toolbar2))
        val btnConf = findViewById<Button>(R.id.btnConfirmar)
        val txtsaldo = intent.getStringExtra(EXTRA_MESSAGE)
        var nsaldo = txtsaldo.toString().toDouble()


        btnConf.setOnClickListener {
            val data = Intent()
            val edtPix = findViewById<EditText>(R.id.txtPix)

            val edtValor = findViewById<EditText>(R.id.edtValorPix)
            val nValor = edtValor.text.toString().toDouble()

            if(nsaldo<nValor) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente", LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nValor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo",txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this,"$nsaldo", LENGTH_SHORT).show()
            edtPix.setText("".toString())
            edtValor.setText("".toString())
            finish()


        }
    }
}