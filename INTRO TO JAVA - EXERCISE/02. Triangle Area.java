package introduction_to_java_exercise;

import java.util.Scanner;


public class TriangleArea {

    static class Point {
        private int x;
        private int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Point A = new Point(input.nextInt(), input.nextInt());
        Point B = new Point(input.nextInt(), input.nextInt());
        Point C = new Point(input.nextInt(), input.nextInt());

        double area = Math.abs(A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY())
                + C.getX() * (A.getY() - B.getY())) / 2;

        System.out.println(Math.round(area));
    }
}
