package br.com.simone.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Criando a ação do clique do Botão Entrar:

        btnEntrar.setOnClickListener {

            val usuario = editUsuario.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            //Condição para verificar o usuário e a senha:

            if (usuario.isEmpty()){
                txvResultado.text = "Usuário está vazio!"

            }else if(senha.isEmpty()){

                txvResultado.text = "A senha está vazia"

            }else if(usuario =="Simone" && senha == "abacaxi123"){
                txvResultado.text = "Usuário logado com Sucesso"

            }else{
                Toast.makeText(this@LoginActivity, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }

        }

        btnCadastrar.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }


    }
}
