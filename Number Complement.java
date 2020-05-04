/*Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0
*/

import java.lang.Math;
class Solution {
    public int findComplement(int num) {
        String a="";
        while(num>0){
            int rem=num%2;
            a=a+rem;
            num=num/2;
        }
        int comp=0;
        int comp_val=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='0'){
                comp=1;
                comp_val=comp_val+comp*(int)Math.pow(2,i);
            }
            else{
                comp=0;
                comp_val=comp_val+comp*(int)Math.pow(2,i);
            }
        }
        return comp_val;
    }
}
