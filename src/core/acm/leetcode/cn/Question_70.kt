package core.acm.leetcode.cn
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Question_70 {
    fun climbStairs(n: Int): Int {
        var result = 1 // 当只有一阶的时候结果只有一种

        var step_prev = 1 // 前一阶的结果
        var step_prev_prev = 0// 前二阶的结果
        for (i in 1..n) {
            result = step_prev + step_prev_prev// 走到目标格要么是从上一阶走一步，要么是前二阶走两步
            //更新前面的阶数
            step_prev_prev = step_prev
            step_prev = result
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
