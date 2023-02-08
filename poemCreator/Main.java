package poemCreator;

import java.io.File;
import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException {
            final GraphPoet nimoy = new GraphPoet(new File("/Users/teyoturrubiates/IdeaProjects/Project3/src/poemCreator/corpus.txt"));
            System.out.println(nimoy.poem(new File("/Users/teyoturrubiates/IdeaProjects/Project3/src/poemCreator/input.txt")));

            //final GraphPoet nimoy = new GraphPoet(new File("corpus.txt"));
            //System.out.println(nimoy.poem(new File("input.txt")));
        }
}
