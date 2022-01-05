class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a) {
        
        long sum = mass;
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            if(a[i]<=sum){
                sum+=a[i];
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}