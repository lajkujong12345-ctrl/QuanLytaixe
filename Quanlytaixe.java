/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlytaixe;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Quanlytaixe {


    static int soLuongTaiXe = 0;
    
    
    static String[] maTaiXe = new String[50];
    static String[] tenTaiXe = new String[50];
    static String[] soDienThoai = new String[50];
    static String[] loaiXe = new String[50]; 
    static int[] toaDoX = new int[50];
    static int[] toaDoY = new int[50];
    static String[] trangThai = new String[50]; 

    static Scanner banPhim = new Scanner(System.in);

    public static void main(String[] args) {
        taoDuLieuMau();

        int luaChon;
        do {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ TÀI XẾ ---");
            System.out.println("1. Thêm tài xế mới");
            System.out.println("2. Cập nhật tọa độ và trạng thái");
            System.out.println("3. Xem danh sách tài xế");
            System.out.println("4. Tìm tài xế trống gần nhất");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn chức năng: ");
            
            luaChon = banPhim.nextInt();
            banPhim.nextLine(); 

            switch (luaChon) {
                case 1:
                    themTaiXe();
                    break;
                case 2:
                    capNhatTaiXe();
                    break;
                case 3:
                    xemDanhSach();
                    break;
                case 4:
                    timTaiXeGanNhat();
                    break;
                default:
                    break;
            }
            
        } while (luaChon != 0);
        
        System.out.println("Đã thoát chương trình!");
    }

    static void themTaiXe() {
        System.out.println("\n--- THÊM TÀI XẾ MỚI ---");
        System.out.print("Nhập mã tài xế: ");
        maTaiXe[soLuongTaiXe] = banPhim.nextLine();
        System.out.print("Nhập họ và tên: ");
        tenTaiXe[soLuongTaiXe] = banPhim.nextLine();
        System.out.print("Nhập số điện thoại: ");
        soDienThoai[soLuongTaiXe] = banPhim.nextLine();
        System.out.print("Nhập loại xe (Xe may/O to): ");
        loaiXe[soLuongTaiXe] = banPhim.nextLine();
        System.out.print("Nhập tọa độ X: ");
        toaDoX[soLuongTaiXe] = banPhim.nextInt();
        System.out.print("Nhập tọa độ Y: ");
        toaDoY[soLuongTaiXe] = banPhim.nextInt();
        banPhim.nextLine(); 
        System.out.print("Nhập trạng thái (AVAILABLE/BUSY/OFFLINE): ");
        trangThai[soLuongTaiXe] = banPhim.nextLine();
        soLuongTaiXe++; 
        System.out.println("Thêm tài xế thành công!");
    }

    static void capNhatTaiXe() {
        System.out.println("\n--- CẬP NHẬT TÀI XẾ ---");
        System.out.print("Nhập mã tài xế cần cập nhật: ");
        String ma = banPhim.nextLine();
        int viTriTimThay = -1;
        for (int i = 0; i < soLuongTaiXe; i++) {
            if (maTaiXe[i].equalsIgnoreCase(ma)) {
                viTriTimThay = i;
                break;
            }
        }
        if (viTriTimThay == -1) {
            System.out.println("Không tìm thấy tài xế này!");
        } else {
            System.out.print("Nhập tọa độ X mới: ");
            toaDoX[viTriTimThay] = banPhim.nextInt();
            System.out.print("Nhập tọa độ Y mới: ");
            toaDoY[viTriTimThay] = banPhim.nextInt();
            banPhim.nextLine(); 
            System.out.print("Nhập trạng thái mới (AVAILABLE/BUSY/OFFLINE): ");
            trangThai[viTriTimThay] = banPhim.nextLine();
            System.out.println("Cập nhật thông tin thành công!");
        }
    }

    static void xemDanhSach() {
        System.out.println("\n--- DANH SÁCH TÀI XẾ ---");
        for (int i = 0; i < soLuongTaiXe; i++) {
            System.out.println("Mã: " + maTaiXe[i] 
                    + " | Tên: " + tenTaiXe[i] 
                    + " | SĐT: " + soDienThoai[i] 
                    + " | Xe: " + loaiXe[i] 
                    + " | Vị trí: (" + toaDoX[i] + "," + toaDoY[i] + ")" 
                    + " | Trạng thái: " + trangThai[i]);
        }
    }

    static void timTaiXeGanNhat() {
        System.out.println("\n--- TÌM TÀI XẾ TRỐNG GẦN NHẤT ---");
        System.out.print("Nhập tọa độ X của khách hàng: ");
        int khachX = banPhim.nextInt();
        System.out.print("Nhập tọa độ Y của khách hàng: ");
        int khachY = banPhim.nextInt();
        banPhim.nextLine(); 

        int viTriGanNhat = -1;
        double khoangCachNhoNhat = 999999.0; 

        for (int i = 0; i < soLuongTaiXe; i++) {
            if (trangThai[i].equalsIgnoreCase("AVAILABLE")) {
                double kc = Math.sqrt(Math.pow(toaDoX[i] - khachX, 2) + Math.pow(toaDoY[i] - khachY, 2));
                if (kc < khoangCachNhoNhat) {
                    khoangCachNhoNhat = kc;
                    viTriGanNhat = i;
                }
            }
        }

        if (viTriGanNhat == -1) {
            System.out.println("Hiện tại không có tài xế nào rảnh (AVAILABLE)!");
        } else {
            System.out.println(">> Đã tìm thấy tài xế rảnh gần nhất:");
            System.out.println("Mã: " + maTaiXe[viTriGanNhat]);
            System.out.println("Tên: " + tenTaiXe[viTriGanNhat]);
            System.out.println("Vị trí: (" + toaDoX[viTriGanNhat] + "," + toaDoY[viTriGanNhat] + ")");
            System.out.printf("Khoảng cách đến khách: %.2f\n", khoangCachNhoNhat);
        }
    }

    static void taoDuLieuMau() {
        maTaiXe[0] = "TX01"; tenTaiXe[0] = "Nguyen Van Dat"; soDienThoai[0] = "0911"; loaiXe[0] = "Xe may"; toaDoX[0] = 2;  toaDoY[0] = 3;  trangThai[0] = "AVAILABLE";
        maTaiXe[1] = "TX02"; tenTaiXe[1] = "Tran Thi Yen";   soDienThoai[1] = "0922"; loaiXe[1] = "O to";   toaDoX[1] = 10; toaDoY[1] = 15; trangThai[1] = "BUSY";
        maTaiXe[2] = "TX03"; tenTaiXe[2] = "Le Van Lam";     soDienThoai[2] = "0933"; loaiXe[2] = "Xe may"; toaDoX[2] = 5;  toaDoY[2] = 5;  trangThai[2] = "AVAILABLE";
        soLuongTaiXe = 3;
    }
}