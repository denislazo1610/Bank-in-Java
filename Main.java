import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main (String[] args){
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
            //action
            cls();
            System.out.println("Create an account");
            optionA(accounts, dinero);
            option();

            char cambio;
            Scanner input = new Scanner(System.in);
            cambio =input.nextLine().charAt(0);
            choice = cambio;
            action(choice, accounts, dinero);

        }else if ((choice == 'b') || (choice == 'B')) {
            cls();
            System.out.println("Opening an account");
            optionB(accounts, dinero);
            option();

            char cambio;
            Scanner input = new Scanner(System.in);
            cambio =input.nextLine().charAt(0);
            choice = cambio;
            action(choice, accounts, dinero);

        }else if ((choice == 'c') || (choice == 'C')){
            cls();
            System.out.println("Exit, Thank You!");

        }
    }

    public static void optionA(HashMap <String, String> accounts, HashMap<String, Double> dinero){
        cls();
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
        cls();
    }

    public static void optionB(HashMap <String, String> accounts, HashMap<String, Double> dinero){
        cls();
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
            System.out.println("");
            System.out.println("Opening account....");
            openingAccount(cuenta, accounts, dinero);
        }else {
            System.out.println("Wrong password");
            System.out.println("Try again later");
        }

    }

    public static void openingAccount(String account,HashMap <String, String> accounts, HashMap<String, Double> dinero){
        cls();
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
            cls();
            System.out.println("Looking money");
            Double plata = dinero.get(account);
            System.out.println("This is how much you have: " + plata);
            System.out.println("Is this information correct? ");
            String answer;
            Scanner decidir = new Scanner(System.in);
            answer = decidir.nextLine();
            openingAccount(account, accounts, dinero);
        }else if(choice == 'B'){
            cls();
            System.out.println("What do you want to do? Deposit or retire money ?");
            String desicion;
            Scanner decidir = new Scanner(System.in);
            desicion = decidir.nextLine();

            if((desicion.equals("Deposit")) || (desicion.equals("deposit")) ){
                cls();
                System.out.println("How much are you going to deposit? ");
                double deposito;
                Scanner respuesta = new Scanner(System.in);
                deposito = respuesta.nextDouble();
                dinero.put(account, dinero.get(account) + deposito);

            }else if ((desicion.equals("Retire")) || (desicion.equals("retire"))){
                cls();
                System.out.println("How much are you going to retire? ");
                double retirar;
                Scanner respuesta = new Scanner(System.in);
                retirar = respuesta.nextDouble();
                dinero.put(account, dinero.get(account) - retirar);
            }

            openingAccount(account, accounts, dinero);
        }else if (choice == 'C'){
            cls();
            System.out.println("Changing unername");
            System.out.println("What do you want to replace your username? ");
            String answer;
            Scanner respuesta = new Scanner(System.in);
            answer = respuesta.nextLine();
            accounts.put(answer, accounts.get(account));
            dinero.put(answer, dinero.get(account));
            accounts.remove(account);
            dinero.remove(account);

            account = answer;

            openingAccount(account, accounts, dinero);
        } else if (choice == 'D'){
            cls();
            System.out.println("Changing password");
            System.out.println("What do you want to replace your password? ");

            String answer;
            Scanner respuesta = new Scanner(System.in);
            answer = respuesta.nextLine();

            accounts.put(account, answer);

            openingAccount(account, accounts, dinero);
        } else if (choice == 'E'){
            cls();
            System.out.println("Loging out from account...");
        } else {
            cls();
            System.out.println("Invalid input");
            openingAccount(account, accounts, dinero);
        }
        

    }

    public static void cls(){
        try
        {
            new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
        }catch(Exception E)
            {
                System.out.println(E);
            }
    }
}