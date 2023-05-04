package praksa;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiAnalyzer {
    private static final String HAPPY_REGEX = "😉|😄|😊|😍";
    private static final String SAD_REGEX = "😥|😭|😒|👿";

    public static int countHappyEmojis(String message) {
        return countEmojis(HAPPY_REGEX, message);
    }

    public static int countSadEmojis(String message) {
        return countEmojis(SAD_REGEX, message);
    }

    private static int countEmojis(String regex, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static String moreHappyOrSad(Character character) {
        List<String> messages = character.getMessages();
        int totalHappy = 0;
        int totalSad = 0;
        for (String message : messages) {
            totalHappy += countHappyEmojis(message);
            totalSad += countSadEmojis(message);
        }
        if (totalHappy > totalSad) {
            return "HAPPY";
        } else if (totalSad > totalHappy) {
            return "SAD";
        } else {
            return "NEUTRAL";
        }
    }
}



   