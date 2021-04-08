package br.com.zup.deletar

import br.com.zup.DeletarPixRequest
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class DeletarPix(
    @field:NotNull
    val idChave: String,
    @field:NotBlank
    val idCliente: Long
) {

    fun paraDeletarPixRequest(idChave: String, idCliente: Long): DeletarPixRequest{

        return DeletarPixRequest.newBuilder()
            .setIdChave(idChave)
            .setIdCliente(idCliente)
            .build()
    }

}