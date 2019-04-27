/*
 * @lc app=leetcode.cn id=70 lang=kotlin
 *
 * [70] 爬楼梯
 */
class Solution {
    fun climbStairs(n: Int): Int {
        var result = 1
        var step_prev = 1
        var step_prev_prev = 0

        for (i in 1..n) {
            result = step_prev + step_prev_prev
            step_prev_prev = step_prev
            step_prev = result
        }

        return result
    }
}

