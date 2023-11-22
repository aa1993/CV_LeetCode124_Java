/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root!=null)
        {
            int sumRootRoot = root.val;
            int sumLeft = this.maxRootPathSum(root.left);
            int sumRight = this.maxRootPathSum(root.right);
            boolean isSumLeft = sumLeft != Integer.MIN_VALUE;
            boolean isSumRight = sumRight != Integer.MIN_VALUE;
            boolean isSumLeftGreat = sumLeft+root.val > root.val;
            boolean isSumRightGreat = sumRight+root.val > root.val;
            if(isSumRight && isSumRightGreat)
                sumRootRoot+=sumRight;
            if(isSumLeft && isSumLeftGreat)
                sumRootRoot+=sumLeft;
            
            int sumLeftRoot = this.maxPathSum(root.left);
            int sumRightRoot = this.maxPathSum(root.right);
            if(sumLeftRoot>sumRootRoot)
            {
                if(sumLeftRoot>sumRightRoot)
                    return sumLeftRoot;
                else
                    return sumRightRoot;
            }
            if(sumRightRoot>sumRootRoot)
                return sumRightRoot;
            else
                return sumRootRoot;
                
        }
        return Integer.MIN_VALUE;
    }
    
    public int maxRootPathSum(TreeNode root)
    {
        if(root!=null)
        {
            int sumLeft = this.maxRootPathSum(root.left);
            int sumRight = this.maxRootPathSum(root.right);
            boolean isSumLeft = sumLeft != Integer.MIN_VALUE;
            boolean isSumRight = sumRight != Integer.MIN_VALUE;
            boolean isSumLeftGreat = sumLeft+root.val > root.val;
            boolean isSumRightGreat = sumRight+root.val > root.val;
            boolean isSumLeftGreaterRight = sumLeft > sumRight;
            
            if(isSumLeft && isSumLeftGreat && isSumLeftGreaterRight)
                return sumLeft + root.val;
            if(isSumRight && isSumRightGreat && !isSumLeftGreaterRight)
                return sumRight + root.val;
            return root.val;
            
        }
        return Integer.MIN_VALUE;
    }
}