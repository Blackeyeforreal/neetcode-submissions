class Solution {
public:
    int maxArea(vector<int>& heights) {
        int n = heights.size();

            vector<pair<int,int>> arr ; 
        int ans =0; 
        arr.push_back({heights[0],0});
        int arrSize = 0 ; 
        for(int i =1;i<n;i++){
            if (  heights[i] - arr[arrSize].first >=  i - arr[arrSize].second  ){
                arr.push_back({heights[i],i});
            }   
            for( const auto & [ x,y] : arr){
                ans = max( ans , (i-y)* min(x , heights[i]));
            }

        }
        return ans ; 
        
    }
};
