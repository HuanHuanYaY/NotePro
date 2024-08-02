package com.example.notepro.service.impl;

import com.example.notepro.dao.NoteBookDao;
import com.example.notepro.domain.NoteBook;
import com.example.notepro.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    private NoteBookDao noteBookDao;

    @Override
    public List<NoteBook> FindAllNoteNameByUserID(int userid) {
        return noteBookDao.FindAllNoteNameByUserID(userid);
    }

    @Override
    public List<NoteBook> FindAllNoteFileNameByUserId(int userid) {
        return noteBookDao.FindAllNoteFileNameByUserId(userid);
    }

    @Override
    public NoteBook FindAllNoteContentByUserIdandFile(int userid,String noteFileName) {
        return noteBookDao.FindAllNoteContentByUserIdandFile(userid,noteFileName);
    }

    @Override
    public int updateNoteContentByUserIDAndFile(int userid, String noteFileNAme, String noteContent){
        return noteBookDao.updateNoteContentByUserIDAndFile(userid, noteFileNAme, noteContent);
    }

    @Override
    public int newNoteFile(int userid, String noteFileName,String noteContent, String bref){
        return noteBookDao.newNoteFile(userid,noteFileName,noteContent,bref);
    }

    public int deleteNoteFile(int userid, String noteFileName){
        return noteBookDao.deleteNoteFile(userid,noteFileName);
    }
}
