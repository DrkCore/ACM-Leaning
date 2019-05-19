/*
 * @lc app=leetcode.cn id=83 lang=kotlin
 *
 * [83] 删除排序链表中的重复元素
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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var cur = head
        while (cur != null && cur.next != null) {
            if(cur.`val` == cur.next.`val`){
                cur.next = cur.next.next

            }else{
                cur = cur.next
            }
        }

        return head
    }
}

