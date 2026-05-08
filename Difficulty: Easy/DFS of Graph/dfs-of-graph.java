class Solution {
    public void dfs_help(int node , ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result)
    {
        visited[node]= true;
        result.add(node);
        for (int neighbour : adj.get(node))
        {
            if (!visited[neighbour])
            {
                dfs_help(neighbour,adj,visited,result);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n= adj.size();
        
        
        boolean []visited= new boolean[n];
        ArrayList<Integer>result= new ArrayList<>();
        dfs_help(0, adj, visited, result);
        return result;
        
        
    }
}