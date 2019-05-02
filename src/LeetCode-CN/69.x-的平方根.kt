/*
 * @lc app=leetcode.cn id=69 lang=kotlin
 *
 * [69] x 的平方根
 */
class Solution {
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
