package model;

import java.sql.Date;

public class VietnameseCitizen extends Citizen {

    private String CCCD;
    private String sdt;
    private String diaChi;

    public VietnameseCitizen(String hoVaTen, Date ngaySinh, String gioiTinh, String passport, Date ngayNhapCanh, double trongLuongHanhLy, String CCCD, String sdt, String diaChi) {
        super(hoVaTen, ngaySinh, gioiTinh, passport, ngayNhapCanh, trongLuongHanhLy);
        this.CCCD = CCCD;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
