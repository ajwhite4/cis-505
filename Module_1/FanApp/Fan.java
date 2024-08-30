/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_1.FanApp;

// This Java class defines the attributes of a fan
public class Fan {
    // declare constants for fan speeds
    final static int STOPPED = 0;
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;

    // Private data fields for speed, radius, and color of the fan, if the fan is on or off
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // Accessor and Mutator methods for variables (getters/setters)
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // No-argument constructor to create a default fan
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6;
        this.color = "white";
    }

    // Argument constructor to create a fan with specified values
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }    

    // Override the toString method to provide a string description of the fan
    @Override
    public String toString() {
        if (on) {
            return String.format("The fan speed is set to %d with a color of %s and a radius of %.1f", speed, color, radius);
        } else {
            return String.format("The fan is %s with a radius of %.1f and the fan is off", color, radius);
        }
    }
} // end Fan