public class Point {
    private int x;
    private int y;

    // Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Move method to shift the point by dx and dy
    public void move(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    // Calculate distance to another Point
    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test case 1: Create points A and B
        Point A = new Point(3, 4); // Point A at (3, 4)
        Point B = new Point(6, 8); // Point B at (6, 8)

        // Test case 2: Move point A by (1, 2)
        System.out.println("Before move, Point A is at (" + A.getX() + ", " + A.getY() + ")");
        A.move(1, 2); // Move A to (4, 6)
        System.out.println("After move(1, 2), Point A is at (" + A.getX() + ", " + A.getY() + ")");

        // Test case 3: Calculate distance between A and B
        double distance = A.distanceTo(B);
        System.out.println("Distance between Point A and Point B: " + distance);

        // Verify the distance calculation
        // Expected distance between (4, 6) and (6, 8) should be sqrt((6-4)^2 + (8-6)^2) = sqrt(4 + 4) = sqrt(8) ≈ 2.828
        // Expected distance between (3, 4) and (6, 8) should be sqrt((6-3)^2 + (8-4)^2) = sqrt(9 + 16) = sqrt(25) = 5.0
    }
}