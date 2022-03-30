class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i=0;i<matrix.length;i++){
            int ind = Arrays.binarySearch(matrix[i],target);
            if(ind>=0)
                return true;
        }
        
        return false;
    }
}