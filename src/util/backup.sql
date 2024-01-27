drop database citizen;
create database citizen;
use citizen;


CREATE TABLE Citizen
(
    citizen_id       INT PRIMARY KEY AUTO_INCREMENT,
    hoVaTen          VARCHAR(255) NOT NULL,
    ngaySinh         DATE         NOT NULL,
    gioiTinh         VARCHAR(255) NOT NULL,
    passport         VARCHAR(255) NOT NULL,
    ngayNhapCanh     DATE         NOT NULL,
    trongLuongHanhLy VARCHAR(255)
);

CREATE TABLE VietnameseCitizen
(
    citizen_id INT PRIMARY KEY AUTO_INCREMENT,
    cccd       VARCHAR(255) NOT NULL,
    sdt        VARCHAR(255) NOT NULL,
    diaChi     VARCHAR(255) NOT NULL,
    FOREIGN KEY (citizen_id) REFERENCES Citizen (citizen_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE ForeignerCitizen
(
    citizen_id         INT PRIMARY KEY AUTO_INCREMENT,
    quocTich           VARCHAR(255) NOT NULL,
    lyDoNhapCanh       VARCHAR(255) NOT NULL,
    soLanNhapCanh      INT          NOT NULL,
    ngayDuKienXuatCanh DATE         NOT NULL,
    FOREIGN KEY (citizen_id) REFERENCES Citizen (citizen_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
