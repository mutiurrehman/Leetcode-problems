class Solution {
    public int[] findOriginalArray(int[] ch) {
        int n = ch.length;
        if(n%2==1)
            return new int[0];
        
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
        }
     
        Arrays.sort(ch);
        for(int i=0;i<n;i++){
            int ele = (int)ch[i];
            int dele = 2*ele;
            
            boolean check = map.containsKey(dele);
             boolean check2 = map.containsKey(ele);
            if(ele==0){
                if(check){
                    int c = map.get(ele);
                    if(c>1){
                        arr.add(ele);
                        map.put(ele,map.get(ele)-2);
                        if(map.get(ele)==0)
                            map.remove(ele);
                    }
                }
            }
            else{
               
                if(check2 && check){
                    int countFirst = map.get(ele);
                    if(countFirst==1){
                        map.remove(ele);
                    }
                    else{
                        map.put(ele, map.get(ele)-1);
                    }
                    int countSecond = map.get(dele);
                    if(countSecond==1){
                        map.remove(dele);
                    }
                    else{
                        map.put(dele, map.get(dele)-1);
                    }
                    arr.add(ele);
                }
            }
        }
        
        if(arr.size()<n/2)
            return new int[0];
        
        int[] ans = new int[n/2];
        for(int i=0;i<ans.length;i++){
            ans[i] = (int)arr.get(i);
        }
        
        return ans;
    }
}