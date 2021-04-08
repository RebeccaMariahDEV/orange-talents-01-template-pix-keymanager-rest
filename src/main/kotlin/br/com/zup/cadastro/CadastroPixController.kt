package br.com.zup.cadastro

import br.com.zup.cadastraChavePixGrpcGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject
import javax.validation.Valid

@Controller("/api/clientes/{idCliente}/pix")
@Validated
class CadastroPixController(
    @Inject val grpc: cadastraChavePixGrpcGrpc.cadastraChavePixGrpcBlockingStub //pega as classe criada e tem acessos as classes do grpc
) {

    @Post
    fun cadastro(@PathVariable idCliente: UUID, @Body @Valid novoPixRequest: NovoPixRequest): HttpResponse<Any>{

        val requestCliente = novoPixRequest.paraCadastrarPixRequest(idCliente)

        val response = grpc.cadastrar(requestCliente)

        return HttpResponse.created(HttpResponse.uri("/api/clientes/${idCliente}/pix/${response.clietId}"))

    }

}