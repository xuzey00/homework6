import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
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
        List<List<Integer>> count = new ArrayList<List<Integer>>();
        //List<Integer> num = new ArrayList<Integer>();
        int i = 0;
        for(String text : texts){
            String[] words = texts.get(i).split(" "); //doc 0:"hello", "world"  doc 1:"hello"  doc 2:"world"
            List<Integer> num = new ArrayList<Integer>();
            List<Integer> doc = new ArrayList<Integer>();
            doc.add(i);
            for(int x = 0; x<words.length; x++){
                //List<Integer> num = new ArrayList<Integer>();
                if(indexes.containsKey(words[x].toString())){
                    //add to the same array list


                }else{
                    indexes.put(words[x].toString(),count);
                }
            }
            count.add(num);
            i++;
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
