/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_4.BowlingShopApp;

import java.util.LinkedList;

// This class implements a basic queue structure using a LinkedList
public class GenericQueue<E> {
    // A LinkedList to store the elements of the queue
    private LinkedList<E> list = new LinkedList<E>();

    // method to add an item to the front of the queue
    public void enqueue(E item) {
        list.addFirst(item);
    }

    // method to remove and return the first item in queue
    public E dequeue() {
        return list.removeFirst();
    }

    // method to return the number of elements currently in the queue
    public int size() {
        return list.size();
    }
} // End GenericQueue