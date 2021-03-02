package mx.edu.itson.practica04_chezeery_189029

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        btn_cold_drinks.setOnClickListener {
            var intent:Intent= Intent(this,ProductosActivity::class.java)
            intent.putExtra("button", "coldDrinks")
            startActivity(intent)
        }

        btn_combos.setOnClickListener {
            var intent:Intent= Intent(this,ProductosActivity::class.java)
            startActivity(intent)
        }
        btn_custom.setOnClickListener {
            var intent:Intent= Intent(this,ProductosActivity::class.java)
            startActivity(intent)
        }
        btn_hot_drinks.setOnClickListener {
            var intent:Intent= Intent(this,ProductosActivity::class.java)
            intent.putExtra("button", "hotDrinks")
            startActivity(intent)
        }
        btn_salties.setOnClickListener {
            var intent:Intent= Intent(this,ProductosActivity::class.java)
            intent.putExtra("button", "salties")
            startActivity(intent)
        }
        btn_sweets.setOnClickListener {
            var intent:Intent= Intent(this,ProductosActivity::class.java)
            intent.putExtra("button", "sweets")
            startActivity(intent)
        }
    }

}