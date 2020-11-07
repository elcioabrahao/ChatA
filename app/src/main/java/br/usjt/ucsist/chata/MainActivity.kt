package br.usjt.ucsist.chata

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
    }

    fun fazerLogin(view: View?) {
        val login: String = loginEditText.getEditableText().toString()
        val senha: String = senhaEditText.getEditableText().toString()
        mAuth!!.signInWithEmailAndPassword(
            login,
            senha
        ).addOnSuccessListener { result -> startActivity(
            Intent(this, ChatActivity::class.java)) }
            .addOnFailureListener { exception ->
                exception.printStackTrace()
                Toast.makeText(
                    this, exception.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    fun irParaCadastro(view: View?) {
        startActivity(Intent(this, NovoUsuarioActivity::class.java))
    }


}