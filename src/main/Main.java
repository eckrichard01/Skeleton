package main;

import java.util.Scanner;

public class Main {
    public static Virologist moveInit(){
        Tile t1 = new Simple();
        Tile t2 = new Simple();
        t2.SetNeighbor(t1);
        t1.SetNeighbor(t2);
        Bag bag = new Bag();
        Virologist virologist = new Virologist(t1,bag);
        return virologist;
    }
    public static Virologist palpateInit(){
        ForgetAgent forgetAgent = new ForgetAgent();
        GeneticCode code = new GeneticCode(forgetAgent);
        Tile t1 = new Laboratory(code);
        Bag bag = new Bag();
        Virologist virologist = new Virologist(t1,bag);

        return virologist;
    }

    public static void menu(){
        Virologist virologist = null;

        System.out.println("Kérlek válassz az alábbi forgatókönyvek közül:");
        System.out.println("1. Move 2. Palpate 3. Collect 4. Use agent 5. Make agent 6. Expiring");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        String input0 = in.nextLine();

        switch (input){
            case 1:
                virologist = moveInit();
                virologist.Move(0);
                break;
            case 2:
                virologist = palpateInit();
                virologist.PalpateWall();
                break;
            case 3:
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
                System.out.println("Rendelkezel az ágens elkészítéséhez szükséges kellő mennyiségű anyaggal? (I / N)");
                String input10 = in.nextLine();
                break;
            case 6:
                System.out.println("Az ágens, aminek az ideje épp lejár fel lett használva valakin? (I / N)");
                String input11 = in.nextLine();
                break;
        }
    }

    public static void main(String[] args) {
        int input12 = 0;
        Scanner in = new Scanner(System.in);
        while (input12 != 2){
            menu();
            System.out.println("1: folytatás, 2: exit");
            input12 = in.nextInt();
        }
        System.exit(0);
    }
}
