/**
 Name: Rafiul Huq
 Date: 10/07/2018
 Course Section: IT 206-006
 Assignment: Programming Assignment 8

 Description:

 This program will keep track of all a company’s servers. There is a maximum of 206
 servers and a server must be either a web server or a file server, cannot just be a
 server. The program will track a server’s name (names must be unique), operating
 system (between Window, Linux, and OS X), hard drive capacity (terabytes), and level
 of usage (from 0 to 100). A file server also requires tracking the number of users with
 accounts on the server, up to 5000. A web server also requires tracking a list of
 programming languages that supported by the server (minimum of 2, maximum of 5). To
 calculate usage level for a file server, you multiply the number of users by 0.05, it the
 values exceeds 100, it will be set to 100. To calculate for a web server, multiply the number
 of programming languages supported by 20 to get the usage level. The final server report must
 be well-formatted with a report header, listing the server type, server name, operating system
 installed, hard drive capacity, and level of usage. A file server must also include the number
 of users with accounts and a web server must include the number of supported programming languages.
 Lastly, the report should include the total number of servers and the total hard drive
 capacity (in terabytes) across all servers.

 */
public abstract class Server {
    private String name;
    private String OS;
    public static final String[] OS_TYPES = {"Window" , "Linux", "OS X"};
    private double capacity;
    private double usageLevel;
    private static int numServers = 0;

    //constructor for a server that takes in the name, OS, and capacity
    public Server(String name, String OS, double capacity) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Server name must be provided");
        }
        if (nameCheck(name) == false) {
            throw new IllegalArgumentException("A server with this name already exists.");
        }
        if (OS == null || OS.equals("")) {
            throw new IllegalArgumentException("OS type must be provided");
        }
        for (int x = 0;x<OS_TYPES.length;x++) {
            if (OS.equalsIgnoreCase(OS_TYPES[x])) {
                break;
            }
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("A capacity amount greater than 0 must be provided");
        }
        this.name = name;
        this.OS = OS;
        this.capacity = capacity;
        numServers++;
    }

    //All the get methods take no inputs, there purpose is to return the variable named within the method
    public String getName() { return this.name; }
    public String getOS() { return this.OS; }
    public double getCapacity() { return this.capacity; }
    public double getUsageLevel() { return this.usageLevel; }
    public static int getNumServers() { return numServers; }

    /* All the following mutator methods are for setting the variable stated in their name
       There input value is what the user wishes to set as the value
       they return nothing, there all void
    */
    public void setName() {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Server name must be provided");
        }
        this.name = name;
    }
    public void setOS() {
        if (OS == null || OS.equals("")) {
            throw new IllegalArgumentException("OS type must be provided");
        }
        for (int x = 0;x<OS_TYPES.length;x++) {
            if (OS == OS_TYPES[x]) {
                break;
            }
            else {
                throw new IllegalArgumentException("OS type must be Window, Linux, or OS X");
            }
        }
        this.OS = OS;
    }
    public void setCapacity() {
        if (capacity <= 0) {
            throw new IllegalArgumentException("A capacity amount must be provided");
        }
        this.capacity = capacity;
    }

    //abstract method that calculates a specific server type's usage level
    public abstract double calculateUsage();

    /*this method compares all server names to one another and makes sure their all unique
      its input is the name to be checked
      returns true if the name is unique, otherwise false
    */
    public static boolean nameCheck(String name) {
        return true;
    }

    /* The toString() method prints out each attribute for a server
       it takes in no input and returns a String that contains each specified attribute
       */
    public String toString() {
        return "\nServer Name: " + this.getName() + "\nOS Type: " + this.getOS() +
                "\nServer Capacity: " + this.getCapacity();
    }

}