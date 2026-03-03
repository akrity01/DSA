class Solution {
    public int longestOnes(int[] nums, int k) {
     int low =0 , high, maxlen= 0 ;
     int zerocount=0;

     for (  high =0; high<nums.length; high++)
     {
        if (nums[high]==0)
        {  zerocount ++;
            while(zerocount>k)
            {  if (nums[low]==0)
                {zerocount--;
                }
                low++;
            }
        }
        maxlen= Math.max(maxlen,high-low+1);
     } 
     return maxlen;  
    }
}