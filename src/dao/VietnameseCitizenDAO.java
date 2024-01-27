package dao;

import util.Database;
import model.VietnameseCitizen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VietnameseCitizenDAO {

    public static void insert(VietnameseCitizen v) {
        Connection c = Database.getConnection();
        try {
            PreparedStatement pst1 = c.prepareStatement("INSERT INTO Citizen (hoVaTen, ngaySinh, gioiTinh, passport, ngayNhapCanh, trongLuongHanhLy) VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst1.setString(1, v.getHoVaTen());
            pst1.setDate(2, v.getNgaySinh());
            pst1.setString(3, v.getGioiTinh());
            pst1.setString(4, v.getPassport());
            pst1.setDate(5, v.getNgayNhapCanh());
            pst1.setDouble(6, v.getTrongLuongHanhLy());
            int rows1 = pst1.executeUpdate();

            int id = 0;
            ResultSet generatedKeys = pst1.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }

            PreparedStatement pst2 = c.prepareStatement(" INSERT INTO VietnameseCitizen VALUES (?, ?, ?, ?)");
            pst2.setInt(1, id);
            pst2.setString(2, v.getCCCD());
            pst2.setString(3, v.getSdt());
            pst2.setString(4, v.getDiaChi());
            int row2 = pst2.executeUpdate();

            System.out.println("Insert succesfull: " + rows1 + " inserted");
            Database.closeConnection(c);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
