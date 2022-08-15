package com.example.demotodolist;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class CRUD {
    private String document_id;
    private String task;
    private Timestamp start_time;
}
