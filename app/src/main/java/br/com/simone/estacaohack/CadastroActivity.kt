package br.com.simone.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        /*
        Criando o Shared Preferences:

        São necessários dos parámetros dentro dos parênteses
        1. Nome do arquivo a ser criado
        2. Modo de acesso dele.
         */

        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

        // Criando o editor do SharedPrefereces//

        val meuEditor = minhaPreferencia.edit()

        // Criando a linha sexo //

        val listaSexo = arrayListOf("Selecione o sexo", "Feminino", "Masculino")

        // Criando o adaptador do Spinner //

        val adapterSexo = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        // Adicionando o adaptador ao spinner da tela//
        spnSexo.adapter = adapterSexo

        // Evento do clique do botão

        btnCadastrar.setOnClickListener {
            //Recuperando os valores digitados pelo usuário e armazenando em variáveis//
            val nome = txvNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val email = edtEmail.text.toString().trim().toLowerCase()
            val senha = edtSenha.text.toString().trim()

            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                //Imprimindo uma mensagem de erro pro usuário através do Toast
                Toast.makeText(
                    this@CadastroActivity,
                    "Preencha todos os campos!",
                    Toast.LENGTH_LONG
                ).show()
            } else if (spnSexo.selectedItem == "Selecione o sexo") {
                //Imprimiendo uma mensagem de erro pro usuário //
                Toast.makeText(
                    this@CadastroActivity,
                    "Selecione o sexo, por favor",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                //Salvando as informações no Shared Preferences
                meuEditor.putString("nome", nome).apply()
                meuEditor.putString("sobrenome", sobrenome).apply()
                meuEditor.putString("email", email).apply()
                meuEditor.putString("senha", senha).apply()
                meuEditor.putString("sexo", spnSexo.selectedItem.toString()).apply()
            }

            //Criado o alerta de usuáio cadastrado com sucesso//

            //Acrescentando uma mensagem no Alerta:
            // Para adicionar tpitulo se usa o: setTitle
            // Para adicionar mensagem se usa o: setMessage
            //Para adicionar botão positivo: setPositiveButton
            //Para adicionar botão negativo: setNegativeButton

            AlertDialog.Builder(this@CadastroActivity)
                .setTitle("Sucesso!")
                .setMessage("Usuário Cadastrado com sucesso!")
                .setPositiveButton("Ok") { _, _ ->
                    //Voltando para a tela de login
                    //onBackPressed()
                    startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
                }

                .create()
                .show()
        }
    }
}

