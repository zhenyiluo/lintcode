public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> list = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12){
            return list;
        }
        
        for(int i = 1; i < 4 && i < s.length() - 2; i++){
            String s1 = s.substring(0, i);
            if(isValid(s1)){
                for(int j = 1; j < 4 && i+j < s.length() - 1; j++){
                    String s2 = s.substring(i, i+j);
                    if(isValid(s2)){
                        for(int k = 1; k < 4 && i+j+k < s.length() ; k++){
                            String s3 = s.substring(i+j, i+j+k);
                            String s4 = s.substring(i+j+k);
                            if(isValid(s3) && isValid(s4)){
                                list.add(s1 + "." + s2 + "." + s3 + "." + s4);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
    
    private boolean isValid(String s){
        if(s.charAt(0) == '0' && s.length() > 1){
            return false;
        }
        
        int n = Integer.valueOf(s);
        if(n <= 255){
            return true;
        }
        return false;
    }
}