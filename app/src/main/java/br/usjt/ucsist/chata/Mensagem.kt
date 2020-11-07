package br.usjt.ucsist.chatb

import java.util.*

class Mensagem : Comparable<Mensagem> {

    var usuario: String? = null
    var data: Date? = null
    var texto: String? = null
    constructor(        usuario: String,
                        data: Date,
                        texto: String
    ){
        this.usuario = usuario
        this.data = data
        this.texto = texto
    }
    constructor()
    override operator fun compareTo(other: Mensagem): Int {
        return data!!.compareTo(other.data)
    }
}