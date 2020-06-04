package core.acm.leetcode.cn

import java.util.*

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索


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
val depth_map = mutableMapOf<TreeNode, Int>()

fun TreeNode.setDepth(depth: Int) {
    depth_map[this] = depth
}

fun TreeNode.getDepth(): Int {
    return depth_map.getOrDefault(this, 0)
}

class Question_104 {

    //使用迭代处理
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val stack = LinkedList<TreeNode>()

        stack.push(root)
        root.setDepth(1)
        var maxDepth = 1
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            val curDepth = node.getDepth()
            maxDepth = maxDepth.coerceAtLeast(curDepth)

            if (node.left != null) {
                node.left!!.setDepth(curDepth + 1)
                stack.push(node.left)
            }
            if (node.right != null) {
                node.right!!.setDepth(curDepth + 1)
                stack.push(node.right)
            }
        }
        return maxDepth
    }

    //使用递归处理
    //实际上数据量小的时候用递归速度更快一些
    //但是如果递归层数多了的话就有可能堆栈溢出
    fun maxDepthRecursively(root: TreeNode?): Int {
        return if (root != null) maxDepthRecursively(root.left).coerceAtLeast(maxDepthRecursively(root.right)) + 1 else 0
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)

    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)

    val question = Question_104()
    question.maxDepth(root)
}