package vn.lenhatquang.student.services;

import vn.lenhatquang.student.model.Student;

import java.io.*;
import java.util.*;

public class StudentService {
    private List<Student> studentList;
    //khai bao 1 ArrayList trong truong hop nguoi ta k truyen vao 1 ArrayList
    public StudentService() {
        this.studentList = new ArrayList<Student>();
    }

    public StudentService(ArrayList<Student> danhSach) {
        this.studentList = danhSach;
    }

    //"1. Them Sinh Vien Vao Danh Sach.\n"
    public void themSinhVien(Student sv){
        this.studentList.add(sv);
    }
    //2. In ra danh sach sinh vien
    public void inDanhSachSinhVien(){
        for(Student sinhVien: studentList){
            System.out.println(sinhVien);
        }
    }
    //3. Kiem tra danh sach sinh vien co rong hay khong
    public boolean kiemTraDanhSachRong(){
        return this.studentList.isEmpty();
    }
    //4 Lay ra so luong sinh vien trong danh sach
    public int laySoLuongSinhVien(){
        return this.studentList.size();
    }
    //5. Lam rong danh sach sinh vien
    public void lamRongDanhSach(){
        this.studentList.removeAll(studentList);
    }
    //6.Kiem tra ton tai Sinh Vien
    public boolean kiemTraTonTai(Student sv){
        return this.studentList.contains(sv);
    }
    // 7. Xoa mot ban  sinh vien ra khoi danh sach danh sinh vien
    public boolean xoaSinhVien(Student sv){
        return this.studentList.remove(sv);
    }
    // 8. Tim sinh vien
    public void timSinhVien(String ten) {
        for (Student sinhVien : studentList
        ) {
            if (sinhVien.getHoVaTen().indexOf(ten) >= 0) {
                System.out.println(sinhVien);
            }
        }
    }
    //9. Xuat ra sinh vien tu cao den thap
    public void sapXepSinhVienTheoDiemTangDan(){
        Collections.sort(this.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student sv1, Student sv2) {
                if(sv1.getDiemTrungBinh()<sv2.getDiemTrungBinh())
                    return -1;
                else if(sv1.getDiemTrungBinh()>sv2.getDiemTrungBinh()){
                    return 1;
                }else
                    return 0;
            }
        });
    }
    //10. Ghi xuong file
    public void ghiDuLieuXuongFile(File file){
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            for(Student student : studentList){
                oos.writeObject(student);
            }
            oos.flush();
            oos.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //11. Doc du lieu tu file
    public List<Student> docHocSinhTuDanhSach(File file){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }

    public List<Student> getStudents() {
        return studentList;
    }
}
