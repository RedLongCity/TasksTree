import entity.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    protected List<Task> sort(List<Task> tasks) {
        Map<Long, Task> mappedById = tasks.stream().collect(Collectors.toMap(Task::getId, t -> t));

        for (Map.Entry<Long, Task> entry : mappedById.entrySet()) {
            Task task = entry.getValue();
            Task parent = mappedById.get(task.getParentId());

            if (parent != null)
                parent.getChildren().add(task);
        }

        List<Task> parentsTopLevel = tasks.stream()
                .filter(t -> t.getParentId() == null)
                .sorted(Comparator.comparing(Task::getId))
                .collect(Collectors.toList());

        List<Task> result = new ArrayList<>();
        parentsTopLevel.forEach(parent -> parent.addItselfAndChildren(result));

        return result;
    }

}
