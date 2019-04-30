/*
 * @lc app=leetcode.cn id=62 lang=kotlin
 *
 * [62] 不同路径
 */
val map = mutableMapOf<String, Int>()
class Solution {

    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 1 || n == 1) {
            return 1
        }
        val max = Math.max(m, n)
        val min = Math.min(m, n)
        val key = "$max$min"
        var result = map[key]
        if (result == null) {
            result = uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
            map[key] = result
        }
        return result
    }
}
