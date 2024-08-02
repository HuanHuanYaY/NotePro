package com.example.notepro.controller.impl;
import com.example.notepro.domain.NoteBook;
import com.example.notepro.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/notebook")
public class NoteBookControllerImpl {
    @Autowired
    private NoteBookService noteBookService;

    @GetMapping("/FindByAccountEmail")
    public List<NoteBook> FindByAccountEmail(@RequestParam int userid){
        return noteBookService.FindAllNoteNameByUserID(userid);
    }

    @PostMapping("/FindAllNoteFileNameByUserId")
    public List<NoteBook> FindAllNoteFileNameByUserId(@RequestParam int userid){
        return noteBookService.FindAllNoteFileNameByUserId(userid);
    }

    @PostMapping("/FindAllNoteContentByUserIdandFile")
    public NoteBook FindAllNoteContentByUserIdandFile(@RequestParam int userid, @RequestParam String noteFileName){
        return noteBookService.FindAllNoteContentByUserIdandFile(userid,noteFileName);
    }

    @PostMapping("/updateNoteContentByUserIDAndFile")
    public int updateNoteContentByUserIDAndFile(@RequestParam int userid, @RequestParam String noteFileName,@RequestParam String noteContent){
        return noteBookService.updateNoteContentByUserIDAndFile(userid, noteFileName, noteContent);
    }

    @PostMapping("/newNoteFile")
    public int newNoteFile(@RequestParam int userid, @RequestParam String noteFileName,@RequestParam String noteContent,@RequestParam String bref){
        return noteBookService.newNoteFile(userid,noteFileName,noteContent,bref);
    }

    @PostMapping("/deleteNoteFile")
    public int deleteNoteFile(@RequestParam int userid, @RequestParam String noteFileName){
        return noteBookService.deleteNoteFile(userid, noteFileName);
    }
}
