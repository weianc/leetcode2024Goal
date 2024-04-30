class Solution {
    String N = "Neither";
    String ipv4 = "IPv4";
    String ipv6 = "IPv6";
    public String validIPAddress(String queryIP) {
        if(queryIP == null || queryIP.length() == 0 || queryIP.length() > 39) return N;
        String[] arr = queryIP.split("\\.");
        if(arr.length == 4 && isNotStartOrEndWithDelimiter(queryIP, '.')&& isIPV4(arr)) return ipv4;
        String[] arr2 = queryIP.split("\\:");
        if(arr2.length == 8 && isNotStartOrEndWithDelimiter(queryIP, ':') && isIPV6(arr2)) return ipv6;
        return N;
    }

    private boolean isNotStartOrEndWithDelimiter(String s, char del){
        if (s.charAt(0) != del && s.charAt(s.length()-1) != del){
            return true;
        }
        return false;
    }

    private boolean isIPV4(String[] ipArrays){
        for(int i = 0; i < ipArrays.length; i++){
            String s = ipArrays[i];
            if(s.isEmpty() || s.length() > 1 && s.charAt(0) == '0'){
                return false;
            }
            
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c - '0' < 0 || c - '0' > 9){
                    return false;
                }
            }
            int num = Integer.parseInt(s);
            if(num < 0 || num > 255) return false;
        }
        return true;
    }

    private boolean isIPV6(String[] ipArrays){
        for(String s : ipArrays){
            // s length should not exceed 4
            if(s.length() > 4 || s == null || s.length() == 0) return false;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!isHexadecimalChar(c)){
                    return false;
                }
            }
            
        }
        return true;
    }

    private boolean isHexadecimalChar(char c){
            if((c - 'a' >= 0 && c - 'a' <= 5) 
                || (c - 'A' >= 0 && c - 'A' <= 5) 
                || Character.isDigit(c)){
                    return true;
                }
            return false;
    }

}