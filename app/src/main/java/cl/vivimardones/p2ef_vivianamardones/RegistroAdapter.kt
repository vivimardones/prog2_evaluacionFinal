package cl.vivimardones.p2ef_vivianamardones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Registro(val tipo: String, val registro: String, val fecha: String)

class RegistroAdapter(private val registros: List<Registro>) : RecyclerView.Adapter<RegistroAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon: ImageView = view.findViewById(R.id.ivIcon)
        val tvTipoMedidor: TextView = view.findViewById(R.id.tvTipoMedidor)
        val tvRegistroMedidor: TextView = view.findViewById(R.id.tvRegistroMedidor)
        val tvFechaRegistro: TextView = view.findViewById(R.id.tvFechaRegistro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_registro, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val registro = registros[position]

        holder.tvTipoMedidor.text = registro.tipo
        holder.tvRegistroMedidor.text = registro.registro
        holder.tvFechaRegistro.text = registro.fecha

        when (registro.tipo) {
            "Agua" -> holder.ivIcon.setImageResource(R.drawable.ic_agua)
            "Luz" -> holder.ivIcon.setImageResource(R.drawable.ic_luz)
            "Gas" -> holder.ivIcon.setImageResource(R.drawable.ic_gas)
        }
    }

    override fun getItemCount(): Int {
        return registros.size
    }
}
