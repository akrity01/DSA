class Solution {
    int []t= new int[46];
    int solve (int n )
    {
        if ( n< 0)
        {
             return 0 ;

        }
        if (n==0)
        {
            return 1;
        }
        if (t[n] != -1)
        return t[n];
        int one = solve(n-1);
        int two =solve  (n-2);
        return t[n]=one + two;
    }
    public int climbStairs(int n) {
      Arrays.fill(t,-1);
       return  solve(n);
    }
}