class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]>result= new ArrayList<>();
     int i = 0 , j=0;
     while ( i<firstList.length && j < secondList.length)
     {
        int s1= firstList[i][0];
        int  e1= firstList[i][1];
        int s2= secondList[j][0];
        int e2= secondList[j][1];
        if ( s1<=s2)
        {
            if(e1>=s2)
            {
                int s= Math.max(s1, s2);
                int e= Math.min(e1, e2);
                result.add(new int []{s, e});
            }
        }
        else 
        {
           if ( e2>=s1)
           {
             int s= Math.max(s1, s2);
                int e= Math.min(e1, e2);
                result.add(new int[]{ s, e});
           } 
        }
        if ( e1<= e2)
        {
            i++;
        }
        else 
        {
            j++;
        }
     } 
      return result.toArray(new int[result.size()][]);
    }
}