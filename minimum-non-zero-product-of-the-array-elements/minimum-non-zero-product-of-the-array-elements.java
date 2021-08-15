class Solution {
    private int MOD = 1_000_000_007;
    public int minNonZeroProduct(int p) {
        long n = 1L<<p;
        long res = (((n-1) % MOD) * fastPow(n-2, n/2-1)) % MOD;
        return (int)res;
    }
    
    private long fastPow(long base, long n) {
        if (n == 0) return 1L;
        if (n == 1) return base;
        base %= MOD;
        long halfn = fastPow(base, n/2) % MOD;
        if (n % 2 == 0)
            return (halfn * halfn) % MOD;
        else
            return (((halfn * halfn) % MOD) * base) % MOD;
    }
}