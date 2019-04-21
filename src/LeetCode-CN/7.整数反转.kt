/*
 * @lc app=leetcode.cn id=7 lang=kotlin
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (32.22%)
 * Total Accepted:    113.8K
 * Total Submissions: 353.1K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */
class Solution {
    fun reverse(x: Int): Int {
        if (x == 0) {
            return 0
        }

        var left = Math.abs(x);
        val positive = x / left;

        var result = 0L
        while (left > 0) {
            result = result * 10 + left % 10
            left /= 10

            if(result > Int.MAX_VALUE){
                return 0
            }
        }

        return (result * positive).toInt()
    }
}

