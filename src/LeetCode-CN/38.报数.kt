/*
 * @lc app=leetcode.cn id=38 lang=kotlin
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (49.19%)
 * Total Accepted:    27.8K
 * Total Submissions: 56.5K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 1211 被读作 "one 1", "one 2", "two 1"，即 111221
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
class Solution {
    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }
        val prev = countAndSay(n - 1)

        var count = 0
        var cur: Char? = null

        var str = ""
        for (c in prev) {
            when {
                cur == null -> {
                    cur = c
                    count = 1
                }
                cur == c -> count++
                cur != c -> {
                    str += "$count$cur"
                    cur = c
                    count = 1
                }
            }
        }
        if (count > 0) {
            str += "$count$cur"
        }

        return str
    }
}
