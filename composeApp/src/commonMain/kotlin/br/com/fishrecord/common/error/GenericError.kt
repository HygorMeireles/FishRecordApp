package br.com.fishrecord.common.error

abstract class GenericError : Exception() {
    open val msg: String = "Ocorreu um erro. Tente novamente."
}