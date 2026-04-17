package com.memory.newsreader

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform