class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] ans = new int [numCourses];
        int index=0;
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int [numCourses +1];
        for ( int [] val : prerequisites){
            graph.get(val[1]).add(val[0]);
            indegree[val[0]]++; 
        }

        Queue<Integer> courses = new LinkedList<>();
        for(int i = 0 ;i <numCourses;i++){
            if ( indegree[i] ==0)
            {courses.offer(i); ans[index++] = i;}
        }

        while(!courses.isEmpty()){
            int cur = courses.poll();

            for(Integer child : graph.get(cur)){
                indegree[child]--;
                if ( indegree[child] ==0 ){
                    courses.offer(child);
                    ans[index++] = child;
                }
            }

        }
        if(index == numCourses){
            return ans;
        }else{
            return new int[]{};
        }
         
        // return ans ;
    }
    
}
