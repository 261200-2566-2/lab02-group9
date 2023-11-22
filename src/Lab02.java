public class Lab02 {
    public static void main(String[] args) {
        //uncomment for test
        AirPurifier h1 = new AirPurifier("h233");
        AirPurifier h2 = new AirPurifier("EXTREME","h984");
        AirPurifier x1 = new AirPurifier("Xiaomi","PRO","x347");
        AirPurifier x2 = new AirPurifier("Xiaomi","Standard","x124");
        AirPurifier t1 = new AirPurifier("Tochiba","T2","t467");

        //for view All brands and all Air Purifier
        //AirPurifier.PrintAllBrands();

        //test 1(turn on/off h1)
        h1.TurnOn(true);
        //h1.TurnOn(false);
        //to Turn Off

        //test2 for view display when it's turn off
        //x2.TurnOn(false);
        //x2.ChangeFanLevel(0); //another way to turn off

        //test3 of to check brand name in index and count of that brand
        //System.out.println(AirPurifier.brands[0].name);
        //System.out.println(AirPurifier.brands[0].count);
        //System.out.println(AirPurifier.brands[1].name);
        //System.out.println(AirPurifier.brands[1].count);
        //System.out.println(AirPurifier.brands[2].name);
        //System.out.println(AirPurifier.brands[2].count);

    }
}
