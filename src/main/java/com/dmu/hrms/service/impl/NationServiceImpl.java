package com.dmu.hrms.service.impl;

import com.dmu.hrms.bean.Nation;
import com.dmu.hrms.mapper.NationMapper;
import com.dmu.hrms.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements INationService {
    @Autowired
    private NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
