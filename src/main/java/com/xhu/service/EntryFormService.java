package com.xhu.service;

import com.xhu.mapper.EntryFormMapper;
import com.xhu.pojo.EntryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntryFormService {
    @Autowired
    EntryFormMapper entryFormMapper;

    public EntryForm getEntryFormById(Integer stuId,Integer sportsIdEntry){
        return entryFormMapper.getEntryFormById(stuId,sportsIdEntry);
    }

    public int toEntrySports(Integer stuId,Integer sportsIdEntry){
        return entryFormMapper.toEntrySports(stuId,sportsIdEntry);
    }

    public List getEntryFormByStuId(Integer stuId){
        return entryFormMapper.getEntryFormByStuId(stuId);
    }

    public void delEntryFormById(Integer stuId,Integer sportsIdEntry){
        entryFormMapper.delEntryFormById(stuId,sportsIdEntry);
    }
}
