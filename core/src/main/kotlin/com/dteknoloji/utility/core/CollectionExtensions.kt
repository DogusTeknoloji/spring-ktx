package com.dteknoloji.utility.core

@Suppress("UNCHECKED_CAST")
fun <K, V : Any> Map<K, V?>.filterValuesNotNull(): Map<K, V> {
    return filterValues { it != null } as Map<K, V>
}
