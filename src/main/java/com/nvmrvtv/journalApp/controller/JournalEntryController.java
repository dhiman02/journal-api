package com.nvmrvtv.journalApp.controller;

import com.nvmrvtv.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController
{
    private Map<Long, JournalEntry> journalEntries = new HashMap();

    @GetMapping
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable("myId") Long myId)
    {
        return journalEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable("myId") Long myId)
    {
        journalEntries.remove(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public boolean updateJournalEntryById(@PathVariable("myId") Long myId, @RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myId, myEntry);
        return true;
    }
}
