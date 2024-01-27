package model;

import java.sql.Date;

public class ForeignerCitizen extends Citizen {

    private String quocTich;
    private String lyDoNhapCanh;
    private int soLanNhapCanh;
    private Date ngayDuKienXuatCanh;

    public ForeignerCitizen(String hoVaTen, Date ngaySinh, String gioiTinh, String passport, Date ngayNhapCanh, double trongLuongHanhLy, String quocTich, String lyDoNhapCanh, int soLanNhapCanh, Date ngayDuKienXuatCanh) {
        super(hoVaTen, ngaySinh, gioiTinh, passport, ngayNhapCanh, trongLuongHanhLy);
        this.quocTich = quocTich;
        this.lyDoNhapCanh = lyDoNhapCanh;
        this.soLanNhapCanh = soLanNhapCanh;
        this.ngayDuKienXuatCanh = ngayDuKienXuatCanh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getLyDoNhapCanh() {
        return lyDoNhapCanh;
    }

    public void setLyDoNhapCanh(String lyDoNhapCanh) {
        this.lyDoNhapCanh = lyDoNhapCanh;
    }

    public int getSoLanNhapCanh() {
        return soLanNhapCanh;
    }

    public void setSoLanNhapCanh(int soLanNhapCanh) {
        this.soLanNhapCanh = soLanNhapCanh;
    }

    public Date getNgayDuKienXuatCanh() {
        return ngayDuKienXuatCanh;
    }

    public void setNgayDuKienXuatCanh(Date ngayDuKienXuatCanh) {
        this.ngayDuKienXuatCanh = ngayDuKienXuatCanh;
    }
}
