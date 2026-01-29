import java.util.*;

public class foxDot {

    public static boolean bfs(char mat[][],int sr,int sc,char ch,boolean vis[][],ArrayList<ArrayList<int[]>> par){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr,sc});
        vis[sr][sc] = true;
        while (!q.isEmpty()) {
            int node[] = q.poll();
            int u = node[0];
            int v = node[1];
            int dx[] = {0,0,-1,1};
            int dy[] = {-1,1,0,0};
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + u;
                int y = dy[i] + v;
                if (x>=0 && y>=0 && x<mat.length && y<mat[0].length) {
                    if (!vis[x][y] && mat[x][y]==ch) {
                        par.get(x).get(y)[0] = u;
                        par.get(x).get(y)[1] = v;
                        vis[x][y] = true;
                        q.offer(new int[]{x,y});
                    }
                    else if (vis[x][y] && mat[x][y]==ch && !(par.get(u).get(v)[0]==x && par.get(u).get(v)[1] ==y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char mat[][] = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int k = 0; k < c; k++) {
                mat[i][k] = s.charAt(k);
            }
        }
        boolean found = false;
        boolean vis[][] = new boolean[r][c];
        ArrayList<ArrayList<int[]>> par = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            ArrayList<int[]> row = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                row.add(new int[]{-1, -1});
            }
            par.add(row);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!vis[i][j]) {
                    char ch = mat[i][j];
                    par.get(i).get(j)[0] = i;
                    par.get(i).get(j)[1] = j;
                    if (bfs(mat,i,j, ch, vis,par)) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }
        if (found) {
            System.out.println("Yes");
        } else
            System.out.println("No");
    }
}