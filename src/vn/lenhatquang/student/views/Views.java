package vn.lenhatquang.student.views;


import vn.lenhatquang.student.model.Student;
import vn.lenhatquang.student.services.StudentService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Views {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService dssv = new StudentService();
        int luaChon = 0;
        do{
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
            if(luaChon==1){
//                System.out.println("Nhap ma sinh vien: ");
//                String maSinhVien = sc.nextLine();
//                System.out.println("Nhap ho va ten: ");
//                String hoVaTen = sc.nextLine();
//                System.out.println("Nhap nam sinh: ");
//                int namSinh = sc.nextInt();
//                System.out.println("Nhap diem trung binh ");
//                float diemTrungBinh = sc.nextFloat();
//                Student sv = new Student(maSinhVien,hoVaTen,namSinh,diemTrungBinh);
//                dssv.themSinhVien(dssv.taoSinhVien());
            }else if(luaChon==2){
                dssv.inDanhSachSinhVien();
            }else if(luaChon==3){
                System.out.println("Kiem tra danh sach rong: " + dssv.kiemTraDanhSachRong());

            }else if(luaChon==4){
                System.out.println("So luong hien tai: " + dssv.laySoLuongSinhVien());

            }else if(luaChon==5){
                dssv.lamRongDanhSach();

            }else if(luaChon==6){
                System.out.println("Nhap vao ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                Student sv = new Student(maSinhVien);
                System.out.println(" Kiem tra sinh vien co trong danh sach " + dssv.kiemTraTonTai(sv));
            }else if(luaChon==7){
                System.out.println("Nhap vao ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                Student sv = new Student(maSinhVien);
                dssv.xoaSinhVien(sv);
            }else if(luaChon==8){
                System.out.println("Nhap vao ho va ten ");
                String hoVaTen = sc.nextLine();
                System.out.println(" ket qua tim kiem: ");
                dssv.timSinhVien(hoVaTen);
            }else if(luaChon==9){
                dssv.sapXepSinhVienTheoDiemTangDan();
                dssv.inDanhSachSinhVien();
            }else if (luaChon == 10){
                System.out.println("Nhap ten file: ");
                String tenFile = sc.nextLine();
                File f = new File(tenFile);
                dssv.ghiDuLieuXuongFile(f);
            }
        }while (luaChon!=0);
    }
        Scanner sc = new Scanner(System.in);
    StudentService service = new StudentService();
    public void add() {
        System.out.println("Nhap ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                System.out.println("Nhap ho va ten: ");
                String hoVaTen = sc.nextLine();
                System.out.println("Nhap nam sinh: ");
                int namSinh = sc.nextInt();
                System.out.println("Nhap diem trung binh ");
                float diemTrungBinh = sc.nextFloat();
                Student sv = new Student(maSinhVien,hoVaTen,namSinh,diemTrungBinh);
        service.themSinhVien(sv);
    }

    public void showStudentList() {
        List<Student> list =service.getStudents();
        for(Student sinhVien: list){
            System.out.println(sinhVien);
        }
    }

    public boolean checkAvailableList() {

    }
}
