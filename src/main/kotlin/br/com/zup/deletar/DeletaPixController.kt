package br.com.zup.deletar

import br.com.zup.DeletarPixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Controller("/api/clientes/{idCliente}/pix")
@Validated
class DeletaPixController(
    @Inject val grpc: DeletarPixServiceGrpc.DeletarPixServiceBlockingStub
) {

    @Delete
    fun deleta(@PathVariable idCliente: Long, @Body @Valid deletaPix: DeletarPix): HttpResponse<Any>{
        val requestCliente = deletaPix.paraDeletarPixRequest(idChave = deletaPix.idChave,
            idCliente = deletaPix.idCliente)

        val response = grpc.deletar(requestCliente)

        return HttpResponse.ok(HttpResponse.uri("/api/clientes/${idCliente}/pix/${response.message}"))
    }

}