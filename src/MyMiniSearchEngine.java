import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    class wordIndex{
        private int docNum;
        private ArrayList<Integer> loc;

        public wordIndex(int n){
            docNum = n;
            loc = new ArrayList<>();
        }
        public int getDocNum(){
            return docNum;
        }

        public void AddLocation(int location){
            loc.add(location);
        }

        public ArrayList<Integer> getLocation(){
            return loc;
        }

        @Override
        public String toString(){
            return "{doc"+ docNum + ", location" + loc.toString() + "}";
        }
    }
    private Map<String, List<wordIndex>> indexes;

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
        indexes = new HashMap<String, List<wordIndex>>();
        int docNum = 0;
        for(String text : texts){
            String[] words = text.split(" "); //doc 0:"hello", "world"  doc 1:"hello"  doc 2:"world"  ...
            for(int x = 0; x<words.length; x++){
                List<wordIndex> docList;
                wordIndex numList;
                String word = words[x].toLowerCase();
                if(!indexes.containsKey(word)){
                    docList = new ArrayList<>();
                    indexes.put(word, docList);
                }else if(indexes.get(word).get(docNum) == null){
                    docList = indexes.get(word);
                }
                if (docList.IsEmpty() || docList.get(docList.size()-1).getDocNum() != docNum) {
                    numList = new wordIndex(docNum);
                    docList.add(numList);
                }
                else {
                    numList = docList.get(docList.size() - 1);
                }

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
