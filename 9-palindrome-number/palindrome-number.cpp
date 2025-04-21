class Solution {
public:
    bool isPalindrome(int x) {
         if(x<0)
{
    return 0;
}
    long long int  copy, rev=0,rem;
    
        copy=x;
         while (copy!=0)
         {
             rem = copy % 10;
            rev= rev*10+rem;
            copy= copy/10;
         }
         return (x==rev);
    }

};