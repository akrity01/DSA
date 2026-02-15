class Solution {
    public int removeDuplicates(int[] nums) {
         int i =0, j=1 ;
         int k =1;
         while(j<nums.length)
         {
            if (nums[j]==nums[j-1] )
            {
                j++;
            }

            else{
            i++;
            k++;
            nums[i]=nums[j];
            j++;
            }
         }
         return k;
    }
}