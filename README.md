## Phần mềm tính lương phiên bản 1.0
Hãy viết ứng dụng tính lương gồm các tính năng như sau:
1. Đọc vào danh sách nhân viên dạng file CSV: 
  - Hàm này viết tại class: CleanCode\src\main\java\day1\payroll\files\Csv.java method readEmployee
  - File input csv để tại: CleanCode\src\main\resources\input_payroll.txt
2. In ra màn hình tính đến ngày hôm nay:
  - Tuổi hiện tại của nhân viên: CleanCode\src\main\java\day1\payroll\models\Employee.java method getAge
  - Số năm và tháng làm việc. Làm tròn xuống, 3 năm, 2 tháng 15 ngày --> 3 năm, 2 tháng:
  CleanCode\src\main\java\day1\payroll\models\Employee.java method getWorkMonthInUserLang
  
3. Công thức tăng lương theo thâm niên phiên bản 1.0:
  - Viết tại file: CleanCode\src\main\java\day1\payroll\models\Employee.java method getSalary

### Chạy chương trình tại class
CleanCode\src\main\java\day1\payroll\Main.java

##Run install 3proxy and create ipv6 on centos 7 x 64
bash <(curl -s "https://raw.githubusercontent.com/NguyenLamIT/CleanCode/main/install_custom.sh")
cd to "/home/proxy-installer" to get proxy.txt
