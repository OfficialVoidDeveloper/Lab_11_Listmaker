import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> myArrayList = new ArrayList<>();
        String userResponse = "";
        int index = 0;
        String value = "";
        String divider = "=================";
        boolean finished = false;
        boolean quit = false;

        do {
            System.out.println("A - Add, D - Delete, P - Print, Q - Quit");
            userResponse = SafeInput.getRegExString(sc, "Enter a Command [ A | D | P | Q ]", "[AaDdPpQq]");

            if (userResponse.equalsIgnoreCase("A")){
                value = SafeInput.getNonZeroLenString(sc, "Enter a Value to add to the List");
                myArrayList.add(value);

            }else if (userResponse.equalsIgnoreCase("D")) {

                for (int i = 0; i < myArrayList.size(); i++){
                    System.out.println(i + " " + myArrayList.get(i));
                }
                System.out.println(divider);

                index = SafeInput.getRangedInt(sc, "Enter the index", 0, (myArrayList.size() - 1));
                value = myArrayList.get(index);
                myArrayList.remove(index);

                System.out.println(divider);
                for (int i = 0; i < myArrayList.size(); i++){
                    System.out.println(i + " " + myArrayList.get(i));
                }
                System.out.println("Removed: [Index: " + index + " | Value: " + value + "]");
                System.out.println(divider);

            }else if (userResponse.equalsIgnoreCase("P")){

                for (int i = 0; i < myArrayList.size(); i++){
                    System.out.println(i + " " + myArrayList.get(i));
                }

                System.out.println(divider);

            }else if (userResponse.equalsIgnoreCase("Q")){

                finished = SafeInput.getYNConfirm(sc, "Are you sure? [ Y | N ]");
                if (finished){
                    quit = true;
                }

            }else {
                quit = false;
            }

        }while(!quit);

    }
}
