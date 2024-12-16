package com.JavaLab.online_bank.service.impl;

import com.JavaLab.online_bank.entity.BankOffice;
import com.JavaLab.online_bank.repository.BankOfficeRepository;
import com.JavaLab.online_bank.service.BankOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankOfficeServiceImpl implements BankOfficeService {

    @Autowired
    private BankOfficeRepository bankOfficeRepository;

    @Override
    public List<BankOffice> getAllOffices() {
        return bankOfficeRepository.findAll();
    }

    @Override
    public boolean isAtmPlaceable(Long officeId) {
        BankOffice office = bankOfficeRepository.findById(officeId).orElse(null);
        return office != null && office.isAtmPlaceable();
    }

    @Override
    public int getAtmCount(Long officeId) {
        BankOffice office = bankOfficeRepository.findById(officeId).orElse(null);
        return office != null ? office.getAtmCount() : 0;
    }

    @Override
    public BankOffice create(BankOffice bankOffice) {
        return bankOfficeRepository.save(bankOffice);
    }

    @Override
    public void updateAtmCount(Long officeId, int atmCount) {
        BankOffice office = bankOfficeRepository.findById(officeId).orElse(null);
        if (office != null) {
            office.setAtmCount(atmCount);
            bankOfficeRepository.save(office);
        }
    }
}
