package com.dteknoloji.utility.webflux.security

import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.ReactiveSecurityContextHolder

suspend inline fun <reified T : Authentication> getAuthentication(): T? = ReactiveSecurityContextHolder
    .getContext()
    .awaitFirstOrNull()
    ?.authentication as? T