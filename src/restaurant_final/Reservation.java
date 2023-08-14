/**
 @author 6360563
 @version Date: 1.0 July 23, 2023.
 Description: Program that uses Linked Lists, Queues, Iterators, Scanners, and Comparable to create a menu that allows
 the user to create a reservation for a restaurant, seat a reservation, change a reservation, cancel a reservation and list the reservations.
 */

package restaurant_final;

/**
 * Description: Class the creates the Reservation objects, sorts the linked lists, returns the toString, and contains the getters and setters.
 */

public class Reservation implements Comparable<Reservation> {
    private int year;
    private int month;
    private int day;
    private int militaryHour;
    private int militaryMinute;
    private String lastName;
    private String firstName;
    private int partySize;

    /**
     Description: Constructor that creates the Reservation objects
     @param year is passed into the method as an Integer
     @param month is passed into the method as an Integer
     @param day is passed into the method as an Integer
     @param militaryHour is passed into the method as an Integer
     @param militaryMinute is passed into the method as an Integer
     @param lastName is passed into the method as a String
     @param firstName is passed into the method as a String
     @param partySize is passed into the method as an Integer
     */
    public Reservation(int year, int month, int day, int militaryHour, int militaryMinute, String
            lastName, String firstName, int partySize) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.militaryHour = militaryHour;
        this.militaryMinute = militaryMinute;
        this.lastName = lastName;
        this.firstName = firstName;
        this.partySize = partySize;
    }

    /**
     Description: getters used to retrieve the private instance variables
     @return Strings or Integers are returned depending on the one called
     */
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getMilitaryHour() {
        return militaryHour;
    }

    public int getMilitaryMinute() {
        return militaryMinute;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getPartySize() {
        return partySize;
    }

    /**
     Description: setters used to set new information into the private instance variables
     @param year is used for the one below, but it changes depending on the information that needs to be changed
     */
    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMilitaryHour(int militaryHour) {
        this.militaryHour = militaryHour;
    }

    public void setMilitaryMinute(int militaryMinute) {
        this.militaryMinute = militaryMinute;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    /**
     Description: toString which creates the template how the reservation objects will be sorted.
     @return A concatenation of written strings and variables that form part of the final output
     */
    @Override
    public String toString() {
        return "Reservation{" + "year=" + year + ", month=" + month + ", day=" + day + ", militaryHour="
                + militaryHour + ", militaryMinute=" + militaryMinute + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\'' + ", partySize=" + partySize + '}';
    }

    /**
     Description: Sorts the reservation linked list.
     @param otherReservation is the reservation object that is used in the comparison
     @return an integer used to sort the list by ascending order of reservation dates
     */
    @Override
    public int compareTo(Reservation otherReservation) {

        int retVal = 0;

        //Sorts by year
        if (this.year < otherReservation.year) {

            retVal = -1;

        } else if (this.year > otherReservation.year) {

            retVal = 1;

        } else {

            //Sorts by month
            if (this.month < otherReservation.month) {

                retVal = -1;

            } else if (this.month > otherReservation.month) {

                retVal = 1;

            } else {

                //Sorts by day
                if (this.day < otherReservation.day) {

                    retVal = -1;

                } else if (this.day > otherReservation.day) {

                    retVal = 1;

                } else {

                    //Sorts by hour
                    if (this.militaryHour < otherReservation.militaryHour) {

                        retVal = -1;

                    } else if (this.militaryHour > otherReservation.militaryHour) {

                        retVal = 1;

                    } else {

                        //Sorts by minute
                        if (this.militaryMinute < otherReservation.militaryMinute) {

                            retVal = -1;

                        } else if (this.militaryMinute > otherReservation.militaryMinute) {

                            retVal = 1;

                        } else {

                            //Sorts by last name
                            if (this.lastName.compareTo(otherReservation.lastName) < 0) {

                                retVal = -1;

                            } else if (this.lastName.compareTo(otherReservation.lastName) > 0) {

                                retVal = 1;

                            } else {

                                //Sorts by first name
                                if (this.firstName.compareTo(otherReservation.firstName) < 0) {

                                    retVal = -1;

                                } else if (this.firstName.compareTo(otherReservation.firstName) > 0) {

                                    retVal = 1;

                                }
                            }
                        }
                    }
                }
            }
        }

        return retVal;

    }
}


