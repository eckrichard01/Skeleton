package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Move 2. Palpate 3. Collect 4. Use agent 5. Make agent 6. Expiring");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        switch (input){
            case 1:
                System.out.println("Move");
                break;
            case 2:
                System.out.println("Palpate");
                break;
            case 3:
                System.out.println("Collect");
                System.out.println("A földről vagy másik játékostól próbál felvenni valamit? (F / J)");
                String input0 = in.nextLine();
                String input1 = in.nextLine();
                System.out.println("Mit vesz fel a játékos, védőfelszerelést vagy valamilyen anyagot? (V / A)");
                String input2 = in.nextLine();
                if(input2.equals("V") || input2.equals("v")){
                    System.out.println("Van már ilyen védőfelszerelés a játékosnál? (I / N)");
                    String input3 = in.nextLine();
                }
                System.out.println("Van elég hely a játékos készletében? (I / N)");
                String input4 = in.nextLine();
                break;
            case 4:
                System.out.println("Use agent");
                break;
            case 5:
                System.out.println("Make agent");
                break;
            case 6:
                System.out.println("Expiring");
                break;
        }
    }
}
