class Solution {
    public int findKthPositive(int[] arr, int k) {
    int mid = -1, l=0, r=arr.length-1;
     while  (l<=r)
     {
        mid = l+(r-l)/2;
        int miss = arr[mid] - (mid+1) ;
        if ( miss< k)
        {
            l=mid +1;
        }     
        else {
            r=mid-1;
        }
        }
        return l+k;
        }

       }

