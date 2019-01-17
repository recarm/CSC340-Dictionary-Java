package asmt01;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Table;
import java.util.Scanner;
/**
 *
 * @author green
 */
public class Asmt01 {

   public enum Words {
       ENTRY0("Adjective", "noun", "Adjective is a word that describes a person or thing, for example big, red \r\n"
					+ "and clever in a big house, red wine and a clever idea." ),
        ENTRY1("Book", "noun", "To arrange for someone to have a seat on a plane."),
        ENTRY2("Book", "noun", "To arrange something on a particular date."),
	ENTRY3("Bookable", "adjective", "Can be ordered in advance."),
	ENTRY4("Conjuction", "noun", "Conjunction is a word that joins words, phrases or sentences, for example \r\n"
					+ "\'and\', \'but\', \'or\'." ),
	ENTRY5("CSC440", "adjective", "C++ version of CSC210 + CSC220 + more. "),
        ENTRY6("CSC440", "noun", "A CS upper division course"),
        ENTRY7("CSC440", "noun","Many hours outside of class."),
        ENTRY8("CSC440", "noun", "Programming Methodology"),
        ENTRY9("CSC210", "adjective", "Comfortable with Objects and Classes."),
        ENTRY10("CSC210", "adjective", "Ready for CSC220."),
        ENTRY11("CSC210", "noun", "Intro to Java."),
        ENTRY12("CSC210", "verb", "To learn Java."),
	ENTRY13("CSC220", "adjective", "Ready to create complex data structures."),
        ENTRY14("CSC220", "noun", "Data Structures."),
        ENTRY15("CSC220", "verb", "To create data structures."),
        ENTRY16("Interjection", "noun", "Interjection is a short sound, word or phrase spoken suddenly to express \r\n"
					+ "an emotion. Oh!, Look out! and Ow! are interjections."),
	ENTRY17("Placeholder", "adjective", "To be updated..."),
        ENTRY18("Placeholder", "adjective", "To be updated..."),
        ENTRY19("Placeholder", "adverb", "To be updated..."),
        ENTRY20("Placeholder", "conjuction", "To be updated..."),
        ENTRY21("Placeholder", "interjection", "To be updated..."),
        ENTRY22("Placeholder", "noun", "To be updated..."),
        ENTRY23("Placeholder", "noun", "To be updated..."),
        ENTRY24("Placeholder", "noun", "To be updated..."),
        ENTRY25("Placeholder", "preposition", "To be updated..."),
        ENTRY26("Placeholder", "pronoun", "To be updated..."),
        ENTRY27("Placeholder", "verb", "To be updated..."),
        ENTRY28("Pronoun", "noun","The part of speech that substitutes for nouns or noun phrases and designates persons or things asked for, previously specified, or understood from the context."),
	ENTRY29("Pronoun", "noun", "Any of the words within this part of speech, such as he or whom." ),
	ENTRY30("Verb", "noun" , "Verb is a word or group of words that expresses an action (such as eat), an event \r\n"
					+ "(such as happen) or a state (such as exist)."),
        ENTRY31("Oops", " ", "<2nd argument must be a part of speech or 'distinct'>");
    
        
        private Words () {
    }
          private String key;
          private String partOfSpeech;
          private String definition;
          
        private Words (String key, String partOfSpeech, String definition) {
        this.key = key;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }
        public String getKey() {
            return key;
}
        public String getPartOfSpeech(){
          
           return partOfSpeech;
        }
                    
        public String getDefinition(){
            return definition;
        }
       
   @Override
   public String toString(){
   return this.key + " : " + this.partOfSpeech + " : " + this.definition;
   }
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("! Loading data...");
   Multimap<String, String> greenDictionary = ArrayListMultimap.create();
   SetMultimap<String, String> distinctDictionary = HashMultimap.create();
   Table<String, String, String> distinctTable = HashBasedTable.create();
   
    int i = 0;

    for (Words entry: Words.values()){
    greenDictionary.put(entry.getKey(), entry.getPartOfSpeech() + " : " + entry.getDefinition());
    distinctDictionary.put(entry.getKey(), entry.getPartOfSpeech() + " : " + entry.getDefinition());
    distinctTable.put(entry.getKey(),entry.getPartOfSpeech(), entry.getDefinition());
    }
    
        System.out.println("! Loading completed...");
        System.out.println("-----DICTIONARY 340 JAVA-----");
            Scanner sc=new Scanner(System.in);
           int num = 0;
        
        while(num < 100){
        System.out.print("Search: ");
        String Entry= sc.nextLine(); // scanner input        
                        
        if (Entry.equals("!q")){
        break;
        }
        Entry = Entry.toLowerCase();
        Entry = Entry.substring(0, 1).toUpperCase() + Entry.substring(1);
        
        String[] userInput = Entry.split(" ");
      if(greenDictionary.containsKey(userInput[0])){
            if(userInput.length==1){
            System.out.println("	| \n	" + Entry+ " : " + greenDictionary.get(Entry)+ "\n	| \n");
            
            }
            else if(userInput.length<=3){
             
                if (userInput[1].equals("distinct")){
                 System.out.println("	| \n	" + userInput[0] + ":" + distinctDictionary.get(userInput[0]) + "\n	| \n");
                 }
                
                if (userInput[1].equals("adjective") || userInput[1].equals("adverb") || userInput[1].equals("conjunction") || userInput[1].equals("interjection") || userInput[1].equals("noun") || userInput[1].equals("preposition") || userInput[1].equals("pronoun") || userInput[1].equals("verb"))
                    
                    System.out.println("	| \n	" + userInput[0] + ":" + "[" + userInput[1] + "] " + distinctTable.get(userInput[0], userInput[1]) + "\n	| \n");
                     }
                else{
                    continue;
                }}
     else{
            System.out.println("	| \n	" + "Not found." + "\n	| \n");
          }
                num++;
        }
        System.out.println("-----THANK YOU-----");
        }}