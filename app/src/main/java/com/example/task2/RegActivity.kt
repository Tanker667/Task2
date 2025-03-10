package com.example.task2

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task2.databinding.ActivityRegBinding

class RegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }

        val text = binding.text3.text.toString()

        val spannableString = SpannableString(text)

        val clickable = Clickable()
        spannableString.setSpan(clickable, 37, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val clickable2 = Clickable()
        spannableString.setSpan(clickable2, 118, 145, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.text3.text = spannableString
        binding.text3.movementMethod = LinkMovementMethod.getInstance()


    }


    class Clickable : ClickableSpan() {
        override fun onClick(p0: View) {
            TODO("Not yet implemented")
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.isUnderlineText = false
        }




    }
}
