class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapST = new int[256];  // map from s → t
        int[] mapTS = new int[256];  // map from t → s

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If not already mapped
            if (mapST[c1] == 0 && mapTS[c2] == 0) {
                mapST[c1] = c2;   // create mapping s→t
                mapTS[c2] = c1;   // create mapping t→s
            }
            // If already mapped, check consistency
            else {
                if (mapST[c1] != c2 || mapTS[c2] != c1) {
                    return false;
                }
            }
        }
        return true;
    }
}
