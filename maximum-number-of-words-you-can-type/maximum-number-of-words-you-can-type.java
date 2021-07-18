class Solution {
    public int canBeTypedWords(String text, String b) {
        int count=0;
        
        String[] arr = text.split(" ");
        for(int i=0;i<arr.length;i++){
            boolean check =true;
            for(int j=0;j<b.length();j++){
                if(arr[i].indexOf(b.charAt(j))!=-1)
                {
                    check = false;
                    break;
                }
            }
            if(check)
                count++;
        }
        
        return count;
    }
}