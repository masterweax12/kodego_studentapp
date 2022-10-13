package com.kodego.studentassistance.app.juntilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.studentassistance.app.juntilla.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //login
        binding.btngLogin.setOnClickListener(){
            var userName: String = binding.etUserName.text.toString()
            var password: String = binding.etUserPassword.text.toString()
            checkCredential(userName, password)
        }
    }

    private fun checkCredential(userName: String, password: String): Boolean{
        val correctUserName: String = "admin"
        var correctPassword: String = "laymegwapa"

        if((correctUserName == userName) && (correctPassword == password)){
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext,"Log in success!", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(applicationContext,"Invalid Credentials", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}
