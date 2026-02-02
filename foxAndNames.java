import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class foxAndNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        int indeg[] = new int[26];
        boolean inValid = false;
        for (int i = 0; i < n-1; i++) {
            String curr = str[i];
            String next = str[i+1];
            int x = 0;
            while (x<curr.length() && x<next.length()) {
                if (curr.charAt(x)!=next.charAt(x)) {
                    adj.get(curr.charAt(x)-'a').add(next.charAt(x)-'a');
                    indeg[next.charAt(x)-'a']++;
                    break;
                }
                x++;
            }
            if (x<curr.length() && x==next.length()) {
                inValid = true;
            }
        }
        // System.out.println(adj);
        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder res = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < 26; i++) {
            // System.out.print(indeg[i]+" ");
            if (indeg[i]==0) {
                q.offer(i);
                res.append((char)(i+'a'));
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : adj.get(u)) {
                indeg[v]--;
                if (indeg[v]==0) {
                    res.append((char)(v+'a'));
                    q.offer(v);
                }
            }
            count++;
        }
        if (inValid) {
            System.out.println("Impossible");
        }
        else if (count==26) {
         System.out.println(res);   
        }
        else {
            System.out.println("Impossible");
        }
    }
}
