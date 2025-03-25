package br.com.fishrecord.impl.data.datasource.remote

import br.com.fishrecord.impl.data.datasource.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.parameter
import io.ktor.client.request.post

class ApiService {
    private val client = HttpClient()
    private val baseUrl = "https://api.example.com"

    suspend fun login(login: String, password: String): User {
        return client.post(
            urlString = "$baseUrl/login"
        ) {
            parameter("login", login)
            parameter("password", password)
        }.body<User>()
    }
}