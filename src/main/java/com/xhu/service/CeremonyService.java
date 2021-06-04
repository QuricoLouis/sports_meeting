package com.xhu.service;

import com.xhu.mapper.AdminMapper;
import com.xhu.mapper.CeremonyMapper;
import com.xhu.pojo.Admin;
import com.xhu.pojo.CeremonyClose;
import com.xhu.pojo.CeremonyOpen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CeremonyService {
    @Autowired
    CeremonyMapper ceremonyMapper;

    /*开幕式*/
    public CeremonyOpen getCeremonyOpen() {
        return ceremonyMapper.getCeremonyOpen();
    }

    public CeremonyOpen getCeremonyOpenById(String ceremonyId) {
        return ceremonyMapper.getCeremonyOpenById(ceremonyId);
    }

    public int addCeremonyOpen(CeremonyOpen ceremonyOpen) {
        return ceremonyMapper.addCeremonyOpen(ceremonyOpen);
    }

    public int updCeremonyOpen(CeremonyOpen ceremonyOpen) {
        return ceremonyMapper.updCeremonyOpen(ceremonyOpen);
    }

    public void delCeremonyOpen(String ceremonyId) {
        ceremonyMapper.delCeremonyOpen(ceremonyId);
    }

    /*闭幕式*/
    public CeremonyClose getCeremonyClose() {
        return ceremonyMapper.getCeremonyClose();
    }

    public CeremonyClose getCeremonyCloseById(String ceremonyId) {
        return ceremonyMapper.getCeremonyCloseById(ceremonyId);
    }

    public int addCeremonyClose(CeremonyClose ceremonyClose) {
        return ceremonyMapper.addCeremonyClose(ceremonyClose);
    }

    public int updCeremonyClose(CeremonyClose ceremonyClose) {
        return ceremonyMapper.updCeremonyClose(ceremonyClose);
    }

    public void delCeremonyClose(String ceremonyId) {
        ceremonyMapper.delCeremonyClose(ceremonyId);
    }
}
