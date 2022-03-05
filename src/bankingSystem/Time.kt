package bankingSystem

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Time {
    companion object{
        fun time(): String {
            val now = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss")
            return now.format(formatter)
        }
    }
}