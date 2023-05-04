package praksa;

import java.util.List;

public class Character {
    private String name;
    private String allegiance;
    private String messagesFileName;

    public Character(String name, String allegiance, String messagesFileName) {
        this.name = name;
        this.allegiance = allegiance;
        this.messagesFileName = messagesFileName;
    }

    public String getName() {
        return name;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public String getMessagesFileName() {
        return messagesFileName;
    }

    public List<String> getMessages() {
      return FileHelper.loadMessages(messagesFileName);
   }
}
