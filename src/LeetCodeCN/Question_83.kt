package LeetCodeCN
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Question_83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var cur = head
        while (cur?.next != null) {
            if(cur.`val` == cur.next!!.`val`){
                cur.next = cur.next!!.next

            }else{
                cur = cur.next
            }
        }

        return head
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    print("asd")
}
