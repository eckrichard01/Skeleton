package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * A lépéshez szükséges osztályok példányosítása
     * @return A virológus, akit léptetünk
     */
    public static Virologist moveInit(){
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        t2.SetNeighbor(t1);
        t1.SetNeighbor(t2);
        Bag bag = new Bag();
        Virologist virologist = new Virologist(t1,bag);
        return virologist;
    }

    /**
     * A tapogatáshoz szükséges osztályok példányosítása
     * @return A virológus, aki a tapogatást végzi
     */
    public static Virologist palpateInit(){
        ForgetAgent forgetAgent = new ForgetAgent();
        GeneticCode code = new GeneticCode(forgetAgent);
        Tile t1 = new Laboratory(code);
        Bag bag = new Bag();
        Virologist virologist = new Virologist(t1,bag);

        return virologist;
    }

    /**
     * A lejáró ágens példányosítása és elhelyezése a táskában
     * @return A lejáró ágens
     */
    private static Agent agenteInit() {
        ForgetAgent forgetAgent = new ForgetAgent();
        Bag bag = new Bag(forgetAgent);
        forgetAgent.setBag(bag);
        return forgetAgent;
    }

    /**
     * Egy ágens elkészítéséhez szükséges ágens és genetikai kód példányosítása
     * @return A genetikai kód, ami segítségével léterehozzuk az ágenst
     */
    private static GeneticCode createInit() {
        Agent agent = new  ParalyzeAgent();
        GeneticCode geneticCode = new GeneticCode(agent);
        return geneticCode;
    }

    /**
     * Egy virológus példányosítása, akinek van egy táskája, he mező nincs neki beállítva
     * @return A virológus, akit majd használunk
     */
    private static Virologist virologistInit() {
        Bag bag = new Bag();
        Virologist virologist = new Virologist(null, bag);
        return virologist;
    }

    /**
     * Egy anyag felvételéhez szükséges osztályok példányosítása
     * @return A virológus, aki majd végzi a tevékenységet
     */
    public static Virologist collectmInit(){
        Material material = new Material();
        List<Material> materials = new ArrayList<Material>();
        materials.add(material);
        Tile t1 = new Storage(materials);
        Bag bag = new Bag();
        Virologist virologist = new Virologist(t1,bag);

        return virologist;
    }

    /**
     * Egy védőfelszerelés felvételéhez szükséges osztályok példányosítása
     * @return A virológus, aki majd végzi a tevékenységet
     */
    public static Virologist collectpgInit(){
        ProtectiveGear protectiveGear = new Cape();
        Tile t1 = new Shelter(protectiveGear);
        Bag bag = new Bag();
        Virologist virologist = new Virologist(t1,bag);

        return virologist;
    }

    /**
     * A menü megvalósítására szolgáló függvény
     */
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
                String input3 = null;
                if(input2.equalsIgnoreCase("v")){
                    System.out.println("Van már ilyen védőfelszerelés a játékosnál? (I / N)");
                    input3 = in.nextLine();
                }
                System.out.println("Van elég hely a játékos készletében? (I / N)");
                String input4 = in.nextLine();
                /**
                 * Anyag, elég hellyel, földről
                 */
                if(input1.equalsIgnoreCase("f") && input2.equalsIgnoreCase("a") && input4.equalsIgnoreCase("i")){
                    virologist = collectmInit();
                    virologist.CollectMaterial(true);
                }
                /**
                 * Anyag, nincs elég helye, földről
                 */
                else if(input1.equalsIgnoreCase("f") && input2.equalsIgnoreCase("a") && input4.equalsIgnoreCase("n")) {
                    virologist = collectmInit();
                    virologist.CollectMaterial(false);
                }
                /**
                 * földröl, védőfelszerelés, van már ilyen felszerelése, van elég helye
                 */
                else if(input1.equalsIgnoreCase("f") && input2.equalsIgnoreCase("v") &&
                        input3.equalsIgnoreCase("i") && input4.equalsIgnoreCase("i")){
                    virologist = collectpgInit();
                    virologist.CollectProtectiveGear(true, true);
                }
                /**
                 * földröl, védőfelszerelés, nincs ilyen felszerelése, van elég helye
                 */
                else if(input1.equalsIgnoreCase("f") && input2.equalsIgnoreCase("v") &&
                        input3.equalsIgnoreCase("n") && input4.equalsIgnoreCase("i")){
                    virologist = collectpgInit();
                    virologist.CollectProtectiveGear(false, true);
                }
                /**
                 * földröl, védőfelszerelés, nincs elég helye
                 */
                else if(input1.equalsIgnoreCase("f") && input2.equalsIgnoreCase("v")
                        && input4.equalsIgnoreCase("n")){
                    virologist = collectpgInit();
                    virologist.CollectProtectiveGear(false, false);
                }
                break;
            case 4:
                System.out.println("Melyik ágenst szeretnéd használni: Vitustánc, Felejtős, Bénítás vagy Érinthetetlen? (V / F / B / E)");
                String input5 = in.nextLine();
                System.out.println("Magadon szeretnéd felhasználni? (I / N)");
                String input6 = in.nextLine();
                if(input6.equalsIgnoreCase("N")){
                    System.out.println("Akire felkened, rendelkezik bármilyen védőfelszereléssel? (I / N)");
                    String input7 = in.nextLine();
                    if(input7.equalsIgnoreCase("I")){
                        System.out.println("A védőfelszerelés az védőköpeny vagy kesztyű? (V / K)");
                        String input8 = in.nextLine();
                    }
                    if(input7.equalsIgnoreCase("n")){
                        System.out.println("Akire felkened, védett érintés ellen? (I / N)");
                        String input9 = in.nextLine();
                    }
                }
                break;
            case 5:
                System.out.println("Rendelkezel az ágens elkészítéséhez szükséges kellő mennyiségű anyaggal? (I / N)");
                GeneticCode geneticCode = createInit();
                virologist = virologistInit();
                String input10 = in.nextLine();
                if(input10.equalsIgnoreCase("i")) {
                    geneticCode.CreateAgent(virologist, true);
                }
                else if(input10.equalsIgnoreCase("n")) {
                    geneticCode.CreateAgent(virologist, false);
                }
                break;
            case 6:
                System.out.println("Az ágens, aminek az ideje épp lejár fel lett használva valakin? (I / N)");
                String input11 = in.nextLine();
                if(input11.equalsIgnoreCase("n")) {
                    Agent agent = agenteInit();
                    agent.Step();
                }
                else if(input11.equalsIgnoreCase("i")) {
                    Effects effects = new Paralyzed();
                    effects.Step();
                }
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
