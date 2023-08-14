/**
 @author 6360563
 @version Date: 1.0 July 23, 2023.
 Description: Program that uses Linked Lists, Queues, Iterators, Scanners, and Comparable to create a menu that allows
 the user to create a reservation for a restaurant, seat a reservation, change a reservation, cancel a reservation and list the reservations.
 */

package restaurant_final;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Iterator;
import java.time.LocalDateTime;

public class RestaurantSystem {

    Scanner scanner = new Scanner(System.in);

    /**
     * Description: Calls all the methods and creates the linked lists, and opens the menu that calls the rest of the methods.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RestaurantSystem res = new RestaurantSystem();
        res.menuOptions();
    }

    /**
     * Description: Method that asks for an input, calls the respective method that the user wants, and continues to loop.
     * Also creates a new Linked List and Queue. Makes sure to catch any Input Mismatch Exceptions in case the user puts a bad input.
     * @throws InputMismatchException for wrong inputs from the user
     */
    public void menuOptions() {

        int menuNum;
        LinkedList<Reservation> theLL = new LinkedList<>();
        Queue<Reservation> theQ = new LinkedList<>();

        do {
            try{
                //List the choices the user can choose from
                System.out.println("\n-------------------------------------------");
                System.out.println("1. Make a Reservation");
                System.out.println("2. Change a Reservation");
                System.out.println("3. Cancel a Reservation");
                System.out.println("4. List all of the Reservations");
                System.out.println("5. Seat a Reservation");
                System.out.println("6. Add a Walk-In");
                System.out.println("7. List all of the Walk-Ins");
                System.out.println("8. Seat a Walk-In");
                System.out.println("9. Exit");
                System.out.println("-------------------------------------------");
                System.out.println("Enter your choice: ");
                menuNum = scanner.nextInt();

                //Call the respective methods for these choices
                switch (menuNum) {
                    case 1 -> addReservation(theLL);
                    case 2 -> changeReservation(theLL);
                    case 3 -> cancelReservation(theLL);
                    case 4 -> listAllReservations(theLL);
                    case 5 -> seatAReservation(theLL);
                    case 6 -> addAWalkIn(theQ);
                    case 7 -> listAllWalkIns(theQ);
                    case 8 -> seatAWalkIn(theQ);
                    case 9 -> System.out.println("Thank your for using this service. Goodbye!");
                    default -> {
                        System.out.println("Enter a Valid Input.");
                        menuNum = 1;
                    }
                }
            }
            //Catch any exceptions from mis inputs
            catch(InputMismatchException ex){
                System.out.println("You entered an invalid response. Try again.");
                scanner.nextLine();
                menuNum = 1;
            }
        }
        //Keep looping until the user inputs "9"
        while(menuNum <= 8);
    }

    /**
     * Description: Creates a new reservation object with the users input and adds it to the Linked List.
     * @param theLL is the Linked List that holds the reservation objects
     * @throws InputMismatchException for wrong inputs from the user
     */
    public void addReservation(LinkedList<Reservation> theLL){
        int year, month, day, militaryHour, militaryMinute, partySize;
        String lastName, firstName;
        boolean error;

        do{
            try {
                //Ask for the booking information
                System.out.println("What year will you be booking for? : ");
                year = scanner.nextInt();
                System.out.println("What month will you be booking for? : ");
                month = scanner.nextInt();
                System.out.println("What day will you be booking for? : ");
                day = scanner.nextInt();
                System.out.println("What hour will you be booking for? : ");
                militaryHour = scanner.nextInt();
                System.out.println("What minute will you be booking for? : ");
                militaryMinute = scanner.nextInt();
                System.out.println("What is your last name? : ");
                lastName = scanner.next();
                System.out.println("What is your first name? : ");
                firstName = scanner.next();
                System.out.println("What is your party size? : ");
                partySize = scanner.nextInt();
                Reservation r = new Reservation(year, month, day, militaryHour, militaryMinute, lastName, firstName, partySize);
                theLL.addFirst(r);
                System.out.println("Your reservation was successfully added.");
                Collections.sort(theLL);
                error = false;
            }
            //Catch any bad inputs from user
            catch (InputMismatchException ex){
                System.out.println("Your reservation was not added successfully. Please enter a valid input.");
                error = true;
            }
        }
        //Keeps looping if there is an error
        while(error);
    }

    /**
     * Description: Changes the reservation objects party size by using the users input to find it in the Linked List.
     * @param theLL is the Linked List that holds the reservation objects
     * @throws InputMismatchException for wrong inputs from the user
     */
    public void changeReservation(LinkedList<Reservation> theLL){
        //Instantiate variables
        int year, month, day, militaryHour, militaryMinute, partySize;
        String lastName, firstName;
        int num = 0;

        do {
            try{
                //Ask user what they want to change
                System.out.println("\n-------------------------------------------");
                System.out.println("1. Change Date");
                System.out.println("2. Change Party Size");
                System.out.println("3. Exit");
                System.out.println("-------------------------------------------");
                System.out.println("Enter your choice: ");
                num = scanner.nextInt();
                
                if (num == 1){
                    boolean error = true;
                    //Ask for booking info
                    System.out.println("What year are you booked for? : ");
                    year = scanner.nextInt();
                    System.out.println("What month are you booked for? : ");
                    month = scanner.nextInt();
                    System.out.println("What day are you booked for? : ");
                    day = scanner.nextInt();
                    System.out.println("What hour are you booked for? : ");
                    militaryHour = scanner.nextInt();
                    System.out.println("What minute are you booked for? : ");
                    militaryMinute = scanner.nextInt();
                    System.out.println("What is your last name? : ");
                    lastName = scanner.next();
                    System.out.println("What is your first name? : ");
                    firstName = scanner.next();
                    System.out.println("What is your party size? : ");
                    partySize = scanner.nextInt();
                    Reservation r = new Reservation(year, month, day, militaryHour, militaryMinute, lastName, firstName, partySize);

                    //Sort through list to find they reservation
                    ListIterator<Reservation> it = theLL.listIterator();
                    while (it.hasNext()) {
                        Reservation res = it.next();
                        if (r.compareTo(res) == 0) {

                            //Ask for new booking information
                            System.out.println("What year will you be booking for? : ");
                            year = scanner.nextInt();
                            System.out.println("What month will you be booking for? : ");
                            month = scanner.nextInt();
                            System.out.println("What day will you be booking for? : ");
                            day = scanner.nextInt();
                            System.out.println("What hour will you be booking for? : ");
                            militaryHour = scanner.nextInt();
                            System.out.println("What minute will you be booking for? : ");
                            militaryMinute = scanner.nextInt();
                            Reservation newR = new Reservation(year, month, day, militaryHour, militaryMinute, res.getLastName(), res.getFirstName(), res.getPartySize());
                            it.set(newR);
                            System.out.println("Your reservation was changed successfully.");
                            error = false;
                            break;
                        }
                    }
                    //Output if the reservation was not found
                    if (error){
                        System.out.println("Your reservation could not be changed.");
                    }

                } else if (num == 2) {
                    boolean error = true;
                    System.out.println("What year are you booked for? : ");
                    year = scanner.nextInt();
                    System.out.println("What month are you booked for? : ");
                    month = scanner.nextInt();
                    System.out.println("What day are you booked for? : ");
                    day = scanner.nextInt();
                    System.out.println("What hour are you booked for? : ");
                    militaryHour = scanner.nextInt();
                    System.out.println("What minute are you booked for? : ");
                    militaryMinute = scanner.nextInt();
                    System.out.println("What is your last name? : ");
                    lastName = scanner.next();
                    System.out.println("What is your first name? : ");
                    firstName = scanner.next();
                    System.out.println("What is your party size? : ");
                    partySize = scanner.nextInt();
                    Reservation r = new Reservation(year, month, day, militaryHour, militaryMinute, lastName, firstName, partySize);

                    ListIterator<Reservation> it = theLL.listIterator();
                    while (it.hasNext()) {
                        Reservation res = it.next();
                        if (r.compareTo(res) == 0) {
                            System.out.println("What will your new party size be? : ");
                            partySize = scanner.nextInt();
                            res.setPartySize(partySize);
                            System.out.println("Your reservation was changed successfully.");
                            error = false;
                            break;
                        }
                    }
                    if (error){
                        System.out.println("Your reservation could not be changed.");
                    }
                }

                //Ends the loop
                else if (num == 3) {
                    System.out.println("Done!");
                    break;
                }

                else {
                    System.out.println("That is an invalid choice.");
                    num = 1;
                }

            }
            //Catches any exceptions from bad inputs
            catch (InputMismatchException ex){
                System.out.println("You entered an invalid response. Try again.");
                scanner.nextLine();
            }

        }
        //Keeps looping until user inputs "2"
        while(num <= 2);
    }

    /**
     * Description: Cancel a reservation object using the users input to find it in the Linked List.
     * @param theLL is the Linked List that holds the reservation objects
     * @throws InputMismatchException for wrong inputs from the user
     */
    public void cancelReservation(LinkedList<Reservation> theLL){
        //Instantiates variables
        boolean error = true;
        int year, month, day, militaryHour, militaryMinute, partySize;
        String lastName, firstName;
        do {
            try {
                //Ask for info
                System.out.println("What year are you booked for? : ");
                year = scanner.nextInt();
                System.out.println("What month are you booked for? : ");
                month = scanner.nextInt();
                System.out.println("What day are you booked for? : ");
                day = scanner.nextInt();
                System.out.println("What hour are you booked for? : ");
                militaryHour = scanner.nextInt();
                System.out.println("What minute are you booked for? : ");
                militaryMinute = scanner.nextInt();
                System.out.println("What is your last name? : ");
                lastName = scanner.next();
                System.out.println("What is your first name? : ");
                firstName = scanner.next();
                System.out.println("What is your party size? : ");
                partySize = scanner.nextInt();
                Reservation r = new Reservation(year, month, day, militaryHour, militaryMinute, lastName, firstName, partySize);

                //Iterates through list to find reservation
                ListIterator<Reservation> it = theLL.listIterator();
                while (it.hasNext()) {
                    Reservation res = it.next();
                    if (r.compareTo(res) == 0) {
                        it.remove();
                        System.out.println("Your reservation was cancelled successfully.");
                        error = false;
                        break;
                    }
                }
                if (error){
                    System.out.println("Your reservation could not be cancelled.");
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("You entered an invalid response. Try again.");
                scanner.nextLine();
            }
        }while (true);

    }

    /**
     * Description: Goes through the Linked List and prints out all the reservation objects.
     * @param theLL is the Linked List that holds the reservation objects
     */
    public void listAllReservations(LinkedList<Reservation> theLL){
        //Prints reservations
        for (Reservation reservation : theLL) {
            System.out.println(reservation);
        }
    }

    /**
     * Description: Removes a reservation object using the users input to find it in the Linked List and prints a message.
     * @param theLL is the Linked List that holds the reservation objects
     * @throws InputMismatchException for wrong inputs from the user
     */
    public void seatAReservation(LinkedList<Reservation> theLL){
        boolean error = true;
        int year, month, day, militaryHour, militaryMinute, partySize;
        String lastName, firstName;
        do {
            try {
                //Ask for info
                System.out.println("What year are you booked for? : ");
                year = scanner.nextInt();
                System.out.println("What month are you booked for? : ");
                month = scanner.nextInt();
                System.out.println("What day are you booked for? : ");
                day = scanner.nextInt();
                System.out.println("What hour are you booked for? : ");
                militaryHour = scanner.nextInt();
                System.out.println("What minute are you booked for? : ");
                militaryMinute = scanner.nextInt();
                System.out.println("What is your last name? : ");
                lastName = scanner.next();
                System.out.println("What is your first name? : ");
                firstName = scanner.next();
                System.out.println("What is your party size? : ");
                partySize = scanner.nextInt();
                Reservation r = new Reservation(year, month, day, militaryHour, militaryMinute, lastName, firstName, partySize);

                //Looks through linked list
                ListIterator<Reservation> it = theLL.listIterator();
                while (it.hasNext()) {
                    Reservation res = it.next();
                    if (r.compareTo(res) == 0) {
                        it.remove();
                        System.out.println("Please come this way to be seated.");
                        error = false;
                        break;
                    }
                }
                if (error){
                    System.out.println("Your reservation could not be found.");
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("You entered an invalid response. Try again.");
                scanner.nextLine();
            }
        }while (true);
    }

    /**
     * Description: Creates a new reservation object with the users input and adds it to the Queue.
     * @param theQ is the Queue that holds the reservation objects
     * @throws InputMismatchException for wrong inputs from the user
     */
    public void addAWalkIn(Queue<Reservation> theQ){
        int year, month, day, militaryHour, militaryMinute, partySize;
        String lastName, firstName;
        boolean error;

        do{
            try {
                // Get the current date and time
                LocalDateTime now = LocalDateTime.now();
                // Get the current year, month, day, hour, and minute
                year = now.getYear();
                month = now.getMonthValue();
                day = now.getDayOfMonth();
                militaryHour = now.getHour();
                militaryMinute = now.getMinute();
                //Asks for info
                System.out.println("What is your last name? : ");
                lastName = scanner.next();
                System.out.println("What is your first name? : ");
                firstName = scanner.next();
                System.out.println("What is your party size? : ");
                partySize = scanner.nextInt();
                Reservation r = new Reservation(year, month, day, militaryHour, militaryMinute, lastName, firstName, partySize);
                //Adds reservation to the queue
                theQ.add(r);
                System.out.println("Your reservation was successfully added.");
                error = false;
            }catch (InputMismatchException ex){
                System.out.println("Your reservation was not added successfully. Please enter a valid input.");
                scanner.nextLine();
                error = true;
            }
        }while(error);
    }

    /**
     * Description: Outputs the reservation objects in the Queue.
     * @param theQ is the Queue that holds the reservation objects
     */
    public void listAllWalkIns(Queue<Reservation> theQ){
        //Prints walk-ins
        for (Reservation res : theQ) {
            System.out.println(res);
        }
    }

    /**
     * Description: Removes the first reservation object from the Queue and prints a message.
     * @param theQ is the Queue that holds the reservation objects
     */
    public void seatAWalkIn(Queue<Reservation> theQ){
        //Iterates through queue
        Iterator<Reservation> it = theQ.iterator();
        if (it.hasNext()) {
            System.out.println(theQ.poll());
            System.out.println("Please come this way to be seated.");
        }
        //If queue is empty it sends that message
        else {
            System.out.println("There is no one in line.");
        }
    }

}