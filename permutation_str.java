/*Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count=new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
        }
        int s=0;
        int e=0;
        int len=s1.length();
        while(e<s2.length()){
            if(count[s2.charAt(e++)-'a']-->=1) len--;
            if(len==0) return true;
            if(e-s==s1.length() && count[s2.charAt(s++)-'a']++>=0) len++;
        }
        
        return false;
    }
}
