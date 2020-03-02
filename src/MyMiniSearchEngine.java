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
        /*Map<String, Integer> map = new HashMap<String, Integer>();
        // use i as index
        int i = 0;
        for(String text : texts){
            map.put(text, i);
            i++;
        }
        System.out.println(map);*/
        indexes = new HashMap<>();
        List<List<Integer>> count = new ArrayList<List<Integer>>();
        //List<Integer> num = new ArrayList<Integer>();
        int i = 0;
        for(String text : texts){
            String[] words = texts.get(i).split(" "); // "hello", "world"
            //List<Integer> num = new ArrayList<Integer>();
            for(int x = 0; x<words.length;x++){
                if(indexes.containsKey(words[x].toString())){

                }else{
                    List<Integer> num = new ArrayList<Integer>();
                    num.add(x);
                    count.add(num);
                    indexes.put(words[x].toString(),count);
                }
            }
            //indexes.put(Arrays.toString(words), count);
            i++;
        }
        System.out.println(indexes);
        System.out.println(indexes.get("hello"));
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        // goes through the map, use map.containKey(keyPhrase) to locate the value
        // return with map.get()

        return new ArrayList<>(); // place holder
    }
}
