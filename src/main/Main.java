package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Move 2. Palpate 3. Collect 4. Use agent 5. Make agent 6. Expiring");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        String input0 = in.nextLine();

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
                System.out.println("Melyik ágenst szeretnéd használni: Vitustánc, Felejtős, Bénítás vagy Érinthetetlen? (V / F / B / E)");
                String input5 = in.nextLine();
                System.out.println("Magadon szeretnéd felhasználni? (I / N)");
                String input6 = in.nextLine();
                if(input6.equals("N") || input6.equals("n")){
                    System.out.println("Akire felkened, rendelkezik bármilyen védőfelszereléssel? (I / N)");
                    String input7 = in.nextLine();
                    if(input7.equals("I") || input7.equals("i")){
                        System.out.println("A védőfelszerelés az védőköpeny vagy kesztyű? (V / K)");
                        String input8 = in.nextLine();
                    }
                    if(input7.equals("N") || input7.equals("n")){
                        System.out.println("Akire felkened, védett érintés ellen? (I / N)");
                        String input9 = in.nextLine();
                    }
                }
                break;
            case 5:
                System.out.println("Make agent");
                System.out.println("Rendelkezel az ágens elkészítéséhez szükséges kellő mennyiségű anyaggal? (I / N)");
                String input10 = in.nextLine();
                break;
            case 6:
                System.out.println("Expiring");
                System.out.println("Az ágens, aminek az ideje épp lejár fel lett használva valakin? (I / N)");
                String input11 = in.nextLine();
                break;
        }
        String input12 = in.nextLine();
    }
}
