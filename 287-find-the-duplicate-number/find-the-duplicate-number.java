class Solution {
    public int findDuplicate(int[] nums) {
     int slow = 0 ;
     int fast = 0;
     while(true)
     {
        slow=nums[slow] ;
        fast=nums [nums[fast]];
         if ( slow==fast) // because cycle definetly exists and we are  finding where the cyle is starting or the duplicate number  , the number of incoming arrows to the duplicate number wull be more than 2 , we are mapping the address and the data in the array  according to the range
        {
            slow = 0 ;
            while (slow != fast)
            {
                slow = nums[slow];
                fast= nums[fast];
            }
            return slow; // or fast both are equal here 
            }
        }
    }
}