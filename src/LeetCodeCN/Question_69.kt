package LeetCodeCN
//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Question_69 {
    fun mySqrt(x: Int): Int {
        if (x <= 1) {
            return x
        }
        //二分法
        var left = 0
        var right = x
        var mid = (right + left) / 2
        do {
            if (right - left <= 1) {
                return mid
            }

            if (isPowEqualOrSmaller(mid, x)) {
                left = mid
            } else {
                right = mid
            }
            mid = (right + left) / 2

        } while (true)
    }

    fun isHit(curV: Int, target: Int): Boolean {
        return isPowEqualOrSmaller(curV, target) && !isPowEqualOrSmaller(curV + 1, target)
    }

    fun isPowEqualOrSmaller(curV: Int, target: Int): Boolean {
        return target / curV >= curV
    }
}

//leetcode submit region end(Prohibit modification and deletion)
