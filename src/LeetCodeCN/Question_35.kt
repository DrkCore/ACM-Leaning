package LeetCodeCN
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Question_35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        //使用二分法
        var leftIdx = 0
        var rightIdx = nums.size - 1
        while (leftIdx <= rightIdx) {
            val middleIdx = (leftIdx + rightIdx) / 2
            when {
                nums[middleIdx] == target -> {
                    //刚好命中，直接返回
                    return middleIdx

                }
                nums[middleIdx] < target -> {
                    //目标值在中心区域的左侧
                    leftIdx = middleIdx + 1
                }
                else -> {
                    //目标值在中心区域的右侧
                    rightIdx = middleIdx - 1
                }
            }
        }

        return leftIdx
    }

    //使用简单的比对方法，遇上较大数组的话性能较差
    fun searchInsert_V1(nums: IntArray, target: Int): Int {
        for ((idx, v) in nums.withIndex()) {
            if (target <= v) {
                return idx
            }
        }
        return nums.size
    }
}
//leetcode submit region end(Prohibit modification and deletion)
