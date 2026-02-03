class Solution {
    public boolean isPalindrome(int x) {
        if ( x<0|| x%10 ==0 && x!= 0 )
        {
            return false;
        }
         int revHalf= 0 ;
         while( x>revHalf )
         {
int rem = x%10;
revHalf = revHalf*10 + rem;
 x=x/10; 
         }
          return (x==revHalf|| x==revHalf/10);
    }
}
// class Solution {
//     public boolean isPalindrome(int x) {

//         if (x < 0 || (x % 10 == 0 && x != 0)) {
//             return false;
//         }

//         int rev = 0;

//         while (x > rev) {
//             int digit = x % 10;
//             rev = rev * 10 + digit;
//             x = x / 10;
//         }

//         return (x == rev || x == rev / 10);
//     }
// }



