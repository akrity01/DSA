class Solution {
    public void sortColors(int[] nums) {
        int c1= 0 , c2=0, c3=nums.length-1;
         while ( c2 <= c3)
         {
            if ( nums[c2]==0)
            {
                swap(nums ,c1,c2);
                c1++;
                c2++;
            }
            else if( nums[c2]==1)
            {
                c2++;
            }
            else{
                 swap(nums ,c2,c3);
                 c3--;
            }
         }
    }
     private  void swap(int[] nums, int i , int j)
     {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
     }
}