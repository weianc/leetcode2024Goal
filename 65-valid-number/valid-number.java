class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean seenDigit = false;
        boolean seenDecimal = false;
        boolean seenExponent = false;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //There must always be at least one digit in the input for it to form a valid number.
            if(c - '0' >= 0 && c - '0' <= 9){
                seenDigit = true;
            }
            else if(c == '+' || c == '-'){
                // 1. first char
                // 2. right after exponent Ex. -63E+7
                if(i > 0 && s.charAt(i-1) != 'E' && s.charAt(i-1) != 'e'){
                    return false;
                }
            }
            else if(c == 'e' || c == 'E'){
                // e present only once
                // e must appear after decimal or integer
                if(seenExponent || !seenDigit){
                    return false;
                }
                seenExponent = true;
                // there has to be integer after e/E 
                seenDigit = false;
            }
            else if (c == '.'){
                // only one dot allowed
                // not dot after E/e
                if(seenDecimal || seenExponent){
                    return false;
                }
                seenDecimal = true;
            }
            else {
                return false;
            }
        }
        return seenDigit;
    }
}