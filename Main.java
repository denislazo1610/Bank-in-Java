import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        char choice;
        HashMap<String, String> accounts = new HashMap<String, String>();
        HashMap<String, Double> dinero = new HashMap<String, Double>();

        option();
        Scanner input = new Scanner(System.in);
        choice =input.nextLine().charAt(0);
        action(choice, accounts, dinero);
    }

    public static void option(){
        System.out.println("Welcome to the Bank!");
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
        System.out.println("Option A is being selected");
    }

    public static void optionB(HashMap <String, String> accounts, HashMap<String, Double> dinero){
        System.out.println("Option B is being selected!");
    }
}