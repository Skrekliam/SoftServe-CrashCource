import java.lang.*;
import java.util.Scanner;

class Calculator {
    public static float[] Arr;
    public static char[] smb = new char[16];
    public static int c;
    public static int step = 0;

    public static void calcul() {
        String smbS = String.valueOf(smb);
        int mult = smbS.indexOf('*');
        int div = smbS.indexOf('/');
        int min = smbS.indexOf('-');
        int plus = smbS.indexOf('+');
        int i = 0;
        while (step < 4) {

            switch (step) {
                case 0:
                    i = smbS.indexOf('*');
                    if (i < 0) {
                        step++;
                        continue;
                    } else {
                        Arr[i] = Arr[i] * Arr[i + 1];
                    }
                    break;
                case 1:
                    i = smbS.indexOf('/');
                    if (i < 0) {
                        step++;
                        continue;
                    } else {
                        Arr[i] = Arr[i] / Arr[i + 1];
                    }
                    break;
                case 2:
                    i = smbS.indexOf('+');
                    if (i < 0) {
                        step++;
                        continue;
                    } else {
                        Arr[i] = Arr[i] + Arr[i + 1];
                    }
                    break;
                case 3:
                    i = smbS.indexOf('-');
                    if (i < 0) {
                        step++;
                        continue;
                    } else {
                        Arr[i] = Arr[i] - Arr[i + 1];
                    }
                    break;

            }
            //  System.out.println(Arr[i] + " * " + Arr[i + 1] + " = " + Arr[i] * Arr[i + 1]);


            String s;
            s = smbS.substring(0, i);
            s += smbS.substring(i + 1, smbS.length() - i - 1);
            smbS = s;

            repl(i);
            for (int j = 0; j < Arr.length; j++) {
                System.out.print("rezult" + step + '\t' + Arr[j] + "\n");

            }
        }
    }

    public static void repl(int el) {
        for (int j = el + 1; j < Arr.length - 1; j++) {
            Arr[Arr.length - j - 1] = Arr[Arr.length - j];
            Arr[Arr.length - 1] = 0;
            System.out.println("moving array");
        }
    }

    public static int fun1(String str, int cnt) {
        int ind = 0;
        if (cnt == 0) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '=') {
                    cnt++;

                    ind = i + 1;
                }
            }
            Arr = new float[cnt];


            fun1(str, cnt);
        } else {
            //smb = new char[cnt-1];
            cnt = 0;
            c = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '=') {
                    if (str.charAt(i) != '=') {
                        c++;
                        smb[cnt] = str.charAt(i);
                    }
                    Arr[cnt] = Float.parseFloat(str.substring(ind, i));
                    cnt++;
                    ind = i + 1;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String str = myObj.nextLine();


        if (str.charAt(str.length() - 1) != '=') {
            str += '=';
        } else System.out.println("true");
        System.out.println(str);
        int cnt = 0;

        System.out.println(fun1(str, cnt));

        //     for (int i=0;i<Arr.length;i++){
        //          System.out.println(Arr[i]);
        //      }

        //      String smbS = String.valueOf(smb);
//      int mult = smbS.indexOf('*');
        //     int div = smbS.indexOf('/');
        //       int min = smbS.indexOf('-');
        //       int plus = smbS.indexOf('+');
        //       float resM = 0;

//        while (mult>=0) {
//
//        }
//        while (div>=0) {
//            System.out.println(Arr[mult] + " * " + Arr[mult + 1] + " = " + Arr[mult] * Arr[mult + 1]);
//            Arr[mult] = Arr[mult] * Arr[mult + 1];
//
//            String s;
//            s = smbS.substring(0, mult);
//            s += smbS.substring(mult + 1, smbS.length() - mult - 1);
//            smbS = s;
//
//            repl(div);
//
//            div = smbS.indexOf('/');
//        }
        calcul();
        System.out.println(Arr[0]);
//       for(int i =0;i<Arr.length;i++){
//           System.out.println(Arr[i]);
//
//       }
        //   System.out.println(smb[1]);

    }
}