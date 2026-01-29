import java.util.*;
public class iceSkating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        HashSet<Integer> nx = new HashSet<>();
        HashSet<Integer> ny = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nx.add(x[i]);
        }
        for (int i = 0; i < n; i++) {
            ny.add(y[i]);
        }
        int min = Math.min(nx.size(), ny.size());
        System.out.println(min-1);
    }
}
