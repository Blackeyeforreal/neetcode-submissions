class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
           vector<int> pre,pos;
           vector<int > ans ; 
           int s= nums.size() -1 ; 
            pre.push_back(nums[0]);
            pos.push_back(nums[nums.size()-1]);
           for (int i = 1;i<nums.size();i++ ){
                pre.push_back(nums[i] * pre[i-1]); 

           }

            for (int i = nums.size()-2;i>=0 ;i--){
                pos.push_back(nums[i] * pos[pos.size() -1]); 

           }
           

           for(int i = 0 ; i < nums.size();i++){
            if ( i ==0 ) {ans.push_back( pos[s-1]);  continue;}
            if ( i ==s ) {ans.push_back( pre[i-1]);  continue;}
            ans.push_back(  pre[i-1 ] * pos[s -i -1 ]);
           }
           return ans ;
    }

};
