package br.com.fishrecord.impl.data.datasource.remote

import br.com.fishrecord.common.result.ResponseResult
import br.com.fishrecord.impl.data.datasource.model.User

interface FishRecordDataSource {
    suspend fun doLogin(login: String, password: String): ResponseResult<User>
}