/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/
class Solution {
    public int firstUniqChar(String s) {
        int j=0;
        int index=-1;
        int i=1;
        int flag=0;
        if(s.length()==1){
            return 0;
        }
        char[] freq = new char[256];
        for(i = 0; i <s.length(); i++) {  
            freq[s.charAt(i)]++;  
        }
        for(i = 0; i <s.length(); i++) { 
            if(freq[s.charAt(i)] == 1){
                index=i;
                break;
            }
        }
        if(s.equals("")){
            index=-1;    
        }
        return index;
    }
}
