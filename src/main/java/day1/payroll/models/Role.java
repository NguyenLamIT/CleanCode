package day1.payroll.models;

public enum Role {
    DIRECTOR(1, "Director"),
    MANAGER(2, "Manager"),
    SALES(3, "Sales"),
    ENGINEER(4, "Engineer"),
    STAFF(5, "Staff"),
    WORKER(6, "Worker"),
    ;
    private int code;
    private String name;
    Role(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Role getRoleFromName(String name) {
        String nameLower = name.toLowerCase();
        switch (nameLower) {
            case "director":
                return DIRECTOR;
            case "manager":
                return  MANAGER;
            case "sales":
                return SALES;
            case "engineer":
                return ENGINEER;
            case "staff":
                return STAFF;
            case "worker":
                return WORKER;
            default:
                return null;
        }

    }

    @Override
    public String toString() {
        return name;
    }
}
