package entity;

import lombok.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "children")
public class Task {

    private Long id;
    private Long parentId;

    @Builder.Default
    private Collection<Task> children = new ArrayList<>();

    public void addItselfAndChildren(List<Task> tasks) {
        tasks.add(this);
        if (CollectionUtils.isNotEmpty(children))
            children.forEach(child -> child.addItselfAndChildren(tasks));
    }

}
