public class Cuboid {
    public static void main(String[] args) {

    // Write a program that stores 3 sides of a cuboid as variables (doubles)
    double a= 1;
    double b= 2;
    double c= 3;

// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000
        System.out.println(a*b*c);
        System.out.println(2*(a*b+b*c+a*c));
    }
}
