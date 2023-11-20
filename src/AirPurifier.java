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
    AirPurifier(String brand,String serial,String model,boolean power,String fanMode,int fanSpeed,double PM){
        this.brand = brand;
        this.model = model;
        this.serial_number = serial;
        this.power = power;
        this.fanMode = fanMode;
        this.fanSpeed = fanSpeed;
        this.PM = PM;
    }
    //constructor with brand , model and serial number
//    AirPurifier(String model,String serial){
//        this("HITACHI",model,serial);
//        //set brand default
//    }
//    AirPurifier(String serial){
//        this("X1",serial);
//        //set model default
//    }
    //constructor with no model
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
            fanMode = "Med";
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

