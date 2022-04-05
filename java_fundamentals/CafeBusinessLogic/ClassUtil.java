import java.util.ArrayList;
import java.util.Arrays;

public class ClassUtil {

    // System.out.println("Testing Streak")
    public int getStreakGoal() {
        int streak = 0;
        for (int i = 0; i <= 10; i++){
            streak += i;
        }
        return streak;
    };

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for(int i = 0; i < prices.length; i++){
            sum += prices[i];
        }
        System.out.println(sum);
        return sum;
    };

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0; i < menuItems.size(); i++){
            // System.out.println(i);
            System.out.println(i + " " + menuItems.get(i));
        }
    }
    
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello," + userName + "!");
        System.out.println("There are " + customers.size() + " people in front of you.");
        customers.add(userName);
    }

}
