class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0;
        int i = 0;
        int num = 0;
        boolean isFirst = true;
        while(i < abbr.length() && j < word.length()){
            char c = abbr.charAt(i);
            if(!Character.isDigit(c)){
                if(word.charAt(j) != abbr.charAt(i)){
                    return false;
                }
                else {
                    j++;
                }
                i++;
            }
            else 
            {
                if(c == '0' && isFirst) return false;
                
                while(i < abbr.length() && abbr.charAt(i) - '0' >= 0 && abbr.charAt(i) - '0' <= 9)
                {
                    int cur = abbr.charAt(i) - '0';
                    num = num * 10 + cur;
                    i++;
                }
                j += num;
                // remember to reset num
                num = 0;
            }
        }

        return j == word.length() && i == abbr.length();
    }
}