package com.company.EX6.prototype;

/**
 * todo Document type Circle
 */
public class Circle extends Shape{
    private int radius;

    public Circle(Circle shape) {
        super(shape);
        this.radius = shape.radius;
    }

    public Circle(){

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }
}
