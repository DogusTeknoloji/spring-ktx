package com.dteknoloji.utility.core

import java.time.Instant

fun Instant.isBetween(startDate: Instant, endDate: Instant, inclusive: Boolean = true) = if (inclusive) {
    compareTo(startDate) >= 0 && compareTo(endDate) <= 0
} else {
    isAfter(startDate) && isBefore(endDate)
}