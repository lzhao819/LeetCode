//use array to save color
class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colors = new int[size];			
		//color 0 for unvisited, 1 and -1 for two groups		
        for (int i = 0; i < size; i++) {
            //visited
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i);
            colors[i] = 1;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   
                        // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        
        return true;   
    }
}

//Hashmap version(slower)
class Solution {
    public boolean isBipartite(int[][] graph) {
        //contains all the node and the group it belongs to
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        for(int i=0; i<graph.length; i++){
            //BFS for all the unvisited node
            if(graph[i].length!=0 && !visited.containsKey(i)){
                //BFS for each node
                Queue<Integer> queue = new LinkedList<Integer>();
                //assign the current node to any group because it not been visited yet
                visited.put(i,0);
                queue.offer(i);
                while(!queue.isEmpty()){
                    int cur=queue.poll();
                    int curGroup=visited.get(cur);
                    for(int nei:graph[cur]){
                        if(!visited.containsKey(nei)){
                            //if the neighbor not be visited
                            //assign it to different color
                            int neiGroup= curGroup==0?1:0;
                            visited.put(nei,neiGroup);
                            queue.offer(nei);
                        }else if(visited.get(nei)==curGroup){
                            //if neiborcolor is same with the current color
                            return false;
                        }
                    }
                }
                
            }
            
        }//end of BFS
        return true;
    }
}