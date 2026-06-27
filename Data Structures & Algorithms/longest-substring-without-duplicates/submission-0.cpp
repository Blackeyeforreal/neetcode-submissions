#include <unordered_map>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Map to store the last seen index of each character
        unordered_map<char, int> lastSeen;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s[right];

            // If we've seen the character before AND it's within our current window
            if (lastSeen.find(currentChar) != lastSeen.end() && lastSeen[currentChar] >= left) {
                // Move the left pointer to the right of the last occurrence
                left = lastSeen[currentChar] + 1;
            }

            // Update the last seen position of the character
            lastSeen[currentChar] = right;

            // Calculate the current window length and update maxLength
            maxLength = max(maxLength, right - left + 1);
        }

        return maxLength;
    }
};