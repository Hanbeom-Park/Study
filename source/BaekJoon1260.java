import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon1260 {

  static boolean[] searchCheck;
  static boolean[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    String[] s = br.readLine().split(" ");
    int N =Integer.parseInt(s[0]);
    int M =Integer.parseInt(s[1]);
    int V =Integer.parseInt(s[2]);

    map=new boolean[N+1][N+1];

    for (int i = 0; i < M; i++) {
      String[] temp= br.readLine().split(" ");
      int x= Integer.parseInt(temp[0]);
      int y= Integer.parseInt(temp[1]);
      map[x][y]=true;
      map[y][x]=true;
    }

    //dfs
    searchCheck=new boolean[N+1];
    dfs(V,N);
    System.out.println();
    //bfs
    searchCheck=new boolean[N+1];
    Queue<Integer> queue=new LinkedList<>();

    queue.add(V);
    searchCheck[V]=true;

    while(!queue.isEmpty()){
      Integer vertex=queue.poll();
      System.out.print(vertex+" ");
      for (int i = 1; i <=N; i++) {
        if(vertex!=i&&map[vertex][i]&&!searchCheck[i]){
          searchCheck[i]=true;
          queue.add(i);
        }
      }
    }

  }

  private static void dfs(int vertex,int N) {
    searchCheck[vertex]=true;
    System.out.print(vertex+" ");

    for (int i = 1; i <=N ; i++) {
      if(vertex!=i&&map[vertex][i]&&!searchCheck[i]){
          dfs(i,N);
        }
    }
  }
}
