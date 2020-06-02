package LeetCodeCN
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Question_14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        val target = strs[0]
        var maxHit = target.length

        for (i in 1 until strs.size) {
            var hit = 0;
            for ((idx, c) in strs[i].withIndex()) {
                if (target.length > idx && target[idx] == c) {
                    hit = idx + 1
                } else {
                    break
                }
            }
            maxHit = Math.min(maxHit, hit)
            if (maxHit == 0) {
                break
            }
        }

        return target.substring(0, maxHit)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
