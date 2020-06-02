package LeetCodeCN
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Question_53 {
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
//leetcode submit region end(Prohibit modification and deletion)
