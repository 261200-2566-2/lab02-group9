import java.util.Scanner;

public class AirPurifier {
    String brand;
    String serial_number;
    String model;
    int fanLevel;
     // 0/1/2/3
    int fanSpeed;
     // 0/800/1000/1500
    String fanMode;
     // OFF/Low/Med/High
    boolean power;
    double PM;
    static Brands [] brands = new Brands[20];
    static int count;
    AirPurifier(String brand,String model,String serial){
        this.brand = brand;
        this.model = model;
        this.serial_number = serial;
        fanMode = "OFF";
        count++; // to count quantity of Air Purifier
        calculateBrandsCount(brand);
    }
    //constructor with brand , model and serial number
    AirPurifier(String model,String serial){
        this("Hitachi",model,serial);
        //set brand default with Hitachi
    }
    AirPurifier(String serial){
        this("H1",serial);
        //set model default with Hitachi model
    }
    //constructor with no model

    public static void calculateBrandsCount(String brand){
            for(int i = 0;i<count;i++){
                if(brands[i] == null){
                    brands[i] = new Brands(brand);
                    break;
                }else if(brands[i].name.equals(brand)){
                    brands[i].count += 1;
                    break;

                }
            }
    }

    public static void PrintAllBrands(){
        int i = 0;
        System.out.println("---------------------------------------");
        System.out.println("All Air Purifier quantity: " + count + " unit");
        System.out.println("---------------------------------------");
        System.out.println("Brand detail");
        System.out.println("---------------------------------------");
        while(brands[i] != null){
            System.out.println(brands[i].name + ": " + brands[i].count + " unit");
            i++;
        }
    }
    public void PrintDisplay(){
        System.out.println("---------------------------------------");
        System.out.println("Detail");
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Serial number: "+serial_number);
        System.out.println("---------------------------------------");
        String powerStatus = (power) ? "ON" : "OFF";
        System.out.println("Power Status: "+powerStatus);
        System.out.println("Fan Mode: "+ fanMode);
        System.out.println("Fan Speed: "+fanSpeed + " RPM");
        System.out.println("PM: "+PM);
        System.out.println("---------------------------------------");
    }
    public void ChangeFanLevel(int fs){
        fanLevel = fs;
        if(fanLevel == 0){
            fanMode = "OFF";
            fanSpeed = 0;
            power = false;
        }else if(fanLevel == 1){
            fanMode = "Low";
            fanSpeed = 800;
        }else if(fanLevel == 2){
            fanMode = "Medium";
            fanSpeed = 1000;
        }else if(fanLevel == 3){
            fanMode = "High";
            fanSpeed = 1500;
        }else{
            System.out.println("You enter wrong level!!! please enter 0,1,2,3");
        }
    }
    public void ChangePm(double pm){
        PM = pm;
        if(PM >= 369.1){
            ChangeFanLevel(3);
            System.out.println("The PM value is at a very high level !! ,Auto change fan level mode to high.");
            System.out.println("We recommend that you should not change the fan level lower than this.");
        }
        else if(PM <= 369.1 && PM >= 200.1){
            ChangeFanLevel(3);
            System.out.println("The PM value is at a high level !! ,Auto change fan level mode to high.");
        }
        else if(PM < 200.1 && PM >=100.1){
            ChangeFanLevel(2);
            System.out.println("The PM value is at a medium level ,Auto change fan level mode to medium.");
        }
        else if(PM < 100.1 && PM >=0){
            ChangeFanLevel(1);
            System.out.println("The PM value is at a low level ,Auto Change fan level mode to low.");
        }else{
            System.out.println("unusual input");

        }
    }

    public void TurnOn(boolean pw){
        power = pw;
        if(power){
            System.out.println("---------------------------------------");
            System.out.println("Welcome to "+ brand +" Air Purifier");
            System.out.println("---------------------------------------");
            System.out.print("Enter current PM: ");
            Scanner sc = new Scanner(System.in);
            PM = sc.nextDouble();
            ChangePm(PM);
            if(PM < 0) return;
            System.out.print("You want to use fan mode with auto or manual? (a/m) : ");
            Scanner sc2 = new Scanner(System.in);
            String answer = sc2.nextLine();
                if(answer.equals("m") || answer.equals("M")){
                    System.out.println("---------------------------------------");
                    System.out.println("Change manual fan mode");
                    System.out.println("---------------------------------------");
                    System.out.println("Choose fan mode");
                    System.out.println("---------------------------------------");
                    System.out.println("Low = 1 ");
                    System.out.println("Medium = 2");
                    System.out.println("High = 3");
                    System.out.println("---------------------------------------");
                    System.out.print("Enter fan level: ");
                    int fanLV = sc.nextInt();
                    ChangeFanLevel(fanLV);
                    if(fanLV > 3) return;
                }else if(answer.equals("a") || answer.equals("A")){
                    System.out.println("---------------------------------------");
                    System.out.println("Use auto fan mode");
                    //set default fan mode
                }else{
                    System.out.println("Error!!! please Enter a/m");
                    return;
                }
            PrintDisplay();
        }else{
            ChangeFanLevel(0);
            PrintDisplay();
            //turn off fan
        }
    }
}

