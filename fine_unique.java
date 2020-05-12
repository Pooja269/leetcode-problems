/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int unique=0;
        for(int i=0;i<nums.length;){
            if(i==(nums.length-1)){
                unique=nums[i];
                break;
            }
            else if(nums[i]!=nums[i+1]){
                unique=nums[i];
                break;
            }
                i=i+2;
        }
        return unique;
    }
}
