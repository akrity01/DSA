class Solution {
    public boolean isPalindrome(int x) {
        if ( x<0|| x%10 ==0 && x!= 0 )
        {
            return false;
        }
         int revHalf= 0 ;
         while( revHalf<x )
         {
int rem = x%10;
revHalf = revHalf *10+rem;
 x=x/10; 
         }
          return (x==revHalf || x==revHalf/10);
    }
}