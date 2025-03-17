package com.example.task2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task2.databinding.ActivityEmptystateBinding

class EmptystateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmptystateBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emptystate)

        binding = ActivityEmptystateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val fragment1 = BlankFragment1.newInstance("", "")
        val fragment2 = BlankFragment2.newInstance("", "")

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentContainerView, fragment1, "1")
            add(R.id.fragmentContainerView, fragment2, "2")
            hide(fragment2)
            commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    supportFragmentManager.beginTransaction().apply {
                        show(fragment1)
                        hide(fragment2)
                        commit()
                    }
                    true
                }


                R.id.page_2 -> {
                    supportFragmentManager.beginTransaction().apply {
                        show(fragment2)
                        hide(fragment1)
                        commit()
                    }
                    true


                }
                else -> {
                    false
                }

            }

        }
    }

}