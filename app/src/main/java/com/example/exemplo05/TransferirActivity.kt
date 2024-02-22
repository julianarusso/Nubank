package com.example.exemplo05

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class TransferirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferir)
        setSupportActionBar(findViewById(R.id.toolbar4))
        val btnConf = findViewById<Button>(R.id.btnTransferir)
        val txtsaldo = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE)
        var nsaldo = txtsaldo.toString().toDouble()


        btnConf.setOnClickListener {
            val data = Intent()
            val edtConta = findViewById<EditText>(R.id.edtNumConta)

            val edtAgencia = findViewById<EditText>(R.id.edtNumAgencia)

            val edtValor = findViewById<EditText>(R.id.edtValorTranf)
            val nValor = edtValor.text.toString().toDouble()

            if(nsaldo<nValor) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente", Toast.LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nValor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo",txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this,"$nsaldo", Toast.LENGTH_SHORT).show()
            edtConta.setText("".toString())
            edtAgencia.setText("".toString())
            edtValor.setText("".toString())
            finish()


        }
    }
}