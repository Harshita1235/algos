import java.util.*;

class ClosestPair {
    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closest(Point[] pts) {
        Arrays.sort(pts, Comparator.comparingDouble(p -> p.x));
        return divide(pts, 0, pts.length - 1);
    }

    private static double divide(Point[] pts, int lo, int hi) {
        if (hi - lo <= 3) return bruteForce(pts, lo, hi);
        int mid = (lo + hi) / 2;
        double d1 = divide(pts, lo, mid);
        double d2 = divide(pts, mid + 1, hi);
        double d = Math.min(d1, d2);

        List<Point> strip = new ArrayList<>();
        double midX = pts[mid].x;
        for (int i = lo; i <= hi; i++)
            if (Math.abs(pts[i].x - midX) < d) strip.add(pts[i]);
        strip.sort(Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++) {
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
            }
        }
        return d;
    }

    private static double bruteForce(Point[] pts, int lo, int hi) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = lo; i <= hi; i++) {
            for (int j = i+1; j <= hi; j++) {
                min = Math.min(min, dist(pts[i], pts[j]));
            }
        }
        return min;
    }

    private static double dist(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}
