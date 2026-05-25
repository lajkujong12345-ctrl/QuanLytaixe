package quanlytaixe;

import java.util.ArrayList;
import java.util.Scanner;

public class thongtin {

    public void hienthi() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<thongtin> danhsach = new ArrayList<>();
        System.out.println("---------------QUAN LY TAI XE------------------------");
        System.out.println("ID");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Ten");
        String Ten = sc.nextLine();

        System.out.println("Tuoi");
        int Tuoi = sc.nextInt();
        System.out.println("Boolean");
        boolean Gender = sc.nextBoolean();
        System.out.println("Xe");

        System.out.println("1. Motorbike");
        System.out.println("2. Car");

        System.out.println("Choose Type:");
        int choose = sc.nextInt();
        sc.nextLine();
        String Xe;
        if (choose == 1) {
            Xe = "Motorbike";

        }
        {
            Xe = "Car";
        }

        System.out.println("ID:" + ID + " / Ten:" + Ten + " / Tuoi:" + Tuoi + " / Gender:" + Gender + " / Xe:" + Xe);

        System.out.println("----------------DRIVER LIST----------------");

    }

}
