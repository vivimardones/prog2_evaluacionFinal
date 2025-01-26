package cl.vivimardones.p2ef_vivianamardones

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var rvRegistros: RecyclerView
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var adapter: RegistroAdapter
    private val registros = mutableListOf<Registro>()

    private val registerResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val tipo = result.data?.getStringExtra("tipo")
            val registro = result.data?.getStringExtra("registro")
            val fecha = result.data?.getStringExtra("fecha")
            if (tipo != null && registro != null && fecha != null) {
                registros.add(Registro(tipo, registro, fecha))
                adapter.notifyDataSetChanged()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRegistros = findViewById(R.id.rvRegistros)
        btnAdd = findViewById(R.id.btnAdd)

        rvRegistros.layoutManager = LinearLayoutManager(this)
        adapter = RegistroAdapter(registros)
        rvRegistros.adapter = adapter

        btnAdd.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            registerResult.launch(intent)
        }
    }
}