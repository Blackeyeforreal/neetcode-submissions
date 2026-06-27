class Solution {
public:
    string minWindow(string s, string t) {
        // character frequences in the reference string (t)
        int ref[128] = {};

        for (char c : t) ++ref[c - 'A'];

        // frequencies in s
        int freq[128] = {};
        // where the window starts
        int l = 0;
        // how many characters from t we already collected
        int curr = 0;

        // result
        int minl = 0;
        int minlength = std::numeric_limits<int>::max();

        for (int r = 0; r < s.size(); ++r) {
            const char c = s[r] - 'A';
            ++freq[c];

            // if s[r] is a character that we needed -> we've found it -> increase curr
            if (freq[c] <= ref[c]) ++curr;

            // trim all the excessive characters from the left -
            // characters with current frequencies bigger than needed
            while (l <= r && freq[s[l] - 'A'] > ref[s[l] - 'A']) {
                --freq[s[l] - 'A'];
                ++l;
                // no need to decrement curr - as we only trim excessive 
                // characters - they are not counted in curr because of the 
                // (freq[c] <= ref[c]) condition above
            }

            // if we've found all required characters and the new answer is
            // shorter than the current one -> record it
            if (curr == t.size() && (r - l + 1) < minlength) {
                minl = l;
                minlength = r - l + 1;
            }
        }

        // minlength will be unchanged if there's no answer
        return minlength != std::numeric_limits<int>::max()
            ? s.substr(minl, minlength) : "";
    }
};