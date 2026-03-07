package com.fiddich;

public class Rectangle {

    int count = 0;
    int width;
    int height;
    int area;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getCount() {
        return count;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return area;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
