import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class Metrics {
    private final ThreadLocal<Integer> depth = ThreadLocal.withInitial(() -> 0);
    private final AtomicLong maxDepth = new AtomicLong(0);
    private final AtomicLong comparisons = new AtomicLong(0);
    private final AtomicLong allocations = new AtomicLong(0);

    public void enter() {
        int d = depth.get() + 1;
        depth.set(d);
        maxDepth.updateAndGet(x -> Math.max(x, d));
    }

    public void leave() {
        depth.set(Math.max(0, depth.get() - 1));
    }

    public void countComparison(long x) { comparisons.addAndGet(x); }
    public void countAllocation(long x) { allocations.addAndGet(x); }

    public long getMaxDepth() { return maxDepth.get(); }
    public long getComparisons() { return comparisons.get(); }
    public long getAllocations() { return allocations.get(); }

    public void reset() {
        depth.set(0);
        maxDepth.set(0);
        comparisons.set(0);
        allocations.set(0);
    }

    public void writeCsv(String path, String header, String line) {
        try {
            File f = new File(path);
            boolean newFile = !f.exists();
            try (FileWriter fw = new FileWriter(f, true)) {
                if (newFile) fw.write(header + "\n");
                fw.write(line + "\n");
            }
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}
