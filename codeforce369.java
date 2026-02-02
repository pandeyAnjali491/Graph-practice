import java.util.*;

public class codeforce369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int h = sc.nextInt();

        if (h > d || d > 2 * h || (n > 2 && h == 1 && d == 1)) {
            System.out.println(-1);
            return;
        }

        List<int[]> edges = new ArrayList<>();
        int curr = 2;

        int last = 1;
        for (int i = 0; i < h; i++) {
            edges.add(new int[]{last, curr});
            last = curr;
            curr++;
        }
        int safe = last-1;

        last = 1;
        for (int i = 0; i < d - h; i++) {
            edges.add(new int[]{last, curr});
            last = curr;
            curr++;
        }
        // push all extra node at safe node
        while (curr <= n) {
            edges.add(new int[]{safe, curr});
            curr++;
        }

        for (int[] e : edges) {
            System.out.println(e[0] + " " + e[1]);
        }
    }
}
