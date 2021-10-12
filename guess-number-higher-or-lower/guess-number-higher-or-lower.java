/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int l = 1, h = n;
        int ans=0;
        while(l<=h){
            int mid = l+ (h-l)/2;
            int pick  = guess(mid);
            if(pick == 0){
                ans= mid;
                break;
            }
            
            else if(pick<0){
                h=mid-1;
            }
            else{
                l= mid+1;
            }
            
        }
        
        return ans;
    }
}