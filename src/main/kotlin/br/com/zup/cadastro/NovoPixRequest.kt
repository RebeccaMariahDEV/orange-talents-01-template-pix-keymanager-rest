package br.com.zup.cadastro

import br.com.zup.PixRequest
import br.com.zup.TiposConta
import br.com.zup.dadosConta.TipoChave
import br.com.zup.dadosConta.TipoConta
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
class NovoPixRequest(
//    @field:NotBlank
//    val idCliente: String,
    @field:NotNull
    val tipoChave: TipoChave?,
    @field:Size(max = 77)
    var chaveCadastrada: String,
    @field:NotNull
    val tipoConta: TipoConta?
) {

    //converte os dados do grpc
    fun paraCadastrarPixRequest(idCliente: UUID): PixRequest{

        return PixRequest.newBuilder()
            .setIdCliente(idCliente.toString())
            .setChave(chaveCadastrada)
            .setTiposConta(TiposConta.valueOf(tipoConta!!.name))
            .setTipoChave(br.com.zup.TipoChave.valueOf(tipoChave!!.name))
            .build()
    }
}
