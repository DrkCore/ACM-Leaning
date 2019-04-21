/*
 * @lc app=leetcode.cn id=21 lang=kotlin
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (53.97%)
 * Total Accepted:    62K
 * Total Submissions: 114.8K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var left = l1
        var right = l2

        var head: ListNode? = null
        var prev: ListNode? = null
        var cur: ListNode? = null
        while (left != null || right != null) {
            var leftVal = if (left != null) left.`val` else Int.MAX_VALUE
            var rightVal = if (right != null) right.`val` else Int.MAX_VALUE

            val targetVal = Math.min(leftVal, rightVal)
            if (targetVal == leftVal) {
                left = left?.next
            } else {
                right = right?.next
            }
            cur = ListNode(targetVal)

            if (head == null) {
                head = cur
                prev = head
            } else {
                prev?.next = cur
                prev = cur
            }
        }

        return head
    }
}

