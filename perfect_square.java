Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0 || num==1){
            return true;
        }
        int rem=num%10;
        if(rem==2 || rem==3 || rem==7 || rem==8){
            return false;
        }
        long div=num/2;
        while(div*div>num){
            div=(div+num/div)/2;
        }
        return div*div==num;
    }
}
