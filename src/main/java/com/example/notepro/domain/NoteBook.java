package com.example.notepro.domain;

import lombok.Data;

@Data
public class NoteBook {
    private int noteId;
    private int userid;
    private String noteFileName;
    private String noteContent;
    private String bref;
}
