class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {

        int i =0 ; int j = numbers.size()-1; 

        while ( i < j ){
            if ( target - numbers[i] > numbers[j]) i++;
            else if (target - numbers[i] < numbers[j] )j--;
            else return {i+1 , j+1};
        }
        return {0,0};
        
    }
};
