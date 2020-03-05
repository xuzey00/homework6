import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    class wordIndex{
        private int docNum;
        private ArrayList<Integer> loc;

        public List<Integer> wordIndex(int n){
            docNum = n;
            loc = new ArrayList<>();
            return loc;
        }
        public void AddLocation(int location){
            loc.add(location);
        }
        @Override
        public String toString(){
            return "{doc"+ docNum + ", location" + loc.toString() + "}";
        }
    }
    private Map<String, List<List<Integer>>> indexes;

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.
    private void index(List<String> texts) {
        //homework
        indexes = new HashMap<>();
        //List<List<Integer>> count = new ArrayList<List<Integer>>();
        int docNum = 0;
        for(String text : texts){
            String[] words = text.split(" "); //doc 0:"hello", "world"  doc 1:"hello"  doc 2:"world"  ...
            for(int x = 0; x<words.length; x++){
                String word = words[x].toLowerCase();
                if(!indexes.containsKey(word)){
                    indexes.put(word, new ArrayList<>());
                }else if(indexes.get(word).get(docNum) == null){
                    wordIndex index = new wordIndex();
                    indexes.get(word).add(index.wordIndex(docNum));
                }
                indexes.get(word).get(docNum).AddLocation(x);
            }
            docNum++;
        }
        System.out.println(indexes);
        //System.out.println(indexes.get("hello"));
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        // goes through the map, use map.containKey(keyPhrase) to locate the value
        // return with map.get()
        List<List<Integer>> result = new ArrayList<>();
        return new ArrayList<>(); // place holder
    }
}
