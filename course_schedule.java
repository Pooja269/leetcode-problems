/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/
//DFS to find cycle..if there is cycle then return false else return true
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        if(prerequisites.length==0){
            return true;
        }
        List<List<Integer>> graph=new ArrayList<>(n);
        boolean[] visited=new boolean[n];
        boolean[] explored=new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
            visited[i]=false;
            explored[i]=false;
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            
            s.push(i);
            int u=-1;
            while(!s.empty()){
                    u=s.peek();
                    if(!visited[u])
                        visited[u]=true;
                    
                    else if(visited[u]==true || explored[u]==true){
                        s.pop();
                        explored[u]=true;
                        continue;
                    }
                    for(int j:graph.get(u)){
                       // System.out.println(j+"----"+visited[j]+"----"+explored[j]);
                        if(visited[j]==false){
                            //visited[j]=true;
                            s.push(j);
                        }
                        else if(explored[j]==false){
                            return false;
                        }
                        
                    }
                 }
        }
            return true;
    }
}
