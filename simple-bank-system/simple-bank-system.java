class Bank {

    long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int a1, int a2, long money) {
         if(a1-1>=balance.length)
            return false;
         if(a2-1>=balance.length)
            return false;
        if(balance[a1-1]<money)
            return false;
        
        balance[a1-1] -= money;
        balance[a2-1] += money;
        return true;
            
    }
    
    public boolean deposit(int account, long money) {
        if(account-1>=balance.length)
            return false;
        balance[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account-1>=balance.length)
            return false;
        if(balance[account-1]<money)
            return false;
        
        balance[account-1]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */