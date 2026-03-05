class Solution {
    private int getnextNumber(int n )
    { int sum=0;
        while(n>0)
        {
            int digit= n %10;
            sum+= digit*digit;
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n ;
         int fast = getnextNumber(n) ;
        while(fast!=1 && slow!=fast)
        {
            slow= getnextNumber(slow);
            fast = getnextNumber(getnextNumber(fast));
        }
        return fast==1;
    }
}