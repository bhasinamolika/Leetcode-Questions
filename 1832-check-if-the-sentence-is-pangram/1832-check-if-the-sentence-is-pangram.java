// class Solution {
//     public boolean checkIfPangram(String sentence) {
//         int characters[]=new int[26];
//         boolean flag=true;
//         for(char ch:sentence.toCharArray()){
//             characters[ch-'a']++;
//         }
//         for(int i=0;i<26;i++){
//             if(characters[i]==0){
//                 flag=false;
//                 break;
//             }
//         }
//         return flag;
//     }
// }

class Solution {
    public boolean checkIfPangram(String sentence) {
        // Initialize seen = 0 since we start with no letter.
        int seen = 0;
        
        // Iterate over 'sentence'.
        for (char currChar : sentence.toCharArray()) {
            // Map each 'currChar' to its index using its ASCII code.
            int mappedIndex = currChar - 'a';

            // 'currBit' represents the bit for 'currChar'.
            int currBit = 1 << mappedIndex;

            // Use 'OR' operation since we only add its bit for once.
            seen |= currBit;
        }
        
        // Once we finish iterating, check if 'seen' contains 26 bits of 1.
        return seen == (1 << 26) - 1;
    }
}