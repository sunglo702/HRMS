package com.dmu.hrms.service.impl;

import com.dmu.hrms.bean.Emprp;
import com.dmu.hrms.mapper.EmprpMapper;
import com.dmu.hrms.service.IEmprpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprpServiceImpl implements IEmprpService {
    @Autowired
    EmprpMapper emprpMapper;

    @Override
    public Emprp getEmprpById(Integer id) {
        return emprpMapper.getEmprpById(id);
    }

    @Override
    public List<Emprp> getAllEmprps() {
        return emprpMapper.getAllEmprps();
    }

    @Override
    public List<Emprp> getEmprpAndEmp() {
        return emprpMapper.getEmprpAndEmp();
    }

    @Override
    public int deleteEmprpById(Integer id) {
        return emprpMapper.deleteEmprpById(id);
    }

    @Override
    public int addEmprp(Emprp emprp) {
        return emprpMapper.addEmprp(emprp);
    }

    @Override
    public int updateEmprp(Emprp emprp) {
        return emprpMapper.updateEmprp(emprp);
    }

    @Override
    public List<Emprp> query(String name) {
        return emprpMapper.query(name);
    }
}
