package core.acm.leetcode.cn

import java.util.*

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Question_102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        if (root != null) {
            val queue = LinkedList<TreeNode>()
            queue.add(root)
            while (queue.isNotEmpty()) {
                var curDepthCount = queue.size//获取当前层数的个数
                val curDepthNodes = mutableListOf<Int>()
                while (curDepthCount-- > 0) {
                    val node = queue.poll()
                    curDepthNodes.add(node.`val`)

                    if (node.left != null) {//由于存在 count 计数，之后添加的这些节点不会在本次遍历中被访问到，下同
                        queue.add(node.left!!)
                    }
                    if (node.right != null) {
                        queue.add(node.right!!)
                    }
                }
                result.add(curDepthNodes)
            }
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)

    val question = Question_102()
    val result = question.levelOrder(root)
    print(result)
}