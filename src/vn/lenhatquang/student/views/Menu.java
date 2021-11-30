package vn.lenhatquang.student.views;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Views view = new Views();
        int luaChon = 0;
        do {
            System.out.println("Menu--------");
            System.out.println("Vui long chon chuc nang");
            System.out.println(
                    "1. Them Sinh Vien Vao Danh Sach.\n"
                            + "2. In ra danh sach sinh vien. \n"
                            + "3. Kiem tra danh sach co rong hay khong.\n"
                            + "4. Lay ra so luong sinh vien trong danh sach./n"
                            + "5. Lam rong danh sach sinh vien.\n"
                            + "6. Kiem tra sinh vien co ton tai trong danh sach sinh vien hay khong, dua tren ma sinh vien.\n"
                            + "7. Xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien.\n"
                            + "8. Tim kiem tat ca sinh vien dua tren ten duoc nhap tu ban phim.\n"
                            + "9. Xuat ra danh sach Sinh Vien co diem tu cao den thap.\n"
                            + "10.Ghi danh sach ra file.\n"
                            + "0. Thoat khoi chuong trinh");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon){
                case 1:
                    view.add();
                    break;
                case 2:
                    view.showStudentList();
                    break;
                case 3:
                    view.checkAvailableList();
                    break;
                case 4:
                    view.checkAvailableList();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
            }
        } while(luaChon != 0);
    }
}

