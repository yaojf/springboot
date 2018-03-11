package algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 构造最小生成树（Kruskal算法）--贪心算法
 *
 * @author Lican
 */
public class KrusKal {
    /**
     * 由连通分支组成的集合为U，包括union（a，b）；和find（v）的基本运算
     *
     * @author Administrator
     */
    public static class FastUnionFind {
        public int[] u;//数组用来保存顶点所属的集合，用数字表示

        public FastUnionFind(int n) {
            u = new int[n + 1];
            for (int i = 1; i <= n; i++) {//初始化，起初每个顶点所属的集合名称即相应的顶点数字
                u[i] = i;
            }
        }

        public int find(int x) {//找到顶点所属的集合
            return u[x];
        }

        public void union(int x, int y) {//将第二个点归入第一个点的集合（集合名字用数字表示）
            u[y] = u[x];
        }
    }

    /**
     * 边的类
     *
     * @author Administrator
     */
    public static class EdgeNode implements Comparable {
        float weight;//边的权重
        int u;//边的左顶点
        int v;//边的右顶点

        public EdgeNode(int uu, int vv, float ww) {
            u = uu;
            v = vv;
            weight = ww;
        }

        @Override
        public int compareTo(Object x) {//升序排序（从小到大），LinkedList的first就指向长度最短的边
            float xw = ((EdgeNode) x).weight;
            if (weight < xw) return -1;
            if (xw == weight) return 0;
            return 1;
        }
    }

    /**
     * Kruskal算法
     *
     * @param n 所有顶点的数目
     * @param E 边的集合（所有的边）
     * @param t 保存逐步连通的边
     * @return 是否生成了最小生成树
     */
    public static boolean kruskal(int n, LinkedList<EdgeNode> E, EdgeNode[] t) {
        FastUnionFind U = new FastUnionFind(n);
        int k = 0;
        while (k < n - 1) {//n个顶点，共n-1条边，因此k<n-1,即k:0,1,2,3....n-1
            EdgeNode x = E.peek();
            int a = U.find(x.u);//边的左顶点所属的集合
            int b = U.find(x.v);//边的右顶点所属的集合
            if (a != b) {
                t[k++] = x;
                U.union(a, b);
            }
            E.pop();
        }
        for (int i = 0; i < k; i++) {
            System.out.println("左顶点：" + t[i].u + "； 右顶点：" + t[i].v + "; 长度：" + t[i].weight);
        }
        return (k == n - 1);
    }

    public static void main(String[] args) {
        int n = 6;
        EdgeNode e1 = new EdgeNode(1, 2, 6);
        EdgeNode e2 = new EdgeNode(1, 3, 1);
        EdgeNode e3 = new EdgeNode(1, 4, 5);
        EdgeNode e4 = new EdgeNode(2, 3, 5);
        EdgeNode e5 = new EdgeNode(3, 4, 5);
        EdgeNode e6 = new EdgeNode(2, 5, 3);
        EdgeNode e7 = new EdgeNode(3, 5, 6);
        EdgeNode e8 = new EdgeNode(5, 6, 6);
        EdgeNode e9 = new EdgeNode(3, 6, 4);
        EdgeNode e10 = new EdgeNode(4, 6, 2);
        LinkedList<EdgeNode> E = new LinkedList<EdgeNode>();
        E.add(e10);
        E.add(e9);
        E.add(e8);
        E.add(e7);
        E.add(e6);
        E.add(e5);
        E.add(e4);
        E.add(e3);
        E.add(e2);
        E.add(e1);
        Collections.sort(E);
        EdgeNode[] t = new EdgeNode[n];
        kruskal(n, E, t);
    }
}
/**
 * 运行结果：
 * 左顶点：1； 右顶点：3; 长度：1.0
 * 左顶点：4； 右顶点：6; 长度：2.0
 * 左顶点：2； 右顶点：5; 长度：3.0
 * 左顶点：3； 右顶点：6; 长度：4.0
 * 左顶点：2； 右顶点：3; 长度：5.0
 */
