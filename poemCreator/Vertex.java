package poemCreator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Vertex<T>{
    private T name;
    public static Object int0 = new Object();

    private Map<Vertex, Integer> edges = new HashMap<>();
    public static List<Vertex> vertexList = new ArrayList();
    Vertex(T name1){
        name = name1;
    }
//use readParts to iterate through original "poem"
//use editParts to place all proper words in, this is where complete poem will go
//transfer over to poem()
    public static ArrayList<String> bridgeGaps(ArrayList<String> editParts, String[] readParts){
        Vertex v0;
        Vertex v5;
        Vertex v6;
        int i = 0;
        int j = 0;
        boolean flag = true;

        while(i < readParts.length){
            if(getVert(readParts[i]) != null){
                v0 = getVert(readParts[i]);
                editParts.add(j, readParts[i]);
                j++;
                i++;
                if(v0.edgeHavedge(readParts[i]) != null){
                    v5 = v0.edgeHavedge(readParts[i]);
                    v6 = v0.hasEdge(readParts[i]);
                    editParts.add(j, (String) v5.name);
                    j++;
                    /*
                    editParts.add(j, readParts[i]);
                    j++;
                    i++;
                     */
                }
            }
            else {
                editParts.add(j, readParts[i]);
                i++;
                j++;
            }
            //checking to see if vertex does not have current word in it -> check for bridge words
           // if(hasVert)

            /*
            if(!Vertex.hasVert(readParts[j])){
                for(int p = 0; p < vertexList.get(k).edges.size();p++){
                    if(vertexList.get(k).edges.containsKey(readParts[j])){
                        maxVert = vertexList.get(k).checkBridge(readParts[j]);
                        editParts.set(i, vertexList.get(k).toString());
                        i++;
                        k++;

                    }
                }
            }
             */
        }
        return editParts;
    }


    public static void wordToVert(String[] words){
        for(int i = 0; i < words.length;i++){
            if(!hasVert(words[i])) {
                vertexList.add(new Vertex(words[i]));
            }
        }
    }

    public static boolean hasVert(String word){
        for(int i = 0; i < vertexList.size(); i++){
            if(vertexList.get(i).name.equals(word)){
                return true;
            }
        }
        return false;
    }
    public static Vertex getVert(String s){
        for(int i = 0; i < vertexList.size();i++){
            if(vertexList.get(i).name.equals(s)){
                return vertexList.get(i);
            }
        }
        return null;
    }

    public Vertex edgeHavedge(String nextWord){
        Integer topWeight = 0;
        Vertex weighted = new Vertex("topWeight");
        Vertex v3;
        for(Vertex v2: this.edges.keySet()){
            //checking if v2 has an edge matching word
            v3 = v2.hasEdge(nextWord);
            if(v3 != null){
                //check to see which bridge has highest weight
                if((Integer)v2.edges.get(v3) + (Integer)this.edges.get(v2) > topWeight){
                    topWeight = (Integer) v2.edges.get(v3) + this.edges.get(v2);
                    weighted = v2;
                }
            }
        }
        if(topWeight != 0){
            return weighted;
        }
        else {
            return null;
        }


    }
    public Vertex hasEdge(String nextWord){
        for(Vertex v1: this.edges.keySet()){
            if(v1.name.equals(nextWord)){
                return v1;
            }
        }
        return null;



    }

    public static void makeMaps(String[] words){
        for(int i = 0; i < words.length - 1; i++){
            if(getVert(words[i]).hasEdge(words[i+1]) == null) {
                getVert(words[i]).addEdge(getVert(words[i + 1]));
            }
            else {
                /*
                int0 = getVert(words[i]).edges.get(getVert(words[i+1]));
                if(int0.equals(1)){
                    int0 = 2;
                }
                else if(int0.equals(2)){
                    int0 = 3;
                }
                else if(int0.equals(3)){
                    int0 = 4;
                }
                 */
                Integer value = (Integer) getVert(words[i]).edges.get(getVert(words[i + 1]));
                getVert(words[i]).edges.replace(getVert(words[i+1]), ++value);

                //if(getVert(words[i]).edges.get(getVert(words[i+1])).equals(int0)
                //getVert(words[i]).edges.replace(getVert(words[i+1]), getVert(words[i]).edges.get(i+1)));

                //getVert(words[i]).edges.put
            }
        }
    }

    public void addEdge(Vertex edge){

        edges.put(edge, 1);
    }
/*
    public  Vertex checkBridge(String check){
        Integer maxEdge = 0;
        Vertex maxVertex = null;
        Set<Vertex> keys = edges.keySet();

        for(Vertex key: keys){
            if(key.equals(check)){
                if(maxEdge < edges.get(check)){
                    maxEdge = edges.get(check);
                    maxVertex = key;
                }

            }

        }
        return maxVertex;

    }
 */
}
