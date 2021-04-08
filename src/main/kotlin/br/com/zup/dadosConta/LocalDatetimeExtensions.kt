package br.com.zup.dadosConta

import com.google.protobuf.Timestamp
import java.time.LocalDateTime
import java.time.ZoneOffset

fun Timestamp.toLocalDatetime(): LocalDateTime {
    return LocalDateTime.ofEpochSecond(this.seconds, this.nanos, ZoneOffset.UTC)
}