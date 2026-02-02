import java.util.*;

public class codeforce368 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        boolean pres[] = new boolean[26];
        boolean vis[] = new boolean[26];
        int indeg[] = new int[26];
        ArrayList<Integer> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(null);
        }
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.length() == 1) {
                pres[s.charAt(0) - 'a'] = true;
            } else {
                for (int j = 0; j < s.length() - 1; j++) {
                    char u = s.charAt(j);
                    char v = s.charAt(j + 1);
                    adj.set((u - 'a'), (v - 'a'));
                    indeg[v - 'a']++;
                    pres[u - 'a'] = true;
                    pres[v - 'a'] = true;
                }
            }
        }
        // System.out.println(adj);
        for (int i = 0; i < 26; i++) {
            if (pres[i] && !vis[i] && indeg[i]==0) {
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    System.out.print((char) (u + 'a'));
                    if (adj.get(u) != null) {
                        int v = adj.get(u);
                        if (!vis[v]) {
                            q.offer(v);
                            vis[v] = true;
                        }
                    }
                }
            }
        }

    }
}
