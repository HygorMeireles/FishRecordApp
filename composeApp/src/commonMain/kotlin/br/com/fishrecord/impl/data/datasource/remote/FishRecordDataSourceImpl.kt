package br.com.fishrecord.impl.data.datasource.remote

import br.com.fishrecord.common.error.GenericError
import br.com.fishrecord.common.ext.toGenericError
import br.com.fishrecord.common.result.ResponseResult
import br.com.fishrecord.impl.data.datasource.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class FishRecordDataSourceImpl(
    private val api: ApiService
): FishRecordDataSource {
    override suspend fun doLogin(login: String, password: String): ResponseResult<User> {
        return try {
            api.login(login, password).let {
                ResponseResult.Success(it)
            }
        } catch (e: Exception) {
            ResponseResult.Error(e.toGenericError())
        }
    }
}