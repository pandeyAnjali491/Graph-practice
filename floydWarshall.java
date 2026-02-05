public class floydWarshall {
    public void floydwarshall(int[][] dist) {
        // Code here
        int m = dist.length;
        for(int k=0;k<m;k++){
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    if(dist[i][k]==(int)1e8 || dist[k][j]==(int)1e8) continue;
                    dist[i][j] = Integer.min(dist[i][k]+dist[k][j],dist[i][j]);
                }
            }
        }
    }
}
