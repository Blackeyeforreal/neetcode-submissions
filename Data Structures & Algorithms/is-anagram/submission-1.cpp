class Solution {
public:
    bool isAnagram(string s, string t) {
        int arr[ 29]  ;
        int count = 0 ;
        for(int i= 0 ;i <29;i++) arr[i] = 0;
        int n = s.size(); int m = t.size();
        if ( s.size() != t.size()) return false ;
        for (int i = 0 ; i<n;i++){
            arr[s[i]-'a'] +=1 ;
            
        }
        for (int i = 0 ; i<m;i++) {
           if ( arr[t[i] -'a' ] ==0) return false ;
            arr[t[i] -'a' ]-=1; 
        }
        return true ;
    }
};
