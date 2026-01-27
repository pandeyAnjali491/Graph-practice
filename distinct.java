import java.util.*;
public class distinct {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<int[]>> res = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    bfs(i, j, grid, vis,res);
                }
            }
        }
        return res.size();
    }
    public void bfs(int i, int j, int[][] grid, boolean[][] vis,HashSet<ArrayList<int[]>> res){
        Queue<int[]> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        q.offer(new int[]{i, j});
        vis[i][j] = true;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        ArrayList<int[]> arr = new ArrayList<>(); 
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            arr.add(new int[]{x-i,y-j});
            for(int k=0;k<dx.length;k++){
                int nx = dx[k]+x;
                int ny = dy[k]+y;
                if(nx>=0 && nx<n && ny>=0 && ny<m && !vis[nx][ny] && grid[nx][ny]==1){
                    q.offer(new int[]{nx,ny});
                    vis[nx][ny] = true;
                }
            }
        }
        res.add(arr);
    }

}
