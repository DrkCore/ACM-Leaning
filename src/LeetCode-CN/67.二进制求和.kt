/*
 * @lc app=leetcode.cn id=67 lang=kotlin
 *
 * [67] 二进制求和
 */
class Solution {
    fun addBinary(a: String, b: String): String {
        var l = 0
        var r = 0

        var addOn = booleanArrayOf(false)
        var end = Math.max(a.length, b.length)
        var builder = StringBuilder(end + 1)
        var idx = 0
        while (idx < end) {
            if (idx < a.length && idx < b.length) {
                builder.append(addChar(a[a.length - idx - 1], b[b.length - idx - 1], addOn))

            } else if (idx < a.length) {
                builder.append(addChar(a[a.length - idx - 1], '0', addOn));

            } else {
                builder.append(addChar(b[b.length - idx - 1], '0', addOn))
            }

            idx++
        }
        if (addOn[0]) {
            builder.append('1')
        }

        return builder.reverse().toString()
    }

    private fun addChar(a: Char, b: Char, addOn: BooleanArray): Char {
        val result: Char
        if (a == '1' && b == '1') {
            result = if (addOn[0]) '1' else '0'
            addOn[0] = true

        } else if (a == '0' && b == '0') {
            result = if (addOn[0]) '1' else '0'
            addOn[0] = false

        } else {
            result = if (addOn[0]) '0' else '1'
        }
        return result
    }
}

fun main() {
    println(Solution().addBinary("11", "1"))
}

