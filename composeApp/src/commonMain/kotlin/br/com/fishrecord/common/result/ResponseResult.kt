package br.com.fishrecord.common.result

import br.com.fishrecord.common.error.GenericError

sealed class ResponseResult<out R> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val resultError: GenericError) : ResponseResult<Nothing>()

    companion object {
        const val NO_DATA: Int = -1
    }
}