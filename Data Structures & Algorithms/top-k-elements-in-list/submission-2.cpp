class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        pair<int , int > iv; 
        map<int , int > count ; 
        for (int i = 0 ; i< nums.size() ; i++){
           if ( count.contains(nums[i]) )count[nums [i]]+=1;
           else count[nums[i]] = 1 ; 
        }
        priority_queue<pair<int, int>> pq;
        for ( auto const& [key, val ]: count){
            pq.push({val, key});
        }

        vector<int> ans ; 

        for (int i = 0 ;i <k;i++){
            ans.push_back(pq.top().second); pq.pop();
        }
        return ans ;
    }
};
