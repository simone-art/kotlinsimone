package br.com.simone.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //Habilitar o Java script dentro do Wevview

        wbvSite.settings.javaScriptEnabled = true
        wbvSite.loadUrl("https://br.cellep.com/")
    }
}
