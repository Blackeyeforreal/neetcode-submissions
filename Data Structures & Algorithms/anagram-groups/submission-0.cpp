class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int n = strs.size();
    vector<string> temp;  
    map<string ,vector<string>> ind ;  
    vector<vector<string>> ans ;
         for(int i = 0 ; i < n;i++){
            string s = strs[i]; 
            sort(s.begin(),s.end());
            if ( ind.contains(s)){
                ind[s].push_back(strs[i]);
            }
            else ind[s] = {strs[i]};
            
         }
         for (auto const& [key, val] : ind) {
    ans.push_back(val);
}
          return ans ;
    }
};
