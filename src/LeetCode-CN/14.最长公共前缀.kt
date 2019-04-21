/*
 * @lc app=leetcode.cn id=14 lang=kotlin
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (32.87%)
 * Total Accepted:    72.1K
 * Total Submissions: 219.2K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        val target = strs[0]
        var maxHit = target.length

        for (i in 1..strs.size-1) {
            var hit = 0;
            for ((idx, c) in strs[i].withIndex()) {
                if (target.length > idx && target[idx] == c) {
                    hit = idx + 1
                } else {
                    break
                }
            }
            maxHit = Math.min(maxHit, hit)
            if (maxHit == 0) {
                break
            }
        }

        return target.substring(0, maxHit)
    }
}

