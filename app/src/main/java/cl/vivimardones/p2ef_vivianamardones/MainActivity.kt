package cl.vivimardones.p2ef_vivianamardones

import RegistroActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var rvRegistros: RecyclerView
    private lateinit var btnAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configurar el RecyclerView
        rvRegistros = findViewById(R.id.rvRegistros)
        btnAdd = findViewById(R.id.btnAdd)

        //Configuramos el Recicler View
        rvRegistros.layoutManager = LinearLayoutManager(this)

        // creamos y establecemos el adaptador
        val adapter = RegistroAdapter(getData())

        // Configurar el botón de añadir
        btnAdd.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        }
    private fun getData(): List<Registro> {
        // Aquí deberías obtener los datos de alguna fuente como una base de datos
        return listOf(
            Registro("Agua", "10500", "2024-01-10"),
            Registro("Luz", "3200", "2024-01-11"),
            Registro("Gas", "80", "2024-01-13")
        )
    }
}