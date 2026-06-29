class Solution{
    class Pair
    {
        char ch  ;
         int count ;
         Pair ( char ch , int count )
         {
           this.ch = ch ;
            this.count = count ;
         }
    }
     public String removeDuplicates(String s, int k) {
        Stack <Pair> st= new Stack <> ();
        for ( char c : s.toCharArray())
        {
            if ( st.isEmpty() || st.peek().ch!= c)
            {
                st.push(new  Pair(c, 1));
            }
            else {
                  st.peek().count++;
                  if( st.peek().count==k)
                  {
                    st.pop();
                  }
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty())
        {
            Pair p= st.pop();
            while(p.count>0)
            {
                sb.append(p.ch);
                p.count--;
            }
            }
            return sb.reverse().toString();       
             }
    }
