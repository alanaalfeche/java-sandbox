class GravityCalculator{
    public static void main(String[] arguments){
        double gravity = -9.81;
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;

        // X_f(t) = 0.5at^2 + V_i(t) + X_i
        // Acceleration in this scenario is gravity
        finalPosition = 0.5 * (gravity *  Math.pow(fallingTime, 2)) + (initialVelocity * fallingTime) + initialPosition;
        double roundedFinalPosition = Math.round(finalPosition * 100)/100.0;
        System.out.println("The object's position after " + fallingTime + " second is " + roundedFinalPosition + " m.");
        // The object's position after 10.0 second is -490.5 m.
        // I guess the person falling started at the ground then fell towards the earth's core
    }
}