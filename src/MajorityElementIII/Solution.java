import java.util.*;
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if(nums == null || nums.size() == 0){
            return 0;
        }


        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num) + 1);
            }else{
                hm.put(num, 1);
            }
            if(hm.size() >= k){
                removeKey(hm);
            }
        }

        Set<Integer> hs = hm.keySet();
        hm = new HashMap<>();

        for(int num : nums){
            if(hs.contains(num)){
                if(!hm.containsKey(num)){
                    hm.put(num, 1);
                }else{
                    hm.put(num, hm.get(num) + 1);
                }
            }
        }

        int maj = 0;
        int cnt = 0;
        for(int key : hm.keySet()){
            if(hm.get(key) > cnt){
                cnt = hm.get(key);
                maj = key;
            }
        }
        return maj;
    }

    private void removeKey(HashMap<Integer, Integer> hm){
        HashSet<Integer> keysToBeRemoved = new HashSet<>();
        for(int key : hm.keySet()){
            int cnt = hm.get(key);
            if(cnt == 1){
                keysToBeRemoved.add(key);
            }else{
                cnt --;
                hm.put(key, cnt);
            }
        }

        for(int key : keysToBeRemoved){
            hm.remove(key);
        }
    }
}

