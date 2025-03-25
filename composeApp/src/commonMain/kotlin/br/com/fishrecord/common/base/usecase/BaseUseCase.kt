package br.com.fishrecord.common.base.usecase

import br.com.fishrecord.common.result.ResponseResult

interface BaseUseCase<Param, Output> {
    suspend fun invoke(params: Param): ResponseResult<Output>
}
