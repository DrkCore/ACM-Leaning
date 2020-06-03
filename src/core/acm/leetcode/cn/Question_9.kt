package core.acm.leetcode.cn
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Question_9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        } else if (x < 10) {
            return true
        }

        var pow = 1
        while (x / Math.pow(10.0, pow.toDouble()) >= 10) {
            pow++
        }

        for (i in 0..pow / 2) {
            var st = Math.pow(10.0, i.toDouble()).toInt()
            var en = Math.pow(10.0, (pow - i).toDouble()).toInt()
            if (st == en) {
                continue
            }

            var stNum = x / st % 10
            var enNum = x / en % 10
            if (stNum != enNum) {
                return false
            }
        }

        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
