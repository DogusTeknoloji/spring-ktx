package com.dteknoloji.utility.webflux.security

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken

inline fun <reified T> JwtAuthenticationToken.getClaim(claim: String): T? = tokenAttributes[claim] as? T