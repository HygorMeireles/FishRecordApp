package br.com.fishrecord.impl.data.repository

import br.com.fishrecord.common.result.ResponseResult
import br.com.fishrecord.impl.data.datasource.model.User
import br.com.fishrecord.impl.data.datasource.remote.FishRecordDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class FishRecordRepositoryImpl(
    private val dataSource: FishRecordDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): FishRecordRepository {
    override suspend fun doLogin(
        login: String,
        password: String
    ): ResponseResult<User> = withContext(dispatcher){
        dataSource.doLogin(login, password)
    }
}