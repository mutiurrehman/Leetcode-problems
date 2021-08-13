class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int[][] mat = new int[matrix.length][matrix[0].length];
        for(int i =0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j]=matrix[i][j]-'0';
            }
        }
        
        int ans =maxHistorgam(mat[0]);
          for(int i =1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)
                    mat[i][j]+=mat[i-1][j];
                ans=Math.max(ans,maxHistorgam(mat[i]));
            }
        }
        
        return ans;
        
    }
    
    public int maxHistorgam(int[] A){
        int n = A.length;
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i]=A[i];
        }
        arr[n]=0;
        
        int[] nsr = new int[n+1];
        
        Stack<Integer> st = new Stack<>();
        for(int i=n;i>=0;i--){
            
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            
            if(st.isEmpty())
                nsr[i]=-1;
            else
                nsr[i]=st.peek();
            st.push(i);
        }
        
        st=new Stack<>();
        int[]  nsl = new int[n+1];
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                nsl[i]=-1;
            else
                nsl[i]=st.peek();
            st.push(i);
            
        }
        
        int ans =0;
        for(int i=0;i<=n;i++){
            ans=Math.max(ans,(nsr[i]-nsl[i]-1)*arr[i]);
        }
        
        return ans;
    }
}