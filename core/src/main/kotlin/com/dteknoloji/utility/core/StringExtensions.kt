package com.dteknoloji.utility.core

import java.util.UUID

const val CAMEL_CASE_REGEX = "(?<=[a-zA-Z])[A-Z]"
const val NOT_BLANK_REGEX = "(.|\\s)*\\S(.|\\s)*"

inline fun <reified T : Enum<T>> String.toEnumOrNull(): T? {
    return try {
        enumValueOf(this) as T
    } catch (e: Exception) {
        null
    }
}

fun String.toUUIDOrNull(): UUID? {
    return try {
        UUID.fromString(this)
    } catch (e: Exception) {
        null
    }
}

fun String.camelToUpperSnakeCase(): String {
    return CAMEL_CASE_REGEX.toRegex().replace(this) {
        "_${it.value}"
    }.uppercase()
}

fun String.camelToKebabCase() = CAMEL_CASE_REGEX.toRegex()
    .replace(this) { "-${it.value}" }
    .lowercase()
