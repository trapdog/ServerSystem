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
public class FileServer extends Server {
    private int numUsers;
    public static final int MAX_NUM_USERS = 5000;
    public static final double USAGE_CALC = 0.05;

    //constructor for a file server that calls the contructor from server and includes the variable numUsers
    public FileServer(String name, String OS, double capacity, int numUsers) {
        super(name,OS,capacity);
        if (numUsers <= 0) {
            throw new IllegalArgumentException("A capacity amount must be provided");
        }
        this.numUsers = numUsers;
    }
    // This method returns the number of users and has no input
    public int getNumUsers() { return this.numUsers; }

    /* This method calculates the usage level of a web server
       it inputs nothing and returns the usage level
    */
    public double calculateUsage() {
        double total = 0;
        total = getNumUsers() * USAGE_CALC;
        if (total > 100) {
            total = 100;
        }
        return total;
    }

    /* The toString() method prints out each attribute for a server
       it takes in no input and returns a String that contains each specified attribute
       */
    public String toString() {
        String output = "File Server";
        output += super.toString();
        output += "\nUsage Level: " + this.calculateUsage() + "\nNumber of Users: " + this.getNumUsers();
        return output;
    }

}