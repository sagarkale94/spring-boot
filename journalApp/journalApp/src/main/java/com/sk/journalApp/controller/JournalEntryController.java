package com.sk.journalApp.controller;

import com.sk.journalApp.entity.JournalEntry;
import com.sk.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean add(@RequestBody JournalEntry payloadJournalEntry){
        payloadJournalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveJournal(payloadJournalEntry);
        return true;
    }

    @GetMapping("id/{journalId}")
    public JournalEntry getJournalDetails(@PathVariable ObjectId journalId){
        return journalEntryService.getJournalDetails(journalId).orElse(null);
    }

    @PutMapping("id/{journalId}")
    public boolean update(@PathVariable ObjectId journalId, @RequestBody JournalEntry payloadJournalEntry){
            JournalEntry oldJournalEntry = journalEntryService.getJournalDetails(journalId).orElse(null);
        if(oldJournalEntry != null){
            oldJournalEntry.setTitle(payloadJournalEntry != null && !payloadJournalEntry.equals("") ? payloadJournalEntry.getTitle() : oldJournalEntry.getTitle() );
            oldJournalEntry.setContent(payloadJournalEntry != null && !payloadJournalEntry.equals("") ? payloadJournalEntry.getContent() : oldJournalEntry.getContent());
        }
        journalEntryService.saveJournal(oldJournalEntry);
        return true;
    }

    @DeleteMapping("id/{journalId}")
    public boolean delete(@PathVariable ObjectId journalId){
        journalEntryService.delete(journalId);
        return true;
    }

}
