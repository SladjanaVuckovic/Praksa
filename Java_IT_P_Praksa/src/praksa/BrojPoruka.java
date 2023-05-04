package praksa;

import java.util.ArrayList;
import java.util.List;

public class BrojPoruka {
    public static void main(String[] args) {
    	
String metaData = FileHelper.loadMetaData(); 
List<Character> characters = new ArrayList<>();


String[] lines = metaData.split(System.lineSeparator());
for (int i = 1; i < lines.length; i++) { 
    String[] data = lines[i].split(", ");
    Character character = new Character(data[0], data[1], data[2]);
    characters.add(character);
}


for (Character character : characters) {
    int numMessages = character.getMessages().size();
    String message = character.getName() + " je poslao/la " + numMessages + " poruka.";
    System.out.println(message);
}
}}