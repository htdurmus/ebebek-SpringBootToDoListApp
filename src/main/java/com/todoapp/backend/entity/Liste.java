package com.todoapp.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Liste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_column", nullable = false, length = 40)
    private String task;

    @Column(name = "checkedIs", nullable = false, length = 5)
    private boolean checked;

    @Column(name = "finish_date", nullable = false, length = 10)
    private String finishDate;

    @Column(name = "list_name", nullable = false, length = 40)
    private String listName;

    public Liste(String task, boolean checked, String finishDate, String listName) {
        this.id = id;
        this.task = task;
        this.checked = checked;
        this.finishDate = finishDate;
        this.listName = listName;
    }
}
