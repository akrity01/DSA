class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int i =0 , j= arr.length-1;
        while ( i < j)
        {
        if (arr[i]!=0)
        {
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j]=temp;
            j--;
        }
        else 
        i++;
        }
        return ;
    }
}
