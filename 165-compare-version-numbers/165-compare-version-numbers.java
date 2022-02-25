class Solution {
    public int compareVersion(String A, String B) {
        String[] a = A.split("\\.");
        String[] b = B.split("\\.");
        for(int i=0;i<Math.max(a.length,b.length);i++)
        {
            Double v1 = (i<a.length)?Double.parseDouble(a[i]):0;
            Double v2 = (i<b.length)?Double.parseDouble(b[i]):0;
            if(v1<v2)
            return -1;
            else if(v1>v2)
            return 1;
        }
      return 0;  
    }
}