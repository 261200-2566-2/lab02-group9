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
//    AirPurifier(String brand,String model,String serial){
//        this.brand = brand;
//        this.model = model;
//        this.serial_number = serial;
//        fanMode = "OFF";
//        count++; // to count quantity of Air Purifier
//        calculateBrandsCount(brand);
//    }
    AirPurifier(String brand,String model,String serial ,boolean power,String fanMode,int fanSpeed,double PM) {
        this.brand = brand;
        this.model = model;
        this.serial_number = serial;
        this.power = power;
        this.fanMode = fanMode;
        this.fanSpeed = fanSpeed;
        this.PM = PM;
        count++; // to count quantity of Air Purifier
        calculateBrandsCount(brand);
    }
    //constructor with brand , model and serial number
//    AirPurifier(String model,String serial){
//        this("Hitachi",model,serial);
//        //set brand default with Hitachi
//    }
//    AirPurifier(String serial){
//        this("H1",serial);
//        //set model default with Hitachi model
//    }
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
        System.out.println("All Air Purifier quantity: " + count);
        System.out.println("---------------------------------------");
        System.out.println("Brand detail");
        System.out.println("---------------------------------------");
        while(brands[i] != null){
            System.out.println(brands[i].name + ": " + brands[i].count);
            i++;
        }
    }
    public void PrintDisplay(){
        System.out.println("---------------------------------------");
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Serial number: "+serial_number);
        System.out.println("---------------------------------------");
        String powerStatus = (power) ? "ON" : "OFF";
        System.out.println("Power Status: "+powerStatus);
        System.out.println("Fan Mode: "+ fanMode);
        System.out.println("Fan Speed(RPM): "+fanSpeed);
        System.out.println("PM: "+PM);
        ChangePm(PM);
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
            System.out.println("You enter wrong level!!!");
        }
    }
    public void ChangePm(double pm){
        PM = pm;
        if(PM >= 201){
            ChangeFanLevel(3);
            System.out.println("The PM value is at a high level !! , Change fan level mode to high.");
        }
        else if(PM < 200 && PM >=101){
            ChangeFanLevel(2);
            System.out.println("The PM value is at a medium level , Change fan level mode to medium.");
        }
        else if(PM < 100){
            ChangeFanLevel(1);
            System.out.println("The PM value is at a low level , Change fan level mode to low.");
        }
    }
    public void TurnOn(boolean pw){
        power = pw;
        if(power){
            System.out.println("---------------------------------------");
            System.out.println("Welcome to "+ brand +" Air Purifier");
            System.out.println("---------------------------------------");
            System.out.print("Change fan mode? (y/n) : ");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            if(answer.equals("y")){
                System.out.println("---------------------------------------");
                System.out.println("Choose fan mode");
                System.out.println("---------------------------------------");
                System.out.println("Low = 1");
                System.out.println("Medium = 2");
                System.out.println("High = 3");
                System.out.println("---------------------------------------");
                System.out.print("Enter fan level: ");
                int fanLV = sc.nextInt();
                ChangeFanLevel(fanLV);
            }else if(answer.equals("n")){
                ChangeFanLevel(1);
                //set default fan mode
            }
            System.out.println("---------------------------------------");
            System.out.print("Enter current PM: ");
            PM = sc.nextDouble();
            PrintDisplay();
        }else{
            ChangeFanLevel(0);
            PrintDisplay();
            //turn off fan
        }
    }
}

