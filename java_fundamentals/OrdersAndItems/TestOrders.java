import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        System.out.println(" -------- Testing --------");

        // Menu items

        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 4.00;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 4.75;

        Item item3 = new Item();
        item3.name = "2.25";
        item3.price = 4.00;

        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 5.00;
        
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        System.out.println(order1.total);
        order1.name = "Cindhuri";

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";

        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item4);
        order3.total += item4.price;

        order4.items.add(item2);
        order4.total += item2.price;

        order1.ready = true;

        order2.items.add(item1);
        order2.total += item1.price;

        order4.items.add(item2);
        order4.total += item2.price;



    
        // Application Simulations
        // Use this example code to test various orders' updates
        
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);

        // -------- Add orders 2, 3, 4 --------
    }
}



// Add item1 to order2's item list and increment the order's total.

// order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.

// order4 added a latte. Update accordingly.

// Cindhuri’s order is now ready. Update her status.

// Sam ordered more drinks - 2 lattes. Update their order as well.

// Jimmy’s order is now ready. Update his status.

