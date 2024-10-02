package com.sk.journalApp.service;

import com.sk.journalApp.entity.JournalEntry;
import com.sk.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public JournalEntry saveJournal(JournalEntry payloadJournalEntry){
        return journalEntryRepository.save(payloadJournalEntry);
    }

    public Optional<JournalEntry> getJournalDetails(ObjectId journalId){
        return journalEntryRepository.findById(journalId);
    }

    public void delete(ObjectId journalId){
        journalEntryRepository.deleteById(journalId);
    }
}
