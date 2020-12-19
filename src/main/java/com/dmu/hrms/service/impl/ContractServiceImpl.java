package com.dmu.hrms.service.impl;

import com.dmu.hrms.bean.Contract;
import com.dmu.hrms.mapper.ContractMapper;
import com.dmu.hrms.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public Contract getContractById(Integer id) {
        return contractMapper.getContractById(id);
    }

    @Override
    public List<Contract> getContractAndEmp() {
        return contractMapper.getContractAndEmp();
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractMapper.getAllContracts();
    }

    @Override
    public int deleteContractById(Integer id) {
        return contractMapper.deleteContractById(id);
    }

    @Override
    public int addContract(Contract contract) {
        return contractMapper.addContract(contract);
    }

    @Override
    public int updateContract(Contract contract) {
        return contractMapper.updateContract(contract);
    }

    @Override
    public List<Contract> query(String name) {
        return contractMapper.query(name);
    }
}
