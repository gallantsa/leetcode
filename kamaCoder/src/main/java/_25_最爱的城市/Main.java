package _25_最爱的城市;

import java.util.*;

// 多组测试数据，每组第⼀⾏为两个正整数n和m，接下来m⾏，每⾏3个整数, 最后⼀⾏两个整数
public class Main {
    static int[][] graph; // 用于存储图的邻接矩阵
    static int n, m; // n表示顶点的数量，m表示边的数量
    static final int INF = 1000000; // 用于表示无穷大，即两个顶点之间无法直接到达

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) { // 当还有输入时
            n = in.nextInt(); // 读取顶点的数量
            m = in.nextInt(); // 读取边的数量
            graph = new int[n + 1][n + 1]; // 初始化邻接矩阵
            for (int i = 1; i <= n; i++) { // 对邻接矩阵进行初始化
                Arrays.fill(graph[i], INF); // 将所有的边的长度都设置为无穷大
                graph[i][i] = 0; // 一个顶点到自身的距离为0
            }
            for (int i = 0; i < m; i++) { // 读取每一条边的信息
                int a = in.nextInt(); // 读取边的起点
                int b = in.nextInt(); // 读取边的终点
                int l = in.nextInt(); // 读取边的长度
                graph[a][b] = Math.min(graph[a][b], l); // 如果新的边的长度比原来的短，就更新
                graph[b][a] = Math.min(graph[b][a], l); // 因为是无向图，所以还要更新反向的边
            }
            floyd(); // 调用Floyd-Warshall算法
            int x = in.nextInt(); // 读取要查询的起点
            int y = in.nextInt(); // 读取要查询的终点
            if (graph[x][y] == INF) { // 如果两个顶点之间无法到达
                System.out.println("No path"); // 输出"No path"
            } else { // 否则
                System.out.println(graph[x][y]); // 输出两个顶点之间的最短距离
            }
        }
        in.close(); // 关闭输入流
    }

    public static void floyd() { // Floyd-Warshall算法的实现
        for (int k = 1; k <= n; k++) { // 对于每一个顶点
            for (int i = 1; i <= n; i++) { // 对于每一个起点
                for (int j = 1; j <= n; j++) { // 对于每一个终点
                    // 如果通过顶点k的路径比原来的路径短，就更新
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}