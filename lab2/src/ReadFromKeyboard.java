import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromKeyboard {

    private ArrayList<POJO> Users;

    ReadFromKeyboard(){
        Users = new ArrayList<POJO>();
    }
    private void help(){
        System.out.println("Accepted commands:\n" +
                "\t\thelp: Instructions on how to use the application\n" +
                "\t\tupdate: Update data. Can receive two parameters: username and sold.\n" +
                "\t\tdelete: Delete the user's data.  Receive the username.\n" +
                "\t\tquit: Close the application.");
    }

    private void create(String username, int sold){
        POJO newUser = new POJO(username, sold);
        Users.add(newUser);
    }

    private void update (String username, String newUsername, int newSold){
        for(POJO x : Users){
            if (x.username == username){
                x.username = newUsername;
                x.sold = newSold;
            }
        }
    }

    private void delete(String username){
        for(int i=0; i<Users.size(); i++){
            if (Users.get(i).username == username){
                Users.remove(i);
            }
        }
    }

    private void showUsers(){
        for(POJO x : Users)
            System.out.printf(x.username + " " + x.sold + "\n");
        System.out.println();
    }

    public static void main(String[] args){
        ReadFromKeyboard c = new ReadFromKeyboard();
        System.out.println(c.Users);
        c.create("Serban", 21);
        c.create("Ion", 21);
        c.showUsers();

        c.update("Serban", "Paul", 22);

        c.showUsers();

        c.delete("Ion");

        c.showUsers();

    }
}

class POJO{
    public String username;
    public int sold;

    POJO(String username, int sold){
        this.username = username;
        this.sold = sold;
    }
}


