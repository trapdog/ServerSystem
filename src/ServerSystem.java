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
import javax.swing.JOptionPane;
public class ServerSystem {
    /* This method creates any constants and the array of servers needed. It also called the other methods
    it input is String[] args
    it returns nothing
    */
    public static void main(String[] args) {
        final int MAX_NUM_SERVERS = 206;
        Server[] servers = new Server[MAX_NUM_SERVERS];
        do {
            try {
                servers[Server.getNumServers()] = addServer();
            }
            catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Server could not be created\n" + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Add another server? ")
                == JOptionPane.YES_OPTION);
        double total = totalCapacity(servers);
        summaryReport(servers, total);
    }
    /* This method creates a server and asks for user input for all its attributes and the kind of server it is
    It has no input
    it returns a server object
    */
    public static Server addServer() {
        Server aServer = null;
        Object[] options = {"Web Server", "File Server"};
        switch (JOptionPane.showOptionDialog(null,
                "What type of server is being added?","A New Server",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null,options,options[0])) {

            case JOptionPane.YES_OPTION:
                aServer = new WebServer(JOptionPane.showInputDialog("Enter the servers name: "), JOptionPane.showInputDialog("Enter the OS type(Window, Linux, OS X): "),
                        Double.parseDouble(JOptionPane.showInputDialog("Enter the server's capacity: ")));
                do {
                    try {
                        ((WebServer)aServer).setLanguage(JOptionPane.showInputDialog("Enter a supported language: "));
                    }
                    catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Language could not be added.\n" + e.getMessage());
                    }
                } while (JOptionPane.showConfirmDialog(null, "Enter another language? ")
                        == JOptionPane.YES_OPTION);
                break;
            case JOptionPane.NO_OPTION:
                aServer = new FileServer(JOptionPane.showInputDialog("Enter the servers name: "), JOptionPane.showInputDialog("Enter the OS type: "),
                        Double.parseDouble(JOptionPane.showInputDialog("Enter the server's capacity: ")), Integer.parseInt(JOptionPane.showInputDialog("Enter the number of users for the server: ")));
                break;
            default:
                throw new RuntimeException("Error in server selection");
        }
        return aServer;
    }

    /* This method calculates the total capacity across all servers
    it inputs the array of servers from main
    it returns the total capacity
    */
    public static double totalCapacity(Server[] servers) {
        double total = 0;
        for (int x=0;x<Server.getNumServers();x++) {
            total += servers[x].getCapacity();
        }
        return total;
    }

    /* This method prints out the final report that details every server added and the total number of servers added and the total capacity overall
    it inputs the array of servers from main
    it returns nothing
    */
    public static void summaryReport(Server[] servers, double total) {
        String output = "***Server Report***\n\n";
        for (int x=0;x<Server.getNumServers();x++) {
            output += servers[x].toString() + "\n";
        }
        output += "\nNumber of Servers: " + Server.getNumServers() + "\nTotal capacity across all servers: " + total + " Terabytes";
        JOptionPane.showMessageDialog(null, output);
    }
}