package br.com.zup.listar

import br.com.zup.ListaChavePixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Controller("/api/clientes/pix")
@Validated
class ListaChavePixController(
    @Inject val grpc: ListaChavePixServiceGrpc.ListaChavePixServiceBlockingStub
) {

    @Get
    fun lista(@Body @Valid listaChavePix: ListaChavePix): HttpResponse<Any>{
        val requestCliente = listaChavePix.paraListarPix(idCliente = listaChavePix.idCliente)
        val response = grpc.listar(requestCliente)

        return HttpResponse.ok(HttpResponse.uri("/api/clientes/${listaChavePix.idCliente}/pix/${response}"))
    }

}