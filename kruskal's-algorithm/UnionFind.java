import java.util.HashMap;

public class UnionFind {
    HashMap<String, String> parent = new HashMap<String, String>();
    HashMap<String, Integer> rank = new HashMap<String, Integer>();

    public UnionFind(Graph graph){
        for (String s : graph.vertices){
            parent.put(s, s);
            rank.put(s, 0);
        }
    }

    public boolean isConnected(String u, String w){
        String p1 = u;
        while(!parent.get(u).equals(p1)){
            p1 = parent.get(u);
            u = p1;
        }
        String p2 = w;
        while(!parent.get(w).equals(p2)){
            p2 = parent.get(w);
            w = p2;
        }
        return p1.equals(p2);
    }

    public void union(String u, String w){
        if (rank.get(u) > rank.get(w)){
            parent.put(w, u);
        }else if (rank.get(u) < rank.get(w)){
            parent.put(u,w);
        }else
            parent.put(u,w);
            rank.put(w, rank.get(w)+1);
    }
}
