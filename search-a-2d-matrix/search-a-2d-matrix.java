class Solution {
        public boolean searchMatrix(int[][] matrix, int B) {
        int l=0,h=matrix.length-1;
        
        while(l<=h){
            int mid= (l+h)/2;
            
             if(matrix[mid][0]<=B){
                
               int index= Arrays.binarySearch(matrix[mid],B);
               if(index>=0){
                   return true;
               }
              l=mid+1;
            }
            else{
               h=mid-1;
            }
        }
        return false;
    }
}