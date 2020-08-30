package com.priya.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etMb: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgerPw: TextView
    lateinit var txtSignUp: TextView
    var validmb="123456789"
    var validpassword="hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etMb=findViewById(R.id.etMb)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgerPw=findViewById(R.id.txtForgetPw)
        txtSignUp=findViewById(R.id.txtSignUp)
        btnLogin.setOnClickListener{
            val intent = Intent(this@LoginActivity,WelcomePage::class.java)
            var mobileNumber = etMb.text.toString()
            var password = etPassword.text.toString()
            if(validmb==mobileNumber && validpassword==password){
                intent.putExtra("enteredNumber",mobileNumber)
                intent.putExtra("enteredPassword",password)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }
        }
        txtForgerPw.setOnClickListener{
            val getPw= Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(getPw)
        }
        txtSignUp.setOnClickListener{
            val intent=Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
