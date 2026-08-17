class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int n2 = t.length();
        //   String ans = "";
        // Frequency map for string t
        int[] targetCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            targetCount[t.charAt(i)]++;
        }
        int minStart = 0;

        int remaining = n2;
        int end = 0;
        while (end < n && remaining > 0) {
            if (targetCount[s.charAt(end)] > 0) {
                remaining--;
            }
            
            targetCount[s.charAt(end++)]--;
        }
        int k = end;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        while (end <= n) {
           // char last = s.charAt(end);
           

           if (remaining > 0 && end < n) {
                char last = s.charAt(end);
                if (targetCount[last] > 0) remaining--; 
                targetCount[last]--;
                end++;
            } else if (remaining > 0) {
                break; // Break if we reached end of string but haven't found all chars
            }
            while (remaining == 0) {
                 char first = s.charAt(start);
                if (ans > end - start) {
                    ans = end - start;
                    minStart = start;
                }
                if (targetCount[first] >= 0)
                    remaining++;
                targetCount[first]++;
                // ans = Math.min(ans,end- start +1) ;
                start++;
               
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + ans);
    }
}
