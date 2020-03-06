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
            return "{doc["+ docNum + "], location" + loc.toString() + "}"+"\n";
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
            //doc 0:"hello", "world"  doc 1:"hello"  doc 2:"world"  ...
            //split the text
            String[] words = text.split(" ");
            for(int x = 0; x<words.length; x++){
                List<wordIndex> docList;
                wordIndex numList;
                //set the word to lower case
                String word = words[x].toLowerCase();
                if(!indexes.containsKey(word)){
                    //if word is not in the map, create new list
                    docList = new ArrayList<>();
                    indexes.put(word, docList);
                }else{
                    //if already in map, get the word list
                    docList = indexes.get(word);
                }
                if (docList.isEmpty() || docList.get(docList.size()-1).getDocNum() != docNum) {
                    //word in a new document, add a new doc num list to the doc list
                    numList = new wordIndex(docNum);
                    docList.add(numList);
                }
                else {
                    //get the current doc num list from the end of the docList
                    numList = docList.get(docList.size() - 1);
                }
                //add the word to numList
                numList.AddLocation(x);
            }
            //go to next doc
            docNum++;
        }
        //System.out.println(indexes);
        //System.out.println(indexes.get("hello"));
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        // goes through the map, use map.containKey(keyPhrase) to locate the value
        // return with map.get()
        String[] keys = keyPhrase.split(" ");
        Map<Integer,List<Integer>> finalResult = new HashMap<>();
        List<wordIndex> result;
        ArrayList<Integer> location;
        for(int i = 0; i<keys.length;i++) {
            if (indexes.containsKey(keys[i])) {
                //if map contains key
                result = indexes.get(keys[i]);
                int num = result.get(i).getDocNum();
                location = result.get(i).getLocation();
                finalResult.put(num,location);
                System.out.println("key:["+keys[i]+"],result["+result+"]"+num + location);
            }
        }
        System.out.println(finalResult);
        // return empty list, no words being found
        return Collections.emptyList();
    }
}
