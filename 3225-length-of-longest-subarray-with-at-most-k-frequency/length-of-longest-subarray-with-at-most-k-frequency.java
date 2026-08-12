class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map= new HashMap<>();
      int left =0 , ans=0;
      for (int right =  0 ; right<nums.length; right++)
      {
       map.put(nums[right], map.getOrDefault(nums[right],0)+1);
      
      while(map.get(nums[right])>k)
      {
        map.put(nums[left] , map.get(nums[left])-1);

        left++;
      }
      int curlength= right-left +1;
      ans= Math.max(curlength, ans);
      }
    return ans;
} 
}