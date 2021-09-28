package com.dteknoloji.utility.webflux.security

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.reactor.ReactorContext
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalCoroutinesApi::class)
suspend inline fun <reified T : Authentication> getAuthentication(): T? = coroutineContext[ReactorContext]
    ?.context
    ?.takeIf { it.hasKey(SecurityContext::class.java) }
    ?.get(SecurityContext::class.java)
    ?.authentication as? T
