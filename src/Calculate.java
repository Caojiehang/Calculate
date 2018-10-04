import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jihang CAO
 * @// TODO: 2018/10/4
 * This ia a calculate class including CirlceArea method,weight method and timeAngle method
 */


public class Calculate  {
    public static  void main(String[] args) throws IOException {
        while(true) {
            hh();
        switch (check()) {
            case "1":
            for (double i = 0; i <= 10; i = i + 5) {
                System.out.println(areaCircle(i));
            }
            break;
            case "2":
            System.out.println(imperialToKG(0, 0, 0, 6, 0, 0, 0, 0));
            break;
            case "3":
                System.out.println("Please input hour:");
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                float hours = Float.valueOf(br1.readLine());
                System.out.println("please input minute:");
                float minutes =Float.valueOf(br1.readLine());
                System.out.println("please input seconds:");
                float seconds = Float.valueOf(br1.readLine());
                System.out.println("The time is "+(int)hours+":"+(int)minutes+":"+seconds);
                System.out.println("The angle is :"+
                        timeToAngle(hours,minutes,seconds));
                break;
            case"4":
                System.exit(1);
        }
    }
    }
    public static String check() {
        String ht = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             ht= br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ht;
    }
    public static double areaCircle(double radius) {
        double area = Math.PI * Math.pow(radius,2);
        return area;
    }
    public static String imperialToKG (double ton, double hw, double qt, double stone,
                                      double pound, double ou, double dra, double gr) {
        double t = 0.45359237;
        double pounds = 0;
        if(ton!=0) {
            pounds = 2240 * ton;
        } else if(hw !=0) {
            pounds = hw*122;
        }else if(qt !=0) {
            pounds =28*qt;
        }else if(stone !=0) {
            pounds= stone*14;
        }else if(pound != 0) {
            pounds = pound;
        } else if(ou != 0) {
            pounds= ou/16;
        }else if(dra !=0) {
            pounds = dra/256;
        }else if(gr != 0) {
            pounds = gr/7000;
        }
        ton = pounds/2240;
        hw =pounds/112;
        qt = pounds/28;
        stone = pounds/14;
        ou = 16*pounds;
        gr =7000*pounds;
        dra = 256*pounds;
        double kg = pounds*t;
        String list = ton+" ton"+"\n"+ hw+" hw"+"\n"+qt+" qt"+"\n"
                +stone+" stone"+"\n"+ou+" ou"+"\n"+dra+" dra"+"\n"+gr+" gr"
                +"\n"+kg+" kg";
        return list;
    }
    public static void hh() {
        System.out.println("please input your choice:" + "\n" + "1: caculate circle" + "\n" +
                "2: weight transfrom" +"\n"+"3: the time angle" +"\n"+
                "4: cancel");
    }
    public static float timeToAngle(float hours,float minutes,float seconds) {
        float angle = 0;
        if(hours>12){
            hours = hours-12;
        } else {
            hours = hours;
        }
        float hoursangle = hours*30;
        float minutesangle = minutes*6;
        float hourleft = (minutes/60)*30+(seconds/3600)*30;
        float minuteleft = (seconds/60)*5;
        if(hoursangle < minutesangle) {
            angle = 360-(minutesangle-hoursangle-hourleft+minuteleft);
        }else if(hoursangle > minutesangle) {
            angle = hoursangle-minutesangle+hourleft-minuteleft;
        }
        else if(hoursangle==minutesangle||hoursangle==minutesangle+360) {
          angle = minuteleft;
        }
        return angle;
    }
}

