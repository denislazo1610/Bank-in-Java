import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        char choice;
        HashMap<String, String> accounts = new HashMap<String, String>();
        HashMap<String, Double> dinero = new HashMap<String, Double>();
        System.out.println("Welcome to the Bank!");

        option();
        Scanner input = new Scanner(System.in);
        choice =input.nextLine().charAt(0);
        action(choice, accounts, dinero);
    }

    public static void option(){
        System.out.println("");
        System.out.println("Choose one of the followings");
        System.out.println("A to create an acount");
        System.out.println("B to open an account");
        System.out.println("C to exit");
        System.out.println("");
    }

    public static void action(char choice, HashMap <String, String> accounts, HashMap<String, Double> dinero){        
        if ((choice == 'a') || (choice == 'A')) {

            System.out.println("Create an account");
            optionA(accounts, dinero);
            option();

            char cambio;
            Scanner input = new Scanner(System.in);
            cambio =input.nextLine().charAt(0);
            choice = cambio;
            action(choice, accounts, dinero);

        }else if ((choice == 'b') || (choice == 'B')) {
            System.out.println("Opening an account");
            optionB(accounts, dinero);
            option();

            char cambio;
            Scanner input = new Scanner(System.in);
            cambio =input.nextLine().charAt(0);
            choice = cambio;
            action(choice, accounts, dinero);

        }else if ((choice == 'c') || (choice == 'C')){
            System.out.println("Exit, Thank You!");


        }
    }

    public static void optionA(HashMap <String, String> accounts, HashMap<String, Double> dinero){
        System.out.println("You choose option A");
        String username;
        String password;
        double plata;
        System.out.println("What username you want to create?");
        Scanner usuario = new Scanner(System.in);
        username = usuario.nextLine();

        System.out.println("What is the password? ");
        Scanner contrasena = new Scanner(System.in);
        password = contrasena.nextLine();

        System.out.println("How much money are you going to put in that account? ");
        Scanner amount = new Scanner(System.in);
        plata = amount.nextDouble();
        accounts.put(username, password);
        dinero.put(username, plata);

        System.out.println("Option A is being selected");
    }

    public static void optionB(HashMap <String, String> accounts, HashMap<String, Double> dinero){
        System.out.println("Option B is being selected!");
        System.out.println("These are all the accounts");
        System.out.println("");
        
        for(String i : accounts.keySet()){
            System.out.println(i);
        }
        
        System.out.println("");

        System.out.println("Which one is your account? ");
        String cuenta;
        Scanner username = new Scanner(System.in);
        cuenta = username.nextLine();

        System.out.println("What is your password? ");
        String password;
        Scanner contrasena = new Scanner(System.in);
        password = contrasena.nextLine();
        
        System.out.println("");
        String comprobar = accounts.get(cuenta);
        System.out.println(comprobar);
        
        System.out.println("This is the password " + password);
        System.out.println("This is comprobar " + comprobar);

        if (password.equals(comprobar)){
            System.out.println("Opening account....");
            openingAccount(cuenta, accounts, dinero);
        }else {
            System.out.println("Wrong password");
            System.out.println("Try again later");
        }

    }

    public static void openingAccount(String account,HashMap <String, String> accounts, HashMap<String, Double> dinero){
        System.out.println("Welcome " + account);
        char choice;
        System.out.println("");
        System.out.println("Option A to see money");
        System.out.println("Option B to deposit/retire money");
        System.out.println("Option C to change username");
        System.out.println("Option D to change password");
        System.out.println("Option E to log out from accoutn");
        System.out.println("What do you want to see? ");
        System.out.println("");
        Scanner input = new Scanner(System.in);
        choice =input.nextLine().charAt(0);
        choice = Character.toUpperCase(choice);

        if (choice == 'A'){
            System.out.println("Looking money");
            Double plata = dinero.get(account);
            System.out.println("This is how much you have: " + plata);
            openingAccount(account, accounts, dinero);
        }else if(choice == 'B'){
            System.out.println("Depositing or retiring money");
            openingAccount(account, accounts, dinero);
        }else if (choice == 'C'){
            System.out.println("Changing unername");
            openingAccount(account, accounts, dinero);
        } else if (choice == 'D'){
            System.out.println("Changin password");
            openingAccount(account, accounts, dinero);
        } else if (choice == 'E'){
            System.out.println("Loging out from account...");
        } else {
            System.out.println("Invalid input");
            openingAccount(account, accounts, dinero);
        }
        

        // for (String i : dinero.keySet()){
            // System.out.println(i);
        // }
    }
}