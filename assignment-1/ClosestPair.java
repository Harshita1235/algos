import java.util.*;

class ClosestPair {

    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closest(Point[] pts) {

        Arrays.sort(pts, Comparator.comparingDouble(p -> p.x));

        return divideAndConquer(pts, 0, pts.length - 1);
    }

    // Recursive divide-and-conquer
    private static double divideAndConquer(Point[] pts, int left, int right) {
       
        if (right - left <= 3) return bruteForce(pts, left, right);

        int mid = (left + right) / 2;

        double dLeft = divideAndConquer(pts, left, mid);
        double dRight = divideAndConquer(pts, mid + 1, right);

        double d = Math.min(dLeft, dRight);


        double midX = pts[mid].x;
        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(pts[i].x - midX) < d) {
                strip.add(pts[i]);
            }
        }


        strip.sort(Comparator.comparingDouble(p -> p.y));


        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++) {
                d = Math.min(d, distance(strip.get(i), strip.get(j)));
            }
        }
        return d;
    }

 
    private static double bruteForce(Point[] pts, int left, int right) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                min = Math.min(min, distance(pts[i], pts[j]));
            }
        }
        return min;
    }

    private static double distance(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Point[] pts = {
            new Point(2, 3), new Point(12, 30),
            new Point(40, 50), new Point(5, 1),
            new Point(12, 10), new Point(3, 4)
        };
        System.out.println("Closest distance = " + closest(pts));
    }
}
