/*Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        for(int i=0;i<k;i++){
            int j=0;
            while(j<num.length()-1 && num.charAt(j)<=num.charAt(j+1)){             
                j++;
            }
            num=num.substring(0,j)+num.substring(j+1);
        }
        while(num.length()>1 && num.charAt(0)=='0'){
            num=num.substring(1);
        }
        return num;
    }
}
