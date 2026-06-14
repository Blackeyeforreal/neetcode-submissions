class Solution {
public:

   string encode(vector<string>& strs) {
        string encoded = "";
        for (const string& s : strs) {
            // Append length, a delimiter, and the string itself
            encoded += to_string(s.size()) + "#" + s;
        }
        return encoded;
    }

    vector<string> decode(string s) {
        vector<string> result;
        int i = 0;
        while (i < s.size()) {
            // Find the position of the '#' delimiter
            int j = i;
            while (s[j] != '#') {
                j++;
            }
            
            // Extract the length of the string
            int length = stoi(s.substr(i, j - i));
            
            // Move 'i' past the '#' and add the actual string to result
            i = j + 1;
            result.push_back(s.substr(i, length));
            
            // Move 'i' to the start of the next length prefix
            i += length;
        }
        return result;
    }
};
