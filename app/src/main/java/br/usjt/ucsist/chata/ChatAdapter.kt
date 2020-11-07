package br.usjt.ucsist.chatb


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.usjt.ucsist.chata.R


class ChatAdapter(
    private val values: List<Mensagem>,
    private val context: Context
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(br.usjt.ucsist.chata.R.layout.list_item, parent, false)
        return ChatViewHolder(view)
    }


    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = values[position]


        holder.dataNomeTextView.text = context.getString(
            R.string.data_nome,
            DateHelper.format(item.data), item.usuario
        )
        holder.mensagemTextView.text = item.texto
    }

    override fun getItemCount(): Int = values.size

    inner class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dataNomeTextView: TextView = view.findViewById(br.usjt.ucsist.chata.R.id.dataNomeTextView)
        val mensagemTextView: TextView = view.findViewById(br.usjt.ucsist.chata.R.id.mensagemTextView)
    }
}