/*
 * @lc app=leetcode.cn id=28 lang=kotlin
 *
 * [28] 实现strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (38.05%)
 * Total Accepted:    48.4K
 * Total Submissions: 127.4K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        } else if (haystack.isEmpty()) {
            return -1
        }

        mainLoop@ for ((idx, c) in haystack.withIndex()) {
            if (idx + needle.length > haystack.length) {
                break
            }
            if (c == needle[0] && haystack[idx + needle.length - 1] == needle[needle.length - 1]) {
                for (i in 1 until needle.length - 1) {
                    if (haystack[idx + i] != needle[i]) {
                        continue@mainLoop
                    }
                }
                return idx
            }
        }
        return -1
    }
}

