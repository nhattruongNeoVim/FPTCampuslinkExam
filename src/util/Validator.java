package util;

public class Validator {

    public static void validateCommonData(String[] data) throws Exception {
        // kiểm tra điều kiện chung
        validateDateOfBirth(data[2]);
        validateGender(data[3]);

        // kiểm tra điều kiện riêng
        validate(data);
    }

    public static void validate(String[] data) throws Exception {
        switch (Integer.parseInt(data[0])) {
            case 1:
                if (!data[10].equals("None") || !data[11].equals("None") || !data[12].equals("None") || !data[13].equals("None"))
                    throw new Exception("VietnameCitizen chứa thông tin không cần thết");
                break;
            case 2:
                if (!data[7].equals("None") || !data[8].equals("None") || !data[9].equals("None"))
                    throw new Exception("ForeignerCitizen chứa thông tin không cần thết");
                else if (!data[11].equals("Du lich") && !data[11].equals("Du hoc") && !data[11].equals("Cong tac")) {
                    throw new Exception("Sai định dạng ở trường Lý do nhập cảnh: " + data[11]);
                }
                break;
            default:
                throw new Exception("Sai định dạng loại người nhập cảnh");
        }
    }

    public static void validateDateOfBirth(String dob) throws Exception {
        if (!dob.matches("\\d{2}-\\d{2}-\\d{4}"))
            throw new Exception("Sai định dạng ở trường Ngày sinh: " + dob);
    }

    public static void validateGender(String gender) throws Exception {
        if (!gender.equals("Nam") && !gender.equals("Nu")) {
            throw new Exception("Sai định dạng ở trường Giới tính: " + gender);
        }
    }

    public static void validateTrongLuongHanhLy(String weight) throws Exception {
        try {
            double w = Double.parseDouble(weight);
            if (w <= 0 || w >= 100)
                throw new Exception("Sai định dạng ở trường Trọng lượng hành lý: " + w);
        } catch (NumberFormatException e) {
            throw new Exception("Sai định dạng ở trường Trọng lượng hành lý : " + weight);
        }
    }
}
