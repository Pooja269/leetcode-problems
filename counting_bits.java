/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:
Input: 2
Output: [0,1,1]

Example 2:
Input: 5
Output: [0,1,1,2,1,2]
*/
class Solution {
    public int countones(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    public int[] countBits(int num) {
        int[] count=new int[num+1];
        count[0]=0;
        for(int i=1;i<=num;i++){
            
            count[i]=countones(i);
        }
        return count;
    }
}
/*-------another O(n) solution----
class Solution {
    public int[] countBits(int num) {
        int[] count=new int[num+1];
        count[0]=0;
        for(int i=1;i<=num;i++){
            
            count[i]=count[i&(i-1)]+1;
        }
        return count;
    }
}

-------***another O(n) solution***----
class Solution {
   public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            result[i] = i % 2 == 0 ? result[i / 2] : result[i / 2] + 1;
        }
        return result;
    }
}
*/
