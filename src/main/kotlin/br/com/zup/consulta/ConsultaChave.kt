package br.com.zup.consulta

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class ConsultaChave(
    @field:NotNull
    val idChave: Long,
    @field:NotBlank
    val idCliente: String
) {

}