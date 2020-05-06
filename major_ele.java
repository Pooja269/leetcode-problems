/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/
class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer, Integer> count = new HashMap<Integer, Integer>(); 
        for(int i=0;i<nums.length;i++){
            if (count.containsKey(nums[i]) ) 
                count.put(nums[i], count.get(nums[i]) + 1); 
            else count.put(nums[i] , 1);
        }
        int n=nums.length;
        int major=0;
        for(int i=0;i<nums.length;i++){
            if(count.get(nums[i])>n/2){
                major=nums[i];
                break;
            }
        }
        return major;
    }
}
