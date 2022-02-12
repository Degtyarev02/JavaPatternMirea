package com.company.EX6;

import com.company.EX6.abstract_factory.CarFactory;
import com.company.EX6.abstract_factory.CivilCarFactory;
import com.company.EX6.abstract_factory.SportCarFactory;
import com.company.EX6.builder.Builder;
import com.company.EX6.builder.Car;
import com.company.EX6.builder.CarBuilder;
import com.company.EX6.builder.Director;
import com.company.EX6.factory.*;
import com.company.EX6.prototype.Circle;
import com.company.EX6.prototype.Rectangle;
import com.company.EX6.prototype.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * todo Document type Test
 */
public class Test {
    public static void main(String[] args) {
        factory();
        abstractFactory();
        builder();
        prototype();
    }

    public static void builder() {
        System.out.println("================= Builder pattern =================");

        Builder builder = new CarBuilder();
        Director director = new Director(builder);

        director.constructSportCar();
        Car sportCar = builder.getResult();
        sportCar.print();

        director.constructSuv();
        Car suv = builder.getResult();
        suv.print();
    }

    public static void factory() {
        System.out.println("================= Factory pattern =================");
        Factory[] enemiesMakers = {new WarriorFactory(), new WizardFactory()};
        for (Factory factory : enemiesMakers) {
            Enemy enemy = factory.enemyFactory();
            enemy.printEnemyClass();
        }
    }

    public static void abstractFactory() {
        System.out.println("================= Abstract factory pattern =================");
        CarFactory[] carFactories = {new CivilCarFactory(), new SportCarFactory()};
        for (CarFactory factory : carFactories) {
            com.company.EX6.abstract_factory.Car sedan = factory.sedan();
            com.company.EX6.abstract_factory.Car suv = factory.suv();
            sedan.printType();
            suv.printType();
        }
    }

    public static void prototype() {
        System.out.println("================= Prototype pattern =================");
        Rectangle rect = new Rectangle();
        rect.setX(1);
        rect.setY(1);
        rect.setColor("Stroked Blue");
        rect.setHeight(10);
        rect.setWidth(20);

        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(25);
        circle.setColor("Filled Red");
        circle.setRadius(20);
        List<Shape> shapes = Arrays.asList(circle, rect);
        List<Shape> shapesClone = new ArrayList<>();
        for (Shape shape : shapes) {
            shapesClone.add(shape.clone());
        }
        System.out.println("Исходный массив: " + shapes);
        System.out.println("Скопированный массив: " + shapesClone);
    }
}
