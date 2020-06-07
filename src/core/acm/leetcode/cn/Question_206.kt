package core.acm.leetcode.cn
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
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
class Question_206 {

    fun reverseList(head: ListNode?): ListNode? {
        return reverseListRecursively(head);
    }

    fun reverseListRecursively(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val next = head.next
        head.next = null//记得断开链表结构

        // 使用递归处理，此时 newHead 是下一节点重排后的结果
        // next 是其末尾节点
        val newHead = reverseListRecursively(next)
        //那么只要将 head 拼接到 next 之后就行
        next!!.next = head

        return newHead
    }

    fun reverseListIteratively(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var newHead = head
        var cursor = head.next
        head.next = null
        while (cursor != null) {
            val next = cursor.next

            cursor.next = newHead
            newHead = cursor;

            cursor = next
        }

        return newHead
    }
}
//leetcode submit region end(Prohibit modification and deletion)
