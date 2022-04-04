import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // I have tried absolutely everything here.
        return String.format("Good %s. Lovely to see you.", name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        return String.format("It is currently", new Date());
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis") > -1) {
            return "At your service. As you wish, naturally.";
        }

        if(conversation.indexOf("Alfred") > -1) {
            return "Right away, sir.  She certainly isn't sophisticated enought for that";
        }
        return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

