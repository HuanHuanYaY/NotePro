package com.example.notepro.service;

import com.example.notepro.domain.NoteBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteBookService {
    List<NoteBook> FindAllNoteNameByUserID(int userid);

    List<NoteBook> FindAllNoteFileNameByUserId(int userid);

    NoteBook FindAllNoteContentByUserIdandFile(int userid, String noteFileName);

    int updateNoteContentByUserIDAndFile(int userid, String noteFileName, String noteContent);

    int newNoteFile(int userid, String noteFileName,String noteContent, String bref);

    int deleteNoteFile(int userid, String noteFileName);

}
