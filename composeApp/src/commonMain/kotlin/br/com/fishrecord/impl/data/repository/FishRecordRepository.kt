package br.com.fishrecord.impl.data.repository

import br.com.fishrecord.common.result.ResponseResult
import br.com.fishrecord.impl.data.datasource.model.User

interface FishRecordRepository {

    suspend fun doLogin(login: String, password: String): ResponseResult<User>
}