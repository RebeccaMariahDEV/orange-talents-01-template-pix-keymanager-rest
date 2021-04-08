package br.com.zup.consulta

import br.com.zup.ConsultaChavePixGrpcServiceGrpc
import br.com.zup.ConsultaChavePixRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Controller("/api/clientes/{idCliente}/chaves/{idChave}/pix")
@Validated
class ConsultaPixController(
    @Inject val grpc: ConsultaChavePixGrpcServiceGrpc.ConsultaChavePixGrpcServiceBlockingStub
) {

    @Get
    fun consulta(@PathVariable idCliente: Long, @PathVariable idChave: String, @Body @Valid consultaChave: ConsultaChave): HttpResponse<Any>{
        val requestCliente = ConsultaChavePixRequest.newBuilder()
            .setIdChave(
                ConsultaChavePixRequest.FiltroPorPixId.newBuilder()
                .setIdChave(idChave.toLong())
                .setIdCliente(idCliente.toString()).build())
            .build()
        val response = grpc.consultar(requestCliente)

        return HttpResponse.ok(HttpResponse.uri("/api/clientes/${idCliente}/pix/${response}"))
    }
}