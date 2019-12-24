/**
 * Employee Pay Calculator
 * Overtime: 1.5 * basepay for over 40 hours with a maximum of 60 hours, else print error
 * Basepay: $8.00 / hour minimum, else print error
 */
class FooCorporation{

    private static final double MINIMUM_BASE_WAGE = 8.00;
    private static final int MAXIMUM_HOURS = 60;
    private static final int REGULAR_HOURS = 40;

    private static void calculateEmployeePay(double baseWage, int hoursWorked){
        if (baseWage < MINIMUM_BASE_WAGE){
            System.out.println("Base wage is less than minimum base wage.");
        } else if (hoursWorked > MAXIMUM_HOURS){
            System.out.println("Hours worked is greater than elligible maximum hours.");
        } else {
            double overtimeHours = hoursWorked - REGULAR_HOURS;
            double overtimePay = overtimeHours * (1.5 * baseWage);
            double basePay = REGULAR_HOURS * baseWage;
            double totalPay = overtimePay + basePay;
            System.out.println("Employee Pay: " + totalPay);
        }
    } 

    public static void main(String[] arguments){
        calculateEmployeePay(7.50, 35);
        calculateEmployeePay(8.20, 47);
        calculateEmployeePay(10, 73);
    }

}