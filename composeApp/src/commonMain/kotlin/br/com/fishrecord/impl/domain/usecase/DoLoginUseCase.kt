package br.com.fishrecord.impl.domain.usecase

import br.com.fishrecord.common.base.usecase.BaseUseCase
import br.com.fishrecord.common.result.ResponseResult
import br.com.fishrecord.impl.data.datasource.model.User
import br.com.fishrecord.impl.data.repository.FishRecordRepository

class DoLoginUseCase(
    private val repository: FishRecordRepository
): BaseUseCase<DoLoginUseCaseParams, User> {
    override suspend fun invoke(params: DoLoginUseCaseParams): ResponseResult<User> {
        return repository.doLogin(params.login, params.password)
    }

}

data class DoLoginUseCaseParams(
    val login: String,
    val password: String
)