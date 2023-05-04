package praksa;


	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class Main5 {
	    
	    private static final List<String> HAPPY_EMOJIS = Arrays.asList("😉", "😄", "☺", "😍");
	    private static final List<String> SAD_EMOJIS = Arrays.asList("😥", "😭", "😒", "👿");

	    public static void main(String[] args) {
	        String metaDataContent = FileHelper.loadMetaData();
	        List<Character> characters = parseMetaData(metaDataContent);
	        
	        Map<Character, Integer> happyScores = new HashMap<>();
	        Map<Character, Integer> sadScores = new HashMap<>();
	        
	        for (Character character : characters) {
	            List<String> messages = character.getMessages();
	            int happyCount = countEmojis(messages, HAPPY_EMOJIS);
	            int sadCount = countEmojis(messages, SAD_EMOJIS);

	            happyScores.put(character, happyCount);
	            sadScores.put(character, sadCount);
	        }

	        Character mostPositive = getExtremum(happyScores, true);
	        Character mostNegative = getExtremum(sadScores, false);

	        System.out.println("Najsrecnija osoba je: " + mostPositive.getName());
	        System.out.println("Najtuznija osoba je: " + mostNegative.getName());
	    }

	    private static List<Character> parseMetaData(String metaDataContent) {
	        List<Character> characters = new ArrayList<>();
	        String[] lines = metaDataContent.split(System.lineSeparator());
	        
	        for (int i = 1; i < lines.length; i++) {
	            String line = lines[i];
	            String[] parts = line.split(", ");
	            characters.add(new Character(parts[0], parts[1], parts[2]));
	        }

	        return characters;
	    }

	    private static int countEmojis(List<String> messages, List<String> emojis) {
	        int count = 0;
	        for (String message : messages) {
	            for (String emoji : emojis) {
	                count += message.split(emoji, -1).length - 1;
	            }
	        }
	        return count;
	    }

	    private static Character getExtremum(Map<Character, Integer> scores, boolean isPositive) {
	        if (isPositive) {
	            return scores.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
	        } else {
	            return scores.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
	        }
	    }
	}
	

	