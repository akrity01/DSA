class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n=nums.size();
        int c0=0;
        int c1=0;
        int c2=0;
        for ( int i=0;i< n ; i++){
           if ( nums[i] ==0)
           {
             c0++;
           }
           else if ( nums[i]==1)
           {
            c1++;
           }
           else
           c2++;
        
        }
        int index= 0;
        for ( int i=0; i< c0; i++){
            nums[index++]=0;        }
             for ( int i=0; i< c1; i++){
            nums[index++]=1;        }
             for ( int i=0; i< c2; i++){
            nums[index++]=2;        }

    }
};