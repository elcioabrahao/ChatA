package br.usjt.ucsist.chata

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_novo_usuario.*


class NovoUsuarioActivity : AppCompatActivity() {


    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)
        mAuth = FirebaseAuth.getInstance();
    }

    fun criarNovoUsuario(view: View?) {
        val login = loginNovoUsuarioEditText!!.text.toString()
        val senha = senhaNovoUsuarioEditText!!.text.toString()
        mAuth!!.createUserWithEmailAndPassword(
            login,
            senha
        ).addOnSuccessListener { result: AuthResult ->
            Toast.makeText(
                this, result.user.toString(),
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
            .addOnFailureListener { error: Exception ->
                error.printStackTrace()
                Log.e("ERROFIREBASEAUTH","Mensagem: "+error.message)
            }
    }
}