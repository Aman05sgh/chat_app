package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Logiin : AppCompatActivity() {

  private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp:Button
   private lateinit var mAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logiin)
        supportActionBar?.hide()
        mAuth= FirebaseAuth.getInstance()
        edtEmail=findViewById(R.id.edt_email)
        edtPassword=findViewById(R.id.edt_password)
        btnLogin=findViewById(R.id.btnLogin)
        btnSignUp=findViewById(R.id.btnSignup)
        btnSignUp.setOnClickListener {
            val intent= Intent(this,Signup ::class.java);
            finish()
            startActivity(intent);
        }
        btnLogin.setOnClickListener {
            val email=edtEmail.text.toString()
            val password=edtPassword.text.toString()
            login(email,password)
        }
      }


    private fun login(email: String,password: String)
    {
   // logic of logging in
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
               //code for logging in user
                    val intent= Intent(this@Logiin,MainActivity::class.java)
                    startActivity(intent)
                } else {
                 Toast.makeText(this@Logiin,"User does not exist",Toast.LENGTH_SHORT).show()
                }
            }

    }
}
