package mx.edu.itson.practica04_chezeery_189029

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_sing_in.setOnClickListener {
            var intent:Intent=Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
    }
}