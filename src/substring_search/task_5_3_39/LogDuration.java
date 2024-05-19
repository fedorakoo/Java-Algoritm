package substring_search.task_5_3_39;

import java.time.Duration;
import java.time.Instant;

public class LogDuration implements AutoCloseable {
    private String id;
    private Instant startTime;

    public LogDuration(String id) {
        this.id = id;
        this.startTime = Instant.now();
    }

    @Override
    public void close() {
        Instant endTime = Instant.now();
        Duration dur = Duration.between(startTime, endTime);
        System.out.println(id + ": время выполнения: " + dur.toMillis() + " ms");
    }
}
