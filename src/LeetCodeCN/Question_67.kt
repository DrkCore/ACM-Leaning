package LeetCodeCN
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Question_67 {
    fun addBinary(a: String, b: String): String {
        var l = 0
        var r = 0

        var addOn = booleanArrayOf(false)
        var end = Math.max(a.length, b.length)
        var builder = StringBuilder(end + 1)
        var idx = 0
        while (idx < end) {
            if (idx < a.length && idx < b.length) {
                builder.append(addChar(a[a.length - idx - 1], b[b.length - idx - 1], addOn))

            } else if (idx < a.length) {
                builder.append(addChar(a[a.length - idx - 1], '0', addOn));

            } else {
                builder.append(addChar(b[b.length - idx - 1], '0', addOn))
            }

            idx++
        }
        if (addOn[0]) {
            builder.append('1')
        }

        return builder.reverse().toString()
    }

    private fun addChar(a: Char, b: Char, addOn: BooleanArray): Char {
        val result: Char
        if (a == '1' && b == '1') {
            result = if (addOn[0]) '1' else '0'
            addOn[0] = true

        } else if (a == '0' && b == '0') {
            result = if (addOn[0]) '1' else '0'
            addOn[0] = false

        } else {
            result = if (addOn[0]) '0' else '1'
        }
        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
