package core.acm.leetcode.cn

import java.util.*

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
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
class Question_107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
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
                result.add(0, curDepthNodes)
            }
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
