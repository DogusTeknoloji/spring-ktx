package com.dteknoloji.utility.webflux.security

import org.springframework.security.oauth2.jwt.JwtClaimNames
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import java.time.Instant

inline fun <reified T: Any> JwtAuthenticationToken.getClaim(claim: String): T? = tokenAttributes[claim] as? T

fun JwtAuthenticationToken.getIssuer(attributeKey: String = JwtClaimNames.ISS): String? = getClaim(attributeKey)

fun JwtAuthenticationToken.getAudience(attributeKey: String = JwtClaimNames.AUD): List<String>? = getClaim(attributeKey)

fun JwtAuthenticationToken.getExpirationTime(attributeKey: String = JwtClaimNames.EXP): Instant? = getClaim(attributeKey)
