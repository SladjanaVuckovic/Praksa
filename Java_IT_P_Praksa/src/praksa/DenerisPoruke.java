package praksa;

import java.util.ArrayList;
import java.util.List;

public class DenerisPoruke {
	
	    public static void main(String[] args) {
	        
	        String metaData = FileHelper.loadMetaData();
	        
	      
	        String[] lines = metaData.split(System.lineSeparator());
	        List<Character> characters = new ArrayList<>();
	        for (String line : lines) {
	            String[] data = line.split(",");
	            Character character = new Character(data[0].trim(), data[1].trim(), data[2].trim());
	            characters.add(character);
	        }
	        
	     
	        Character daenerys = null;
	        for (Character character : characters) {
	            if (character.getName().equals("Daenerys Stormborn")) {
	                daenerys = character;
	                break;
	            }
	        }
	        
	        
	        List<String> messages = daenerys.getMessages();
	        for (String message : messages) {
	            System.out.println(message);
	        }
	       
	        Character daenerys1 = new Character("Daenerys Stormborn", "House Targaryen", "messages82387561293.txt");
	        Character jon = new Character("Jon Snow", "House Stark", "messages2094721612573.txt");
	        Character tyrion = new Character("Tyrion Lannister", "House Lannister", "messages9287658288370.txt");
	        Character cersei = new Character("Cersei Lannister", "House Lannister", "messages22274950573636.txt");

	        // Analyze each character's emoji usage
	        System.out.println(daenerys1.getName() + " is more " + EmojiAnalyzer.moreHappyOrSad(daenerys1));
	        System.out.println(jon.getName() + " is more " + EmojiAnalyzer.moreHappyOrSad(jon));
	        System.out.println(tyrion.getName() + " is more " + EmojiAnalyzer.moreHappyOrSad(tyrion));
	        System.out.println(cersei.getName() + " is more " + EmojiAnalyzer.moreHappyOrSad(cersei));
	    }

	    }

	
