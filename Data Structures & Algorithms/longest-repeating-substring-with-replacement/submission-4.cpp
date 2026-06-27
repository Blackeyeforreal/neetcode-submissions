class Solution {
public:
    bool isValid ( map<int,int>* ch ,int k){
        int ma = 0; 
        int su=0 ;
        for( auto [x,y] :* ch){
            ma= max( ma, y);
            su+=y ;
        }
        return (su-ma <=k);
    }

    int characterReplacement(string s, int k) {
        map<int , int > ch ; 
        int i = 0 ; 
        int j =1  ;
        ch[s[i]] =1 ;
        int ans = 0;
         if (!ch.contains( s[j])) ch[s[j]] =1 ;
            else ch[s[j]]+=1 ;
        while ( i< j ){
            

            if ( isValid (&ch, k)){
                ans = max( ans , j-i+1); 
            }else {
              
                ch[s[i]]--;   i++;
            }
            if ( j != s.length( )-1) {j++;
             if (!ch.contains( s[j])) ch[s[j]] =1 ;
            else ch[s[j]]+=1 ;
            }
            else {
             
             ch[s[i]]-=1 ;
            i++;
            }
            
        }
        return ans ;

    }
};
