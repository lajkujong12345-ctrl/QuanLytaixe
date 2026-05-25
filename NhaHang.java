package quanlyhethong;

import java.util.Scanner;

public class NhaHang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX = 100; // Giới hạn số lượng bản ghi tối đa hệ thống có thể lưu trữ

        // =================================================================
        // HỆ THỐNG MẢNG SONG SONG (PARALLEL ARRAYS) - THAY THẾ TOÀN BỘ OOP
        // =================================================================
        // 1. Mảng dữ liệu Nhà hàng (Chức năng 1, 2, 6)
        String[] resID = new String[MAX];
        String[] resName = new String[MAX];
        String[] resAddress = new String[MAX];
        int[] resX = new int[MAX];
        int[] resY = new int[MAX];
        int countRes = 0;

        // 2. Mảng dữ liệu Món ăn (Chức năng 3, 4, 5, 7, 8)
        String[] itemID = new String[MAX];
        String[] itemResID = new String[MAX]; // Khóa liên kết với resID của Nhà hàng (Khóa ngoại)
        String[] itemName = new String[MAX];
        double[] itemPrice = new double[MAX];
        int[] itemStock = new int[MAX];
        String[] itemCategory = new String[MAX]; // Thể loại món ăn
        boolean[] itemIsActive = new boolean[MAX]; // Trạng thái hoạt động (True = Đang bán, False = Ngừng bán)
        int countItems = 0;

        // 3. Mảng dữ liệu Tài xế (Chức năng 9, 10, 11, 12)
        String[] drvID = new String[MAX];
        String[] drvName = new String[MAX];
        String[] drvPhone = new String[MAX];
        String[] drvVehicle = new String[MAX]; // "Xe may" hoặc "O to"
        int[] drvX = new int[MAX];
        int[] drvY = new int[MAX];
        String[] drvStatus = new String[MAX];  // SAN_SANG, DANG_BAN, NGOAI_TUYEN
        int countDrivers = 0;

        // =================================================================
        // DỮ LIỆU MẪU BAN ĐẦU (SEED DATA ĐỂ TIỆN KIỂM THỬ)
        // =================================================================
        resID[0] = "R001";
        resName[0] = "Pho Ha Noi";
        resAddress[0] = "123 Nguyen Hue";
        resX[0] = 5;
        resY[0] = 5;
        countRes = 1;
        resID[1] = "R002";
        resName[1] = "Burger King";
        resAddress[1] = "456 Le Loi";
        resX[1] = 20;
        resY[1] = 10;
        countRes = 2;

        itemID[0] = "ITEM001";
        itemResID[0] = "R001";
        itemName[0] = "Pho bo nam";
        itemPrice[0] = 55000;
        itemStock[0] = 30;
        itemCategory[0] = "Truyen thong";
        itemIsActive[0] = true;
        itemID[1] = "ITEM002";
        itemResID[0] = "R001";
        itemName[1] = "Tra da";
        itemPrice[1] = 5000;
        itemStock[1] = 100;
        itemCategory[1] = "Nuoc uong";
        itemIsActive[1] = true;
        itemID[2] = "ITEM003";
        itemResID[1] = "R002";
        itemName[2] = "Beef Burger";
        itemPrice[2] = 89000;
        itemStock[2] = 15;
        itemCategory[2] = "Do an nhanh";
        itemIsActive[2] = true;
        countItems = 3;

        // =================================================================
        // VÒNG LẶP ĐIỀU HƯỚNG CHÍNH (MENU CHÍNH)
        // =================================================================
        while (true) {
            System.out.println("\n======================================");
            System.out.println("  HỆ THỐNG QUẢN LÝ GIAO ĐỒ ĂN");
            System.out.println("======================================");
            System.out.println("1. Quản lý Nhà hàng & Thực đơn (Chức năng 1-8)");
            System.out.println("2. Quản lý Tài xế (Chức năng 9-12)");
            System.out.println("6. Thoát chương trình");
            System.out.println("--------------------------------------");
            System.out.print("Vui lòng chọn chức năng: ");

            int mainChoice = sc.nextInt();
            sc.nextLine(); // Xóa bộ nhớ đệm

            // -------------------------------------------------------------
            // PHÂN HỆ 1: QUẢN LÝ NHÀ HÀNG & THỰC ĐƠN
            // -------------------------------------------------------------
            if (mainChoice == 1) {
                while (true) {
                    System.out.println("\n--- QUẢN LÝ NHÀ HÀNG & THỰC ĐƠN ---");
                    System.out.println("1. Thêm nhà hàng mới (Chức năng 1)");
                    System.out.println("2. Cập nhật thông tin nhà hàng (Chức năng 2)");
                    System.out.println("3. Xem danh sách nhà hàng (Chức năng 6)");
                    System.out.println("4. Thêm món ăn vào thực đơn (Chức năng 3)");
                    System.out.println("5. Cập nhật thông tin món ăn (Chức năng 4)");
                    System.out.println("6. Ngừng bán món ăn / Vô hiệu hóa (Chức năng 5)");
                    System.out.println("7. Xem thực đơn của một nhà hàng (Chức năng 7)");
                    System.out.println("8. Tìm kiếm món ăn toàn hệ thống (Chức năng 8)");
                    System.out.println("9. Quay lại Menu chính");
                    System.out.print("Vui lòng chọn: ");
                    int sub = sc.nextInt();
                    sc.nextLine();

                    // Chức năng 1: Thêm nhà hàng mới
                    if (sub == 1) {
                        if (countRes >= MAX) {
                            System.out.println("Thất bại: Bộ nhớ đã đầy!");
                            continue;
                        }
                        System.out.print("Nhập Mã nhà hàng: ");
                        String inputResId = sc.nextLine();

                        boolean isDup = false;
                        for (int i = 0; i < countRes; i++) {
                            if (resID[i].equalsIgnoreCase(inputResId)) {
                                isDup = true;
                                break;
                            }
                        }
                        if (isDup) {
                            System.out.println("Thất bại: Mã nhà hàng này đã tồn tại!");
                            continue;
                        }

                        resID[countRes] = inputResId;
                        System.out.print("Nhập Tên nhà hàng: ");
                        resName[countRes] = sc.nextLine();
                        System.out.print("Nhập Địa chỉ: ");
                        resAddress[countRes] = sc.nextLine();
                        System.out.print("Nhập Tọa độ Bản đồ X: ");
                        resX[countRes] = sc.nextInt();
                        System.out.print("Nhập Tọa độ Bản đồ Y: ");
                        resY[countRes] = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Thành công: Đã thêm nhà hàng mới.");
                        countRes++;
                    } // Chức năng 2: Cập nhật thông tin nhà hàng
                    else if (sub == 2) {
                        System.out.print("Nhập Mã nhà hàng cần cập nhật: ");
                        String sID = sc.nextLine();
                        int idx = -1;
                        for (int i = 0; i < countRes; i++) {
                            if (resID[i].equalsIgnoreCase(sID)) {
                                idx = i;
                                break;
                            }
                        }
                        if (idx == -1) {
                            System.out.println("Thất bại: Không tìm thấy nhà hàng này!");
                        } else {
                            System.out.print("Nhập Tên mới cho nhà hàng: ");
                            resName[idx] = sc.nextLine();
                            System.out.print("Nhập Địa chỉ mới: ");
                            resAddress[idx] = sc.nextLine();
                            System.out.println("Thành công: Đã cập nhật thông tin nhà hàng.");
                        }
                    } // Chức năng 6: Xem tất cả nhà hàng
                    else if (sub == 3) {
                        System.out.println("\n----------- DANH SÁCH NHÀ HÀNG -----------");
                        System.out.printf("%-12s %-20s %-25s %-15s\n", "Mã hàng", "Tên nhà hàng", "Địa chỉ", "Tọa độ (X,Y)");
                        System.out.println("---------------------------------------------------------------------------");
                        for (int i = 0; i < countRes; i++) {
                            System.out.printf("%-12s %-20s %-25s (%d,%d)\n", resID[i], resName[i], resAddress[i], resX[i], resY[i]);
                        }
                    } // Chức năng 3: Thêm món ăn vào thực đơn
                    else if (sub == 4) {
                        if (countItems >= MAX) {
                            System.out.println("Thất bại: Bộ nhớ món ăn đã đầy!");
                            continue;
                        }
                        System.out.print("Nhập Mã nhà hàng muốn thêm món: ");
                        String rID = sc.nextLine();

                        boolean resExists = false;
                        for (int i = 0; i < countRes; i++) {
                            if (resID[i].equalsIgnoreCase(rID)) {
                                resExists = true;
                                break;
                            }
                        }
                        if (!resExists) {
                            System.out.println("Thất bại: Mã nhà hàng không tồn tại trên hệ thống!");
                            continue;
                        }

                        System.out.print("Nhập Mã món ăn mới: ");
                        String inputItemId = sc.nextLine();
                        boolean itemDup = false;
                        for (int i = 0; i < countItems; i++) {
                            if (itemID[i].equalsIgnoreCase(inputItemId)) {
                                itemDup = true;
                                break;
                            }
                        }
                        if (itemDup) {
                            System.out.println("Thất bại: Mã món ăn này đã tồn tại!");
                            continue;
                        }

                        itemID[countItems] = inputItemId;
                        itemResID[countItems] = rID;
                        System.out.print("Nhập Tên món ăn: ");
                        itemName[countItems] = sc.nextLine();
                        System.out.print("Nhập Giá bán (VNĐ): ");
                        itemPrice[countItems] = sc.nextDouble();
                        System.out.print("Nhập Số lượng tồn kho: ");
                        itemStock[countItems] = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nhập Danh mục/Thể loại món: ");
                        itemCategory[countItems] = sc.nextLine();
                        itemIsActive[countItems] = true; // Mặc định là True (Đang bán)
                        System.out.println("Thành công: Đã thêm món ăn vào thực đơn.");
                        countItems++;
                    } // Chức năng 4: Cập nhật món ăn
                    else if (sub == 5) {
                        System.out.print("Nhập Mã món ăn cần sửa: ");
                        String itID = sc.nextLine();
                        int idx = -1;
                        for (int i = 0; i < countItems; i++) {
                            if (itemID[i].equalsIgnoreCase(itID)) {
                                idx = i;
                                break;
                            }
                        }
                        if (idx == -1) {
                            System.out.println("Thất bại: Món ăn không tồn tại!");
                        } else {
                            System.out.print("Nhập Giá bán mới: ");
                            itemPrice[idx] = sc.nextDouble();
                            System.out.print("Nhập Số lượng kho mới: ");
                            itemStock[idx] = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Thành công: Đã cập nhật thông tin món ăn.");
                        }
                    } // Chức năng 5: Vô hiệu hóa món ăn (Ẩn đi)
                    else if (sub == 6) {
                        System.out.print("Nhập Mã món ăn muốn ngừng bán: ");
                        String itID = sc.nextLine();
                        int idx = -1;
                        for (int i = 0; i < countItems; i++) {
                            if (itemID[i].equalsIgnoreCase(itID)) {
                                idx = i;
                                break;
                            }
                        }
                        if (idx == -1) {
                            System.out.println("Thất bại: Không tìm thấy món ăn này!");
                        } else {
                            itemIsActive[idx] = false; // Đổi trạng thái chứ không xóa khỏi mảng để bảo toàn dữ liệu
                            System.out.println("Thành công: Món ăn đã được chuyển sang trạng thái [NGỪNG BÁN].");
                        }
                    } // Chức năng 7: Xem thực đơn của một nhà hàng cụ thể
                    else if (sub == 7) {
                        System.out.print("Nhập Mã nhà hàng muốn xem thực đơn: ");
                        String rID = sc.nextLine();
                        System.out.println("\n--- THỰC ĐƠN CỦA NHÀ HÀNG: " + rID + " ---");
                        System.out.printf("%-12s %-20s %-15s %-12s %-15s\n", "Mã món", "Tên món ăn", "Giá bán", "Tồn kho", "Trạng thái");
                        System.out.println("-----------------------------------------------------------------------------");
                        for (int i = 0; i < countItems; i++) {
                            if (itemResID[i].equalsIgnoreCase(rID)) {
                                String status = itemIsActive[i] ? "Đang bán" : "Ngừng bán";
                                System.out.printf("%-12s %-20s %-15.0f %-12d %-15s\n", itemID[i], itemName[i], itemPrice[i], itemStock[i], status);
                            }
                        }
                    } // Chức năng 8: Tìm kiếm món ăn toàn cục theo Tên hoặc Danh mục
                    else if (sub == 8) {
                        System.out.print("Nhập từ khóa tìm kiếm (Tên hoặc Danh mục): ");
                        String key = sc.nextLine().toLowerCase();
                        System.out.println("\n----------- KẾT QUẢ TÌM KIẾM TOÀN HỆ THỐNG -----------");
                        System.out.printf("%-12s %-12s %-20s %-15s %-15s\n", "Mã món", "Mã nhà hàng", "Tên món ăn", "Giá bán", "Danh mục");
                        System.out.println("-------------------------------------------------------------------------------------");
                        for (int i = 0; i < countItems; i++) {
                            if (itemIsActive[i]) { // Chỉ tìm và hiển thị những món ăn còn đang bán hoạt động
                                if (itemName[i].toLowerCase().contains(key) || itemCategory[i].toLowerCase().contains(key)) {
                                    System.out.printf("%-12s %-12s %-20s %-15.0f %-15s\n", itemID[i], itemResID[i], itemName[i], itemPrice[i], itemCategory[i]);
                                }
                            }
                        }
                    } else if (sub == 9) {
                        break;
                    }
                }
            } // -------------------------------------------------------------
            // PHÂN HỆ 2: QUẢN LÝ TÀI XẾ
            // -------------------------------------------------------------
            else if (mainChoice == 2) {
                while (true) {
                    System.out.println("\n--- QUẢN LÝ TÀI XẾ ---");
                    System.out.println("1. Thêm tài xế mới (Chức năng 9)");
                    System.out.println("2. Cập nhật vị trí & trạng thái tài xế (Chức năng 10)");
                    System.out.println("3. Xem danh sách toàn bộ tài xế (Chức năng 11)");
                    System.out.println("4. Tìm tài xế đang trống ở gần nhất (Chức năng 12)");
                    System.out.println("5. Quay lại Menu chính");
                    System.out.print("Vui lòng chọn: ");
                    int sub = sc.nextInt();
                    sc.nextLine();

                    // Chức năng 9: Thêm tài xế mới
                    if (sub == 1) {
                        if (countDrivers >= MAX) {
                            System.out.println("Thất bại: Bộ nhớ danh sách đầy!");
                            continue;
                        }
                        System.out.print("Nhập Mã tài xế: ");
                        String inputDrvId = sc.nextLine();

                        boolean isDup = false;
                        for (int i = 0; i < countDrivers; i++) {
                            if (drvID[i].equalsIgnoreCase(inputDrvId)) {
                                isDup = true;
                                break;
                            }
                        }
                        if (isDup) {
                            System.out.println("Thất bại: Mã tài xế này đã tồn tại!");
                            continue;
                        }

                        drvID[countDrivers] = inputDrvId;
                        System.out.print("Nhập Họ và tên tài xế: ");
                        drvName[countDrivers] = sc.nextLine();
                        System.out.print("Nhập Số điện thoại: ");
                        drvPhone[countDrivers] = sc.nextLine();
                        System.out.println("Chọn Loại phương tiện: 1. Xe máy   2. Ô tô");
                        int type = sc.nextInt();
                        drvVehicle[countDrivers] = (type == 1) ? "Xe may" : "O to";
                        System.out.print("Nhập vị trí Tọa độ X: ");
                        drvX[countDrivers] = sc.nextInt();
                        System.out.print("Nhập vị trí Tọa độ Y: ");
                        drvY[countDrivers] = sc.nextInt();
                        sc.nextLine();
                        drvStatus[countDrivers] = "SAN_SANG"; // Trạng thái ban đầu mặc định là Sẵn sàng nhận đơn

                        System.out.println("Thành công: Đã thêm tài xế mới.");
                        countDrivers++;
                    } // Chức năng 10: Cập nhật vị trí và trạng thái tài xế
                    else if (sub == 2) {
                        System.out.print("Nhập Mã tài xế cần cập nhật: ");
                        String sID = sc.nextLine();
                        int idx = -1;
                        for (int i = 0; i < countDrivers; i++) {
                            if (drvID[i].equalsIgnoreCase(sID)) {
                                idx = i;
                                break;
                            }
                        }
                        if (idx == -1) {
                            System.out.println("Thất bại: Tài xế này không tồn tại!");
                        } else {
                            System.out.print("Nhập vị trí Tọa độ X mới: ");
                            drvX[idx] = sc.nextInt();
                            System.out.print("Nhập vị trí Tọa độ Y mới: ");
                            drvY[idx] = sc.nextInt();
                            System.out.println("Cập nhật trạng thái làm việc: 1. SẴN SÀNG  2. ĐANG BẬN  3. NGOẠI TUYẾN");
                            int st = sc.nextInt();
                            sc.nextLine();
                            if (st == 1) {
                                drvStatus[idx] = "SAN_SANG";
                            } else if (st == 2) {
                                drvStatus[idx] = "DANG_BAN";
                            } else if (st == 3) {
                                drvStatus[idx] = "NGOAI_TUYEN";
                            }
                            System.out.println("Thành công: Đã cập nhật trạng thái tài xế.");
                        }
                    } // Chức năng 11: Xem danh sách tài xế
                    else if (sub == 3) {
                        System.out.println("\n----------- DANH SÁCH TÀI XẾ -----------");
                        System.out.printf("%-12s %-20s %-15s %-12s %-15s %-15s\n", "Mã tài xế", "Họ tên", "Điện thoại", "Phương tiện", "Vị trí", "Trạng thái");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        for (int i = 0; i < countDrivers; i++) {
                            System.out.printf("%-12s %-20s %-15s %-12s (%d,%d)          %-15s\n", drvID[i], drvName[i], drvPhone[i], drvVehicle[i], drvX[i], drvY[i], drvStatus[i]);
                        }
                    } // Chức năng 12: Tìm tài xế đang rảnh ở gần điểm chỉ định nhất
                    else if (sub == 4) {
                        System.out.print("Nhập Tọa độ đích X (Ví dụ tọa độ nhà hàng): ");
                        int targetX = sc.nextInt();
                        System.out.print("Nhập Tọa độ đích Y (Ví dụ tọa độ nhà hàng): ");
                        int targetY = sc.nextInt();
                        sc.nextLine();

                        int bestIdx = -1;
                        double minDistance = Double.MAX_VALUE;

                        for (int i = 0; i < countDrivers; i++) {
                            if (drvStatus[i].equalsIgnoreCase("SAN_SANG")) { // Chỉ quét những tài xế đang rảnh việc công việc
                                double dist = Math.sqrt(Math.pow(drvX[i] - targetX, 2) + Math.pow(drvY[i] - targetY, 2));
                                if (dist < minDistance) {
                                    minDistance = dist;
                                    bestIdx = i;
                                }
                            }
                        }

                        if (bestIdx == -1) {
                            System.out.println("Thông báo: Hiện tại không có tài xế nào ở trạng thái [SẴN SÀNG]!");
                        } else {
                            System.out.println("-> Tìm thấy tài xế đang trống việc ở gần nhất!");
                            System.out.println("   Mã tài xế: " + drvID[bestIdx] + " | Họ tên: " + drvName[bestIdx] + " | Xe: " + drvVehicle[bestIdx]);
                            System.out.printf("   Vị trí hiện tại: (%d,%d) | Khoảng cách bản đồ: %.2f đơn vị vị trí\n", drvX[bestIdx], drvY[bestIdx], minDistance);
                        }
                    } else if (sub == 5) {
                        break;
                    }
                }
            } // -------------------------------------------------------------
            // THOÁT CHƯƠNG TRÌNH
            // -------------------------------------------------------------
            else if (mainChoice == 6) {
                System.out.println("Hệ thống đã đóng an toàn. Qúa Khê!");
                break;
            } else {
                System.out.println("Thất bại: Lựa chọn sai quy định, vui lòng nhập lại!");
            }
        }
    }
}
