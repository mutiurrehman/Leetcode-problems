class Solution {
    public int longestPalindrome(String word1, String word2) {
        String word = word1 + word2;
        int n = word.length(), ans = 0;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (word.charAt(i) == word.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if (i < word1.length() && j >= word1.length()) { // Check if this palindrome begins with word1[i] and ends with word2[j]
                        ans = Math.max(ans, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return ans;
    }
}