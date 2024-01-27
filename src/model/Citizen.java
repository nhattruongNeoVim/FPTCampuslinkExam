package model;

import java.sql.Date;

public class Citizen {

    protected String hoVaTen;
    protected Date ngaySinh;
    protected String gioiTinh;
    protected String passport;
    protected Date ngayNhapCanh;
    protected double trongLuongHanhLy;

    public Citizen(String hoVaTen, Date ngaySinh, String gioiTinh, String passport, Date ngayNhapCanh, double trongLuongHanhLy) {
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.passport = passport;
        this.ngayNhapCanh = ngayNhapCanh;
        this.trongLuongHanhLy = trongLuongHanhLy;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getNgayNhapCanh() {
        return ngayNhapCanh;
    }

    public void setNgayNhapCanh(Date ngayNhapCanh) {
        this.ngayNhapCanh = ngayNhapCanh;
    }

    public double getTrongLuongHanhLy() {
        return trongLuongHanhLy;
    }

    public void setTrongLuongHanhLy(double trongLuongHanhLy) {
        this.trongLuongHanhLy = trongLuongHanhLy;
    }
}
