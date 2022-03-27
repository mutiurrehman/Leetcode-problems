class comp implements Comparator<int[]> {
    public int compare(int[] arr1, int[] arr2)
    {
        if(arr1[1]>arr2[1])
            return 1;
        if(arr1[1] == arr2[1]){
            if(arr1[0]>arr2[0])
                return 1;
            else
                return -1;
        }
        
        return -1;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
                
        PriorityQueue<int[]> pq = new PriorityQueue<>(new comp());
        
        for(int i=0;i<mat.length;i++){
            int [] temp = new int[2];
            int count=0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] == 1)
                    count++;
            }
            temp[0] = i;
            temp[1] = count;
            pq.add(temp);
        }
        
        int[] ans = new int[k];
        int i=0;
        while(k-->0){
            ans[i++] = pq.poll()[0];
        }
        
        return ans;
    }
}