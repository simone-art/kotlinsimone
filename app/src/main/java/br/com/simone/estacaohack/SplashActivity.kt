package br.com.simone.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Setando um tempo na tela de splash para a tela de login
        android.os.Handler().postDelayed({

           //Abrindo a tela de Login
           startActivity(Intent(this@SplashActivity, LoginActivity::class.java))

           //Finalizando o splash
           finish()
       }, 3000)

       }

    }

