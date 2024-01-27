package dao;

import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForeignerCitizenDAO {

    public static void insert(model.ForeignerCitizen f) {
        Connection c = Database.getConnection();
        try {
            PreparedStatement pst1 = c.prepareStatement("INSERT INTO Citizen (hoVaTen, ngaySinh, gioiTinh, passport, ngayNhapCanh, trongLuongHanhLy) VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst1.setString(1, f.getHoVaTen());
            pst1.setDate(2, f.getNgaySinh());
            pst1.setString(3, f.getGioiTinh());
            pst1.setString(4, f.getPassport());
            pst1.setDate(5, f.getNgayNhapCanh());
            pst1.setDouble(6, f.getTrongLuongHanhLy());
            int rows1 = pst1.executeUpdate();

            ResultSet generatedKeys = pst1.getGeneratedKeys();
            int id = 0;
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }

            PreparedStatement pst2 = c.prepareStatement("INSERT INTO ForeignerCitizen VALUES (?, ?, ?, ?, ?)");
            pst2.setInt(1, id);
            pst2.setString(2, f.getQuocTich());
            pst2.setString(3, f.getLyDoNhapCanh());
            pst2.setInt(4, f.getSoLanNhapCanh());
            pst2.setDate(5, f.getNgayDuKienXuatCanh());
            int rows2 = pst2.executeUpdate();

            System.out.println("Insert succesfull: " + rows1 + " inserted");
            Database.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
