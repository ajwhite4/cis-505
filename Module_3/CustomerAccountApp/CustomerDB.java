/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_3.CustomerAccountApp;

// This Java class contains pre-stored customer data
public class CustomerDB {
    // Accessor for customer data by customer id
    public static Customer getCustomer(int id) {
        if (id == 1007) {
            return new Customer("Patrick Mahomes", "123 Main Street", "Kansas City", "68110");
        } else if (id == 1008) {
            return new Customer("Dylan Raiola", "2415 Prodigy Way", "Lincoln", "68507");
        } else if (id == 1009) {
            return new Customer("Tom Brady", "1200 Goat Ave", "Tampa Bay", "33592");
        } else {
            // Default customer
            return new Customer();
        }
    }
} // End CustomerDB