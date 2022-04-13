class Solution {
    public String reorderSpaces(String text) {
      
        // count spaces
        int numSpaces = 0;
        for(char ch : text.toCharArray()) {
            if(ch == ' ') {
                numSpaces++;
            }
        }
        
        // trim text and count words
        text = text.trim();
        String[] words = text.split("\\s+");
        int numWords = words.length;

        // calculate spaces in between and extra spaces
        int spacesInBetween = 0;
        int extraSpaces = 0;
        StringBuilder builder = new StringBuilder();
        if(numWords <= 1) {
            extraSpaces = numSpaces;
        } else {
            spacesInBetween = numSpaces / (numWords - 1);
            extraSpaces = numSpaces % (numWords - 1);
        }
  
        // prepare output
        for(int i=0; i<words.length; i++) {
            builder.append(words[i]);
            if(i!= words.length -1) {
                builder.append(" ".repeat(spacesInBetween));
            }
        }
        builder.append(" ".repeat(extraSpaces));
        
        return builder.toString();
    }
}