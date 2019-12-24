/**
 * Employee Pay Calculator
 * Overtime: 1.5 * basepay for over 40 hours with a maximum of 60 hours, else print error
 * Basepay: $8.00 / hour minimum, else print error
 */
class FooCorporation{

    private static double minimumBaseWage = 8.00;
    private static int maximumHours = 60;
    private static int regularHours = 40;

    private static void calculateEmployeePay(double baseWage, int hoursWorked){
        if(baseWage < minimumBaseWage){
            System.out.println("Base wage is less than minimum base wage");
            return;
        }

        if(hoursWorked > maximumHours){
            System.out.println("Hours worked greater than elligible maximum hours");
            return;
        } 

        if(hoursWorked > regularHours){
            double overtimeHours = hoursWorked - regularHours;
            double overtimePay = overtimeHours * (1.5 * baseWage);
            double basePay = regularHours * baseWage;
            double totalPay = overtimePay + basePay;
            System.out.println(totalPay);
        }
    } 

    public static void main(String[] arguments){
        calculateEmployeePay(7.50, 35);
        calculateEmployeePay(8.20, 47);
        calculateEmployeePay(10, 73);
    }

}