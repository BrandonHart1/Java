public class TestGreetings {
    
    public static void main(String[] args) {
        
    	// To use the greetings methods
    	// create a variable of type Greetings
    
        Greetings greeterApp = new Greetings();

    	// Use the variable to access Greetings methods
    	// using dot notation.
    
        String dateMessage = greeterApp.getCurrentDate();
        System.out.println(dateMessage);
    }
}
// We are instantiating a new Greetings object. Now, all public methods of the Greetings  class are available to that object.

// Calling the getCurrentDate() method on the object.

// Printing the currentDate string.