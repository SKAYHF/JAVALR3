package com.JavaLab.online_bank.service;

import com.JavaLab.online_bank.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {

    List<BankOffice> getAllOffices();

    boolean isAtmPlaceable(Long officeId);

    int getAtmCount(Long officeId);

    BankOffice create(BankOffice bankOffice);

    void updateAtmCount(Long officeId, int atmCount);
}
