package br.com.simone.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Abrir o Shared Preferences
        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

        //Recuperando dados do Shared Preferences

        val nome = minhaPreferencia.getString("nome", "Erro preferences")
        val sobrenome = minhaPreferencia.getString("sobrenome", "Erro preferences")
        val email = minhaPreferencia.getString("email", "Erro preferences")
        val sexo = minhaPreferencia.getString("sexo", "Erro preferences")

        //Colocando na tela os dados recuperados
        txvNome.text = "$nome $sobrenome"
        txvEmail.text = email
        txvSexo.text = sexo

        btnSite.setOnClickListener {
            startActivity(Intent(this@MainActivity, WebActivity::class.java))
        }

        btnSair.setOnClickListener{
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finishAffinity()
        }



    }
}
