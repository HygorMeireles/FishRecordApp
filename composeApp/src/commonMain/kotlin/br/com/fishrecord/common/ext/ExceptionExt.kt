package br.com.fishrecord.common.ext

import br.com.fishrecord.common.error.CommonErrors
import br.com.fishrecord.common.error.GenericError

fun Exception.toGenericError(): GenericError {
    return CommonErrors.UnknownError()
}
