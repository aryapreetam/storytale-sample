package org.storytale.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform