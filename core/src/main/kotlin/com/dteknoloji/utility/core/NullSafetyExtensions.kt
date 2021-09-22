package com.dteknoloji.utility.core

import java.util.Optional

fun <T> Optional<T>.getOrNull(): T? {
    return if (isEmpty) null else get()
}
