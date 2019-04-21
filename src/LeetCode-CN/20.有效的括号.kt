import java.util.*

/*
 * @lc app=leetcode.cn id=20 lang=kotlin
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.43%)
 * Total Accepted:    66.1K
 * Total Submissions: 176.6K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (c in s) {
            if (c == ' ' || c == '"') {
                continue
            }
            val peek = if (!stack.isEmpty()) stack.peek() else null
            if ('(' == peek && c == ')' ||
                '[' == peek && c == ']' ||
                '{' == peek && c == '}'
            ) {
                stack.pop()
                continue
            }

            stack.push(c)
        }
        return stack.isEmpty()
    }
}

