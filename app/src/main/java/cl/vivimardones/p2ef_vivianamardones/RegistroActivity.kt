package cl.vivimardones.p2ef_vivianamardones
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {
        private lateinit var btnRegistrar: Button
        private lateinit var rgTipo: RadioGroup
        private lateinit var etRegistro: EditText
        private lateinit var etFecha: EditText

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_medidor)

        btnRegistrar = findViewById(R.id.btnRegistrar)
        rgTipo = findViewById(R.id.rgTipoMedidor)
        etRegistro = findViewById(R.id.etMedidor)
        etFecha = findViewById(R.id.etFecha)

        btnRegistrar.setOnClickListener {
            registrarDato()
        }
    }
    private fun registrarDato() {
        val selectedRadioButtonID = rgTipo.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(selectedRadioButtonID)
        val tipo = radioButton.text.toString()
        val registro = etRegistro.text.toString()
        val fecha = etFecha.text.toString()

        // Enviar datos de vuelta a MainActivity
        val intent = Intent()
        intent.putExtra("tipo", tipo)
        intent.putExtra("registro", registro)
        intent.putExtra("fecha", fecha)
        setResult(RESULT_OK, intent)
        finish()
    }
}
