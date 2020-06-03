package core.acm.leetcode.cn

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Question_387 {
    fun firstUniqChar(s: String): Int {
        if (s.length <= 1) {
            return s.length - 1;
        }

        val array = IntArray(26)
        val firstPosition = IntArray(26)
        for ((i, v) in s.withIndex()) {
            val idx = v - 'a'
            if (array[idx] == 0) {
                firstPosition[idx] = i
            }
            array[idx]++
        }

        var hitIdx: Int? = null
        for ((i, v) in array.withIndex()) {
            if (v == 1) {
                if (hitIdx == null || firstPosition[i] < firstPosition[hitIdx]) {
                    hitIdx = i
                }
            }
        }
        if (hitIdx != null) {
            return firstPosition[hitIdx]
        }
        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val question = Question_387()
    println(question.firstUniqChar("aabbcdd"))
    println(question.firstUniqChar("leetcode"))
    println(question.firstUniqChar("loveleetcode"))
}