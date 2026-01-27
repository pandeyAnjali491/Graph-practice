import java.util.*;;
public class bakery {
    public static void main(String[] args) {
        // input
        int n , m, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int list[][] = new int[m][3];
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            list[i] = new int[]{x,y,w};
        }
        ArrayList<Integer> stores= new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            stores.add(x);
        }

        // logic
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<list.length;i++){
            int x=list[i][0];
            int y=list[i][1];
            int w=list[i][2];
            ArrayList<Integer> pair1 = new ArrayList<>();
            pair1.add(y);
            pair1.add(w);
            ArrayList<Integer> pair2 = new ArrayList<>();
            pair2.add(x);
            pair2.add(w);
            adj.get(x).add(pair1); 
            adj.get(y).add(pair2); 
        }
        // System.out.println(adj);
        // System.out.println(stores);
        int min = Integer.MAX_VALUE;
        for (int store : stores) {
            for (var city : adj.get(store)) {
                int ng = city.get(0);
                int w = city.get(1);
                if(!stores.contains(ng)) min = Math.min(min, w);
            }
        }
        System.out.println(min);

    }
}
