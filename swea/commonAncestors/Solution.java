package swea.commonAncestors;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int[] nodes;
    static int[][] edges;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/commonAncestors/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes = new int[V + 1];
            edges = new int[V + 1][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (nodes[c] == 0) {
                    nodes[c] = p;
                }
                if (edges[p][0] == 0) {
                    edges[p][0] = c;
                } else {
                    edges[p][1] = c;
                }
            }

            int commonParent = findParents(a, b);

            int size = getSize(commonParent, 0);
            System.out.println("#" + tc + " " + commonParent + " " + size);
        }

    }

    static int findParents(int a, int b) {
        int p, c = a;
        ArrayList<Integer> aParents = new ArrayList<>();
        ArrayList<Integer> bParents = new ArrayList<>();
        while (true) {
            p = nodes[c];
            if (p == 0) {
                break;
            }
            aParents.add(p);
            c = p;
        }
        c = b;
        while (true) {
            p = nodes[c];
            if (p == 0) {
                break;
            }
            bParents.add(p);
            c = p;
        }
        int parent = -1;
        if (aParents.size() > bParents.size()) {
            for (int i = 0; i < aParents.size(); i++) {
                for (int j = 0; j < bParents.size(); j++) {
                    if (aParents.get(i).intValue() == bParents.get(j).intValue()) {
                        parent = aParents.get(i).intValue();
                        return parent;
                    }
                }
            }
        } else {
            for (int i = 0; i < bParents.size(); i++) {
                for (int j = 0; j < aParents.size(); j++) {
                    if (aParents.get(j).intValue() == bParents.get(i).intValue()) {
                        parent = aParents.get(j).intValue();
                        return parent;
                    }
                }
            }
        }
        return parent;
    }

    static int getSize(int parent, int ans) {

        int a = 0;
        int b = 0;
        if (edges[parent][0] != 0) {
            a = getSize(edges[parent][0], ans);
        }
        if (edges[parent][1] != 0) {
            b = getSize(edges[parent][1], ans);
        }
        return a + b + 1;
    }
}
