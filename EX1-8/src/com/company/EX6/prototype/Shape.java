package com.company.EX6.prototype;

/**
 * todo Document type Shape
 */
public abstract class Shape {
    private int x;
    private int y;
    private String color;

    public Shape() {

    }

    public Shape(Shape shape) {
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
            "x=" + x +
            ", y=" + y +
            ", color='" + color + '\'' +
            '}';
    }

    public abstract Shape clone();
}
