package com.dteknoloji.utility.webflux.core

import reactor.util.context.Context

fun <T> Context.getOrNull(key: Any): T? {
    return try {
        get(key)
    } catch (e: NoSuchElementException) {
        null
    }
}
