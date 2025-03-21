package br.com.fishrecord

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform