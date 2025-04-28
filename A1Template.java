package Competitive_Coding.CodeForces;

import java.util.*;

public class A1Template {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = 1;
        t = in.nextInt();
        while (t-- > 0) solve();
        in.close();
    }

    static void solve() {
    }

    /* ------------------ ARRAY ALGORITHMS ------------------ */
    static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        return total;
    }

    static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) min = Math.min(min, num);
        return min;
    }

    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) max = Math.max(max, num);
        return max;
    }

    static int[] reverse(int[] arr) {
        int[] res = Arrays.copyOf(arr, arr.length);
        int i = 0, j = res.length - 1;
        while (i < j) {
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
        return res;
    }

    static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    static int[] prefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        if (arr.length == 0) return prefix;
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) prefix[i] = prefix[i - 1] + arr[i];
        return prefix;
    }

    static Map<Integer, Integer> frequencyMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        return map;
    }

    /* ------------------ GRAPH CLASS ------------------ */
    static class Graph {
        static Set<Integer>[] toUnweightedGraphUD(int n, int[][] edges) {
            Set<Integer>[] g = new HashSet[n];
            for (int i = 0; i < n; i++) g[i] = new HashSet<>();
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
            }
            return g;
        }

        static Set<Integer>[] toUnweightedGraphD(int n, int[][] edges) {
            Set<Integer>[] g = new HashSet[n];
            for (int i = 0; i < n; i++) g[i] = new HashSet<>();
            for (int[] e : edges) g[e[0]].add(e[1]);
            return g;
        }

        static Map<Integer, Integer>[] toWeightedGraphUD(int n, int[][] edges) {
            Map<Integer, Integer>[] g = new HashMap[n];
            for (int i = 0; i < n; i++) g[i] = new HashMap<>();
            for (int[] e : edges) {
                g[e[0]].put(e[1], e[2]);
                g[e[1]].put(e[0], e[2]);
            }
            return g;
        }

        static Map<Integer, Integer>[] toWeightedGraphD(int n, int[][] edges) {
            Map<Integer, Integer>[] g = new HashMap[n];
            for (int i = 0; i < n; i++) g[i] = new HashMap<>();
            for (int[] e : edges) g[e[0]].put(e[1], e[2]);
            return g;
        }

        static void dfsUnweighted(int u, Set<Integer>[] g, boolean[] vis) {
            vis[u] = true;
            for (int v : g[u]) if (!vis[v]) dfsUnweighted(v, g, vis);
        }

        static void bfsUnweighted(int src, Set<Integer>[] g, boolean[] vis) {
            Queue<Integer> q = new ArrayDeque<>();
            vis[src] = true;
            q.add(src);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u])
                    if (!vis[v]) {
                        vis[v] = true;
                        q.add(v);
                    }
            }
        }

        static void dfsWeighted(int u, Map<Integer, Integer>[] g, boolean[] vis) {
            vis[u] = true;
            for (int v : g[u].keySet()) if (!vis[v]) dfsWeighted(v, g, vis);
        }

        static void bfsWeighted(int src, Map<Integer, Integer>[] g, boolean[] vis) {
            Queue<Integer> q = new ArrayDeque<>();
            vis[src] = true;
            q.add(src);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u].keySet())
                    if (!vis[v]) {
                        vis[v] = true;
                        q.add(v);
                    }
            }
        }
    }

    /* ------------------ UTILS ------------------ */
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    static long powmod(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static int countDigits(int n) {
        if (n == 0) return 1;
        return (int) (Math.log10(n) + 1);
    }

    /*-----------------Pair Class-----------------*/
    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        public int compareTo(Pair o) {
            if (first != o.first) return Integer.compare(first, o.first);
            return Integer.compare(second, o.second);
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }
    }
}
