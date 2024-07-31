class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // construct adjacency list
        // from: {to1, to2}...
        int[] ans = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // calculate indegree
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            indegree[to]++; // increase to's indegree, because to is depend on from
        }

        int index = 0;
        // topological sort with BFS: 
        // put all nodes with 0 indegree into queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
                ans[index] = i;
                index++;
            }
        }

        // BFS
        int count = 0;
        while(!q.isEmpty()){
            // current node
            int cur = q.poll();
            count++;
            // visit cur node neighbor
            for(int next : graph[cur]){
                // remove 1 indegree from next
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next); // means no dependency for next node
                    ans[index] = next;
                    index++;
                }
            }
        }

        if(count != numCourses){
            return new int[0];
        }
        return ans;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        // iterate prerequisites
        for(int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}