class Solution {
    public int removeDuplicates(int[] nums) {
        if ( nums.length ==0) return 0 ;
        int officer=0;
        for (int cm = 1;cm<nums.length; cm ++)
        {
            if ( nums[cm]!=nums[officer])
            {
                officer ++ ;
                 nums[officer]=nums[cm];
            }
            }
            return officer+1;
        }
}