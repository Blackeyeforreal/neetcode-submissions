class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0;
        int j = s.size() - 1;
        
        while (i < j) {
            // Move i forward if it's not alphanumeric
            if (!isalnum(s[i])) {
                i++;
            }
            // Move j backward if it's not alphanumeric
            else if (!isalnum(s[j])) {
                j--;
            }
            // Compare characters after converting to lowercase
            else {
                if (tolower(s[i]) != tolower(s[j])) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
};