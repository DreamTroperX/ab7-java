package my;

import java.util.Objects;

public class House implements Comparable <House>{
    protected int numberOfApartment;
    protected double area;
    protected int floor;
    protected int numberOfRooms;
    protected String street;

    public House(int numberOfApartment, double area, int floor, int numberOfRooms, String street) {
        this.numberOfApartment = numberOfApartment;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
    }

    public int getNumberOfApartment() {
        return numberOfApartment;
    }

    public void setNumberOfApartment(int numberOfApartment) {
        this.numberOfApartment = numberOfApartment;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toString() {
        return "House:numberOfApartment=" + this.numberOfApartment + ", area=" + this.area + ", floor=" + this.floor + ", numberOfRooms=" + this.numberOfRooms + ", street=" + this.street ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Double.compare(house.numberOfApartment, numberOfApartment) == 0 && Double.compare(house.area, area) == 0 && Double.compare(house.floor, floor) == 0 && Double.compare(house.numberOfRooms, numberOfRooms) == 0 && Objects.equals(street, house.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfApartment, area, floor, numberOfRooms, street);
    }

    @Override
    public int compareTo(House o) {
        return 0;
    }
}
