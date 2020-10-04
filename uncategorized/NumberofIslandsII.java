//LeetCode 305. Number of Islands II
//A 2d grid map of m rows and n columns is initially filled with water. 
//We may perform an addLand operation which turns the water at position (row, col) into a land. 
//Given a list of positions to operate, count the number of islands after each addLand operation. 
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
//You may assume all four edges of the grid are all surrounded by water.
//time O()
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(positions==null || positions.length==0) return result;
        int count = 0;
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        //for checking neibor
        int[] rDelta = {1, -1, 0, 0};
        int[] cDelta = {0, 0, 1, -1};
        
        for(int[] position: positions){
            int r = position[0];
            int c = position[1];
            int index = r*n + c;
            //if the position is already put before, skip
            if(roots[index]!=-1){
                result.add(count);
                continue;
            }
            count++;
            roots[index] = index;
            //check neighbors
            for(int i=0;i<4;i++){
                int rnei = r + rDelta[i];
                int cnei = c + cDelta[i];
                if(maybeConnect(m,n,rnei,cnei,roots)){
                    int neiRoot = findRoot(roots, rnei*n +cnei);
                    //notice that root[rootNb] = root actually means parent not highest root. It's setting the new node to be the parent of the old neighbor. 
                    //UNION is only changing one parent to be the other, instead of changing all the nodes in the islands, so it's O(1). 
                    //The nodes in one island can have different root value, but same root[root[root[...]]] value
                    if( index!= neiRoot){
                        roots[neiRoot] = index;
                        count--;
                    }
                } 
            }
            result.add(count);
        }      
        return result;  
    }
    
    private boolean maybeConnect(int m, int n, int r, int c, int[] roots){
        if(r<0 || c<0 || r>=m || c>=n || roots[r*n+c]==-1){
            return false;
        }
        return true;    
    }
    
    private int findRoot(int[] roots, int index){
        //Using Path Compression
         while (index != roots[index]) {
            roots[index] = roots[roots[index]];
            index = roots[index];
        }
        return index;
    }
}