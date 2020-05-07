/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.


Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
*/
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
}
class Solution {
    public int level_x=0;
    public int level_y=0;
    public String parent_x=null;
    public String parent_y=null;
    public void traverse(TreeNode root,TreeNode parent,int level,int x,int y){
        if(root==null){
            return;
        }
        traverse(root.left,root,level+1,x,y);
        if(root.val==x){
            level_x=level;
            if(parent==null){
                parent_x=null;
            }
            else{
            parent_x=Integer.toString(parent.val);
            }
        }
        if(root.val==y){
            level_y=level;
            if(parent==null){
                parent_x=null;
            }
            else{
                parent_y=Integer.toString(parent.val);
            }
            //System.out.println(parent_x);
        }
        /*if(level_x!=0 && level_y!=0){
            break;
        }*/
        traverse(root.right,root,level+1,x,y);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        int level=1;
        traverse(root,null,1,x,y);
        //System.out.println(parent_x+parent_y);
        if(level_x!=level_y || parent_x.equals(parent_y)){
            return false;
        }
       
        return true;
    }
}
