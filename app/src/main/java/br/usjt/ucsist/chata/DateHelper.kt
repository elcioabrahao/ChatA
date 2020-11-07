package br.usjt.ucsist.chatb

import java.text.SimpleDateFormat
import java.util.*

internal object DateHelper {
    private val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
    fun format(date: Date?): String {
        return sdf.format(date)
    }
}