class Solution {
public:
    bool isValid(string s) {
        
        stack<char> ch ; 

        for( char c : s ){
            if ( c == '{' || c == '['||c == '('  ) ch.push(c);
            else {
                if ( c =='}'){
                    if (  ch.size() ==0 ||ch.top() != '{'  )return false ;
                    else ch.pop();
                } 
                  if ( c ==']'){
                    if (  ch.size() ==0 ||ch.top() != '[' )return false ;
                    else ch.pop();
                } 
                  if ( c ==')'){
                    if (  ch.size() ==0 ||ch.top() != '(' )return false ;
                    else ch.pop();
                } 
            }
        }
        return !(ch.size()>0);
    }
};
