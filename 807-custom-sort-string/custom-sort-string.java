

import static java.lang.Character.charCount;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!charCount.containsKey(c)){
                charCount.put(c, 1);
            }
            else {
                charCount.put(c, charCount.get(c) + 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(charCount.containsKey(c)){
                int size = charCount.get(c);
                for(int j = 0; j < size; j++){
                    sb.append(c);
                }
                charCount.remove(c);
            }
        }

        for(Character c : charCount.keySet()){
            int size = charCount.get(c);
            for(int i = 0; i < size; i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}