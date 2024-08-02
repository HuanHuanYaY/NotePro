package com.example.notepro.dao;


import com.example.notepro.domain.NoteBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoteBookDao {
    List<NoteBook> FindAllNoteNameByUserID(@Param("userid") int userid);

    List<NoteBook> FindAllNoteFileNameByUserId(@Param("userid") int userid);

    NoteBook FindAllNoteContentByUserIdandFile(@Param("userid") int userid,@Param("noteFileName") String noteFileName);

    int updateNoteContentByUserIDAndFile(@Param("userid") int userid, @Param("noteFileName") String noteFileName, @Param("noteContent") String noteContent);

    int newNoteFile(@Param("userid") int userid,@Param("noteFileName") String noteFileName,@Param("noteContent") String noteContent, @Param("bref") String bref);

    int deleteNoteFile(@Param("userid") int userid,@Param("noteFileName") String noteFileName);

}
