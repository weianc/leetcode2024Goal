class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < strings.length; i++){
            String s = strings[i];
            String p = pattern(s);
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

    private String pattern(String s){
        StringBuilder pattern = new StringBuilder();
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            int num = arr[i] - arr[0];
            if(num < 0){
                num += 26;
            }
            // Append the actual offset value
            pattern.append(num).append(',');
        }

        return pattern.toString();
    }
}