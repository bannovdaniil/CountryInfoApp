package com.project.first

import java.text.NumberFormat

class Utils {
    public fun formatLongNumber(number: Long): String {
        return NumberFormat.getNumberInstance().format(number);
    }

    public fun formatDoubleNumber(number: Double): String {
        return NumberFormat.getNumberInstance().format(number);
    }

    public fun listToString(list: List<String>): String {
        return list.joinToString { it }
    }

    public fun mapToString(map: Map<String, String>): String {
        return map.entries.joinToString { it.value }
    }

    public fun mapCurrencyNameToString(map: Map<String, Currency>): String {
        return map.entries.joinToString { it.value.name }
    }

    public fun mapCurrencySymbolToString(map: Map<String, Currency>): String {
        return map.entries.joinToString { it.value.symbol }
    }

}