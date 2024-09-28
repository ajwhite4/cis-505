/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_5.ExpenseTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// This Java class defines the attributes of a product subclass bag
public class TransactionIO {
    // constant for file name where transaction is stored
    private static final String FILE_NAME = "expenses.txt";
    // file object where transaction files are stored
    private static File file = new File(FILE_NAME);

    // Static method to insert one or more transactions into file 
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        
        // if file exists, append the transactions, if not create new file
        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else {
            output = new PrintWriter(FILE_NAME);
        }

        // iterate through each transaction and write to file
        for (Transaction tran : transactions) {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }
        output.close();
    }

    // Static method to get all transactions from file and return as an arrayList
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        // create scanner to read file
        Scanner input = new Scanner(new File(FILE_NAME));

        // read each transaction in the file and add them to the transaction object
        while (input.hasNext()) {
            String date = input.next();
            String description = input.next();
            double amount = Double.parseDouble(input.next());
            transactions.add(new Transaction(date, description, amount));
        }
        // close scanner
        input.close();
        // return list of transactions from the file
        return transactions;
    }
} // End TransactionIO