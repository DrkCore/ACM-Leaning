/*
 * @lc app=leetcode.cn id=53 lang=kotlin
 *
 * [53] 最大子序和
 */
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var maxSoFar = nums.first()
        var maxEnding = maxSoFar

        for (i in 1 until nums.size) {
            val num = nums[i]
            //maxEnding 表示的是以 i 结尾的最大值，要么是自己本身，要么是前置的结尾拼接上自己
            maxEnding = Math.max(num, maxEnding + num)
            //maxSoFar 表示至 i 为止的最大值，要么是连接了结尾的最大值，要么就在前置的子序列中
            maxSoFar = Math.max(maxSoFar, maxEnding)
        }

        return maxSoFar
    }

}


