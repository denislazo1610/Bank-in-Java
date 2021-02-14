public class hello {
    public static void main(String[] args){
        String name = addExclamationPoint("Hell");
        System.out.println(name.toUpperCase());
        System.out.println(name);
        Animal perro = new Animal();
        String prueba = perro.iAmDog();
        System.out.println(prueba);
    }

    public static String addExclamationPoint(String s){
        return s + "!";
    }
}


