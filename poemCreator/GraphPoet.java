package poemCreator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class GraphPoet {
    public ArrayList<String> poemParts = new ArrayList<String>();


    /**
     *
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */

    public GraphPoet(File corpus) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(corpus));
        ArrayList<String> sentences = new ArrayList<String>();
        String holder = reader.readLine();
        //put all lines of input into one arrayList
        for(int i = 0; holder != null; i++){
            sentences.add(holder);
            holder = reader.readLine();
        }
        reader.close();
        //combine arraylist elements to combine into one string
        String sentence = sentences.get(0);
        for(int i = 1; i< sentences.size();i++){
            sentence = sentence + " " + sentences.get(i);
        }
        //split big string into an array of each of its words
        String splits[] = sentence.toLowerCase().split(" ", 0);
        //make vertexes of each corpus word and maps of edges for each
        Vertex.wordToVert(splits);
        Vertex.makeMaps(splits);

        //Vertex.wordToVert(words);
       // Vertex.makeMaps(words);








        /* Read in the File and place into graph here */
    }

    /**
     * Generate a poem.
     *
     * @param input File from which to create the poem
     * @return poem (as described above)
     */
    public String poem(File input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        ArrayList<String> sentences = new ArrayList<String>();
        String hold = reader.readLine();

        //put all lines of input into one arrayList
        for(int i = 0; hold != null; i++){
            sentences.add(hold);
            hold = reader.readLine();
        }
        reader.close();
        //combine arraylist elements to combine into one string
        String sentence = sentences.get(0);
        for(int i = 1; i< sentences.size();i++){
            sentence = sentence + " " + sentences.get(i);
        }
        //split big string into an array of each of its words
        String splits[] = sentence.toLowerCase().split(" ", 0);
        sentences.clear();
        ArrayList<String> compPoem = new ArrayList<String>();
        //add bridge words to complete poem
        compPoem = Vertex.bridgeGaps(sentences, splits);
        String poem = new String("");
        //construct big Poem string from array of strings
        for(int i = 0; i < compPoem.size(); i++){
            if(i != compPoem.size()-1){
                poem = poem + compPoem.get(i) + " ";
            }
            else {
                poem = poem + compPoem.get(i);
            }
        }





        /* Read in input and use graph to complete poem */
        //String poem = "";
        return poem;
    }

}
