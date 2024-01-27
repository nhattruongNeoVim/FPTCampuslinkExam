package main;

import dao.ForeignerCitizenDAO;
import dao.VietnameseCitizenDAO;
import model.VietnameseCitizen;
import model.ForeignerCitizen;
import util.Validator;

import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        PrintWriter invalidLinesWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("/home/albedo/UserData/FPTCampuslinkExam/src/main/input.txt"));
            invalidLinesWriter = new PrintWriter(new FileWriter("/home/albedo/UserData/FPTCampuslinkExam/src/main/output.txt"));
            SimpleDateFormat inputDate = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

            String line = null;
            int lineNumber = 0;
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;
                String[] data = line.split(", ");

                // format ngay sinh
                java.util.Date dateOfBirth = inputDate.parse(data[2]);
                Date dob = Date.valueOf(formatDate.format(dateOfBirth));

                // format ngay nhap canh
                java.util.Date nhapCanh = inputDate.parse(data[5]);
                Date ngayNhapCanh = Date.valueOf(formatDate.format(nhapCanh));

                try {
                    // check validator
                    Validator.validateCommonData(data);

                    int citizenType = Integer.parseInt(data[0]);
                    switch (citizenType) {
                        case 1:
                            VietnameseCitizen vietnameseCitizen = new VietnameseCitizen(data[1], dob, data[3], data[4], ngayNhapCanh, Double.parseDouble(data[6]), data[7], data[8], data[9]);
                            VietnameseCitizenDAO.insert(vietnameseCitizen);
                            break;
                        case 2:
                            // format ngay xuat canh
                            java.util.Date xuatCanh = inputDate.parse(data[13]);
                            Date ngayXuatCanh = Date.valueOf(formatDate.format(xuatCanh));

                            ForeignerCitizen foreignerCitizen = new ForeignerCitizen(data[1], dob, data[3], data[4], ngayNhapCanh, Double.parseDouble(data[6]), data[10], data[11], Integer.parseInt(data[12]), ngayXuatCanh);
                            ForeignerCitizenDAO.insert(foreignerCitizen);
                            break;
                    }
                } catch (Exception e) {
                    invalidLinesWriter.println("Dòng " + lineNumber + ": " + e.getMessage());
//                    e.printStackTrace();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (invalidLinesWriter != null) {
                    invalidLinesWriter.flush();
                    invalidLinesWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
