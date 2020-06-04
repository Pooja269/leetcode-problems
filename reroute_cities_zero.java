/*Reorder Routes to Make All Paths Lead to the City Zero

There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.
This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
It's guaranteed that each city can reach the city 0 after reorder.

Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 

Constraints:

2 <= n <= 5 * 10^4
connections.length == n-1
connections[i].length == 2
0 <= connections[i][0], connections[i][1] <= n-1
connections[i][0] != connections[i][1]
*/
/*class Solution {
    public int minReorder(int n, int[][] con) {
        List<List<Integer>> graph=new ArrayList<>(n+1);
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<con.length;i++){
            graph.get(con[i][0]).add(con[i][1]);
        }
        Queue<Integer> q=new LinkedList<>();
        int[] visited=new int[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                q.offer(i);
                
                while(!q.isEmpty()){
                    System.out.println(i);
                    int u=q.poll();
                    
                    for(int j:graph.get(u)){
                        if(visited[j]==0){
                          count++;
                          q.offer(j); 
                        }
                        
                    }
                    visited[u]=1;
                
                }
            }
        }
        
        return count;
    }
}*/
class Solution {
    public int minReorder(int n, int[][] connections) {
		//ajdacency list where int[] will be [dest,cost]
        List<int[]>[] cons = new List[n];
        for(int[] con : connections) {
            if (cons[con[0]] == null) cons[con[0]] = new ArrayList<int[]>();
            if (cons[con[1]] == null) cons[con[1]] = new ArrayList<int[]>();
            cons[con[0]].add(new int[]{con[1],1});//original direction, costs 1
            cons[con[1]].add(new int[]{con[0],0});//oposite directions, costs 0
        }
        return dfs(0,cons,new boolean[n]);
    }
    private int dfs(int curr, List<int[]>[] cons, boolean[] visited) {
        int cost = 0;
        visited[curr]=true;
        for(int[] neigh : cons[curr]) {
            if (!visited[neigh[0]]) {
                cost += neigh[1];
                cost += dfs(neigh[0],cons,visited);
            }
        }
        return cost;
    }
}
