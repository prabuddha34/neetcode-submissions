public class MinIdx_Segtree {
    int n;
    final int INF = (int) 1e9;
    int[] A, tree;

    public MinIdx_Segtree(int N, int[] heights) {
        this.n = N;
        this.A = heights;
        while (Integer.bitCount(n) != 1) {
            A = java.util.Arrays.copyOf(A, n + 1);
            A[n] = INF;
            n++;
        }
        tree = new int[2 * n];
        build();
    }

    public void build() {
        for (int i = 0; i < n; i++) {
            tree[n + i] = i;
        }
        for (int j = n - 1; j >= 1; j--) {
            int a = tree[j << 1];
            int b = tree[(j << 1) + 1];
            if (A[a] <= A[b]) {
                tree[j] = a;
            } else {
                tree[j] = b;
            }
        }
    }

    public void update(int i, int val) {
        A[i] = val;
        for (int j = (n + i) >> 1; j >= 1; j >>= 1) {
            int a = tree[j << 1];
            int b = tree[(j << 1) + 1];
            if (A[a] <= A[b]) {
                tree[j] = a;
            } else {
                tree[j] = b;
            }
        }
    }

    public int query(int ql, int qh) {
        return query(1, 0, n - 1, ql, qh);
    }

    public int query(int node, int l, int h, int ql, int qh) {
        if (ql > h || qh < l) return INF;
        if (l >= ql && h <= qh) return tree[node];
        int a = query(node << 1, l, (l + h) >> 1, ql, qh);
        int b = query((node << 1) + 1, ((l + h) >> 1) + 1, h, ql, qh);
        if (a == INF) return b;
        if (b == INF) return a;
        return A[a] <= A[b] ? a : b;
    }
}

public class Solution {
    public int getMaxArea(int[] heights, int l, int r, MinIdx_Segtree st) {
        if (l > r) return 0;
        if (l == r) return heights[l];

        int minIdx = st.query(l, r);
        return Math.max(Math.max(getMaxArea(heights, l, minIdx - 1, st),
                                getMaxArea(heights, minIdx + 1, r, st)),
                        (r - l + 1) * heights[minIdx]);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        MinIdx_Segtree st = new MinIdx_Segtree(n, heights);
        return getMaxArea(heights, 0, n - 1, st);
    }
}