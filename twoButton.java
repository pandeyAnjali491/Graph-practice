import java.util.*;

public class twoButton {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // bfs - not practically correct (infinite time)
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> vis = new HashSet<>();

        q.offer(m);
        vis.add(m);

        int lev = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();

                if (x == n) {
                    System.out.println(lev);
                    return;
                }

                int n1 = x / 2;
                int n2 = x + 1;

                if (n1 >= 0 && !vis.contains(n1)) {
                    vis.add(n1);
                    q.offer(n1);
                }

                if (n2 >= 0 && !vis.contains(n2)) {
                    vis.add(n2);
                    q.offer(n2);
                }
            }
            lev++;
        }
    }
}
