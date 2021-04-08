package br.com.zup.core.validacao

import jdk.vm.ci.code.site.ExceptionHandler
import javax.inject.Singleton

//@Singleton
//class ExceptionHandlerResolver(
//    private val handlers: List<ExceptionHandler<Exception>>
//) {
//
//    fun resolve(e: Exception): ExceptionHandler<Exception> {
//        val filteredHandlers = handlers.filter { it.supports(e) }
//        return filteredHandlers.first()
//    }
//
//}