class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        char[] ascii = new char[26];
        int count = 0;
        for(char c = 'a'; c <= 'z'; c++){
            ascii[count++] = c;
        }

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < strings.length; i++){
            String s = strings[i];
            String p = pattern(s, ascii);
            if(!map.containsKey(p)){
                map.put(p, new ArrayList<String>());
            }
            List<String> list = map.get(p);
            list.add(s);
        }

        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }

    private String pattern(String s, char[] ascii){
        StringBuilder pattern = new StringBuilder();
        char[] arr = s.toCharArray();
        int diff = -1;

        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                diff = arr[0] - 'a';
            }
            int num = arr[i] - 'a' - diff;
            if(num < 0){
                num += 26;
            }
            char c =  ascii[num];
            
            pattern.append(c);
        }
        String ans = pattern.toString();
        System.out.println("s: " + s + ", pattern: " + ans);
        return ans;
    }
}