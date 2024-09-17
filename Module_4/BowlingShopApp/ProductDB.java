/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_4.BowlingShopApp;

// This Java class acts as a database storing product data
public class ProductDB {

    // Method to return a queue of Product objects based on the menu option (code)
    public static GenericQueue<Product> getProducts(String code) {
        // Check if the menu selection was "b" (balls)
        if (code.equalsIgnoreCase("b")) {
            // Create 5 ball instances
            Ball ball1 = new Ball();
            ball1.setCode("B500");
            ball1.setDescription("Phaze III");
            ball1.setPrice(154.99);
            ball1.setColor("Purple and Green");
            
            Ball ball2 = new Ball();
            ball2.setCode("B400");
            ball2.setDescription("Force Unleashed");
            ball2.setPrice(139.99);
            ball2.setColor("Red and White");
            
            Ball ball3 = new Ball();
            ball3.setCode("B300");
            ball3.setDescription("Proton Physix");
            ball3.setPrice(174.95);
            ball3.setColor("Pink and Purple");
            
            Ball ball4 = new Ball();
            ball4.setCode("B200");
            ball4.setDescription("Axiom Pearl");
            ball4.setPrice(154.95);
            ball4.setColor("Blue and Red");

            Ball ball5 = new Ball();
            ball5.setCode("B100");
            ball5.setDescription("Black Widow 2.0");
            ball5.setPrice(144.95);
            ball5.setColor("Black and Red");
            
            // Create a queue to store ball products
            GenericQueue<Product> balls = new GenericQueue<Product>();
            // Add all of the balls to the queue
            balls.enqueue(ball1);
            balls.enqueue(ball2);
            balls.enqueue(ball3);
            balls.enqueue(ball4);
            balls.enqueue(ball5);

            // Return the queue containing the ball products
            return balls;
        }
        // Check if the menu selection was "s" (shoes)
        else if (code.equalsIgnoreCase("s")) {
            // Create 5 shoe instances
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S500");
            shoe1.setDescription("Youth Skull Green/Black");
            shoe1.setPrice(39.99);
            shoe1.setSize(3.0);

            Shoe shoe2 = new Shoe();
            shoe2.setCode("S400");
            shoe2.setDescription("Men's Tribal White");
            shoe2.setPrice(26.99);
            shoe2.setSize(8.5);

            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Women's Path Lite Seamless Mesh");
            shoe3.setPrice(54.99);
            shoe3.setSize(6.0);

            Shoe shoe4 = new Shoe();
            shoe4.setCode("S200");
            shoe4.setDescription("Women's Rise Black/Hot Pink");
            shoe4.setPrice(39.99);
            shoe4.setSize(7.0);

            Shoe shoe5 = new Shoe();
            shoe5.setCode("S100");
            shoe5.setDescription("Men's Ram Black");
            shoe5.setPrice(39.99);
            shoe5.setSize(10.5);

            // Create a queue to store shoe products
            GenericQueue<Product> shoes = new GenericQueue<Product>();
            // Add all of the shoes to the queue
            shoes.enqueue(shoe1);
            shoes.enqueue(shoe2);
            shoes.enqueue(shoe3);
            shoes.enqueue(shoe4);
            shoes.enqueue(shoe5);

            // Return the queue containing the shoe products
            return shoes;
        }
        // Check if the menu selection was "a" (bags)
        else if (code.equalsIgnoreCase("a")) {
            // Create 3 bag instances
            Bag bag1 = new Bag();
            bag1.setCode("A300");
            bag1.setDescription("Silver/Royal Blue");
            bag1.setPrice(74.95);
            bag1.setType("Triple");

            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Prime Roller Black/Royal Blue");
            bag2.setPrice(54.99);
            bag2.setType("Double");

            Bag bag3 = new Bag();
            bag3.setCode("A100");
            bag3.setDescription("Path Pro Deluxe");
            bag3.setPrice(34.99);
            bag3.setType("Single");

            // Create a queue to store bag products
            GenericQueue<Product> bags = new GenericQueue<Product>();
            // Add all of the bag to the queue
            bags.enqueue(bag1);
            bags.enqueue(bag2);
            bags.enqueue(bag3);
        
            // Return the queue containing the bag products
            return bags;
        } 
        // Return an empty queue for any other menu selection
        else {
            return new GenericQueue<Product>();
        }
    }
} // End ProductDB