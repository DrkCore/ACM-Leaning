/*
 * @lc app=leetcode.cn id=58 lang=kotlin
 *
 * [58] 最后一个单词的长度
 */
class Solution {
    fun lengthOfLastWord(s: String): Int {
        var result = 0

        val tmp = s.trim()
        var idx = tmp.length - 1
        while (idx >= 0) {
            val c = tmp[idx]
            if (c.isLowerCase() || c.isUpperCase()) {
                result++
            } else if (result > 0) {
                break
            }

            idx--
        }

        return result
    }
}
