import com.google.common.collect.Lists;
import entity.Task;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Main main = new Main();

    @Test
    public void sort() {

        for (int i = 0; i <= 100000; i++) {
            List<Task> tasks = getTasks();
            Collections.shuffle(tasks);
            List<Task> sorted = main.sort(tasks);

            assertEquals(1L, sorted.get(0).getId());
            assertEquals(11L, sorted.get(1).getId());
            assertEquals(12L, sorted.get(2).getId());
            assertEquals(2L, sorted.get(3).getId());
            assertEquals(21L, sorted.get(4).getId());
            assertEquals(3L, sorted.get(5).getId());
        }

        for (int i = 0; i <= 100000; i++) {
            List<Task> tasks = getTasks2();
            Collections.shuffle(tasks);
            List<Task> sorted = main.sort(tasks);

            assertEquals(1L, sorted.get(0).getId());
            assertEquals(11L, sorted.get(1).getId());
            assertEquals(12L, sorted.get(2).getId());
            assertEquals(2L, sorted.get(3).getId());
            assertEquals(21L, sorted.get(4).getId());
            assertEquals(211L, sorted.get(5).getId());
            assertEquals(22L, sorted.get(6).getId());
            assertEquals(23L, sorted.get(7).getId());
            assertEquals(3L, sorted.get(8).getId());
        }

    }

    public List<Task> getTasks() {
        return Lists.newArrayList(
                Task.builder()
                        .id(3L)
                        .build(),
                Task.builder()
                        .id(11L)
                        .parentId(1L)
                        .build(),
                Task.builder()
                        .id(21L)
                        .parentId(2L)
                        .build(),
                Task.builder()
                        .id(2L)
                        .build(),
                Task.builder()
                        .id(12L)
                        .parentId(1L)
                        .build(),
                Task.builder()
                        .id(1L)
                        .build()
        );
    }

    public List<Task> getTasks2() {
        return Lists.newArrayList(
                Task.builder()
                        .id(3L)
                        .build(),
                Task.builder()
                        .id(2L)
                        .build(),
                Task.builder()
                        .id(12L)
                        .parentId(1L)
                        .build(),
                Task.builder()
                        .id(1L)
                        .build(),
                Task.builder()
                        .id(23L)
                        .parentId(2L)
                        .build(),
                Task.builder()
                        .id(22L)
                        .parentId(2L)
                        .build(),
                Task.builder()
                        .id(21L)
                        .parentId(2L)
                        .build(),
                Task.builder()
                        .id(11L)
                        .parentId(1L)
                        .build(),
                Task.builder()
                        .id(211L)
                        .parentId(21L)
                        .build()
        );
    }

}
