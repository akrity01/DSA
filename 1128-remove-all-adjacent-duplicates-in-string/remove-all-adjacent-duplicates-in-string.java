class Solution {
    public String removeDuplicates(String s) {
     Stack<Character> st= new Stack<>();
     for ( char ch : s.toCharArray())
     {
        if (! st.isEmpty() && st.peek()==ch)
        {
            st.pop();

        }
        else 
        {
            st.push(ch);
        }
     }   
  StringBuilder result= new StringBuilder();

  while(! st.isEmpty())
  {
    result.append(st.pop());
  }
  return result.reverse().toString();
    }
}