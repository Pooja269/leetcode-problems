/*Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int zero=0;
        int one=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }else{
                one++;
            }
            
            if(map.containsKey(zero-one)){
                len=Math.max(len,i-map.get(zero-one));
            }else{
                map.put(zero-one,i);
            }
        }
        
        return len;
    }
}
