class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
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
            courses.offer(i);
        }

        while(!courses.isEmpty()){
            int cur = courses.poll();

            for(Integer child : graph.get(cur)){
                indegree[child]--;
                if ( indegree[child] ==0 ){
                    courses.offer(child);
                }
            }

        }
         for(int i = 0 ;i <numCourses;i++){
            if ( indegree[i] !=0)
            return false ; 
        }
        return true ;
    }
}
