class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 > n2) return false;
        
        vector<int> s1Freq(26, 0);
        vector<int> s2Freq(26, 0);
        
        // Build the frequency count for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            s1Freq[s1[i] - 'a']++;
            s2Freq[s2[i] - 'a']++;
        }
        
        // Slide the window
        for (int i = 0; i < n2 - n1; i++) {
            if (s1Freq == s2Freq) return true;
            
            // Move window: remove leftmost, add next character
            s2Freq[s2[i] - 'a']--;
            s2Freq[s2[i + n1] - 'a']++;
        }
        
        // Check the last window
        return s1Freq == s2Freq;
    }
};