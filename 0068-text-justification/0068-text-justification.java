class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while(i < n){
            List<String> cur = getWords(i,words,maxWidth);
            i += cur.size();
            res.add(create(cur,i,words,maxWidth));
        }
        return res;
    }    
    private List<String> getWords(int i,String[] words,int max){
        List<String> curr = new ArrayList<>();
        int len = 0;
        int n = words.length;
        while(i < n && len + words[i].length() <= max){
            curr.add(words[i]);
            len += words[i].length() + 1;
            i++;
        }
        
        return curr;
    }
    
    private String create(List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for (String word: line) {
            baseLength += word.length() + 1;
        }

        int extraSpaces = maxWidth - baseLength;

        if (line.size() == 1 || i == words.length) {
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }

        int wordCount = line.size() - 1;
        int spacesPerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;

        for (int j = 0; j < needsExtraSpace; j++) {
            line.set(j, line.get(j) + " ");
        }

        for (int j = 0; j < wordCount; j++) {
            line.set(j, line.get(j) + " ".repeat(spacesPerWord));
        }

        return String.join(" ",  line);
    }
}