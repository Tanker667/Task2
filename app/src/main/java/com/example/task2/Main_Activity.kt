package com.example.task2
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.task2.databinding.MainActivityBinding


class Main_Activity : AppCompatActivity(){

    private lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.MainRegButton.setOnClickListener{
            val intent = Intent( this, RegActivity::class.java)
            startActivity(intent)
        }

        binding.textButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}