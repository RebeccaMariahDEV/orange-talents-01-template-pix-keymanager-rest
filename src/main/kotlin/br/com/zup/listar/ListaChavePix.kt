package br.com.zup.listar

import br.com.zup.ListaChavePixRequest
import javax.validation.constraints.NotBlank

class ListaChavePix (@field:NotBlank val idCliente: String){

    fun paraListarPix(idCliente: String): ListaChavePixRequest {

        return ListaChavePixRequest.newBuilder()
            .setIdCliente(idCliente)
            .build()
    }
}