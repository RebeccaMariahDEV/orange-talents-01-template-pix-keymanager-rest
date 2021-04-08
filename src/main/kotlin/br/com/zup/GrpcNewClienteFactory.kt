package br.com.zup

import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory //injeta as dependencias do grpc
class GrpcNewClienteFactory(@GrpcChannel("pix") val channel: ManagedChannel) {

    @Singleton
    fun cadastroChavePix() = cadastraChavePixGrpcGrpc.newBlockingStub(channel)//cria um novo stub

    @Singleton
    fun deletaChavePix() = DeletarPixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listaChavePix() = ListaChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun consultaChavePix() = ConsultaChavePixGrpcServiceGrpc.newBlockingStub(channel)
}