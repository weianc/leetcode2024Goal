class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean isEven = s.length() % 2 == 0;
        Map<Character, Integer> table = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            table.put(c, table.getOrDefault(c, 0) + 1);
        }
        
        int countOfSingleChar = 0;
        for(Character key : table.keySet()){
            if(table.get(key) % 2 != 0){
                countOfSingleChar++;
                if(isEven || !isEven && countOfSingleChar > 1){
                    return false;
                }
            }
        }
        return true;
    }
}