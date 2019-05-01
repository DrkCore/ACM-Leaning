/*
 * @lc app=leetcode.cn id=66 lang=kotlin
 *
 * [66] 加一
 */
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var result = digits

        var addOn = false
        var idx = result.size - 1
        while (idx >= 0 || addOn) {
            if (idx < 0) {
                result = IntArray(digits.size + 1)
                System.arraycopy(digits, 0, result, 1, digits.size)
                result[0] = 1
                break

            } else if (result[idx] == 9) {
                result[idx] = 0
                addOn = true

            } else {
                result[idx]++
                break
            }
            idx--
        }
        return result
    }
}

