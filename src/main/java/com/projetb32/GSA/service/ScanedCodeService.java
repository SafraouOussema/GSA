package com.projetb32.GSA.service; 

import com.projetb32.GSA.entity.ScanedCode;
import com.projetb32.GSA.entity.Calendar; 
import com.projetb32.GSA.entity.Produit;
import com.projetb32.GSA.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component 
public class ScanedCodeService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ScanedCodeRepository scanedCodeRepository;
    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocauxRepository locauxRepository;


 
    public ScanedCode addScanedCode(ScanedCode scanedCode, long userId, long calenderId, long localId) {
        scanedCode.setUser(userRepository.findById(userId).get());
        scanedCode.setLocaux(locauxRepository.findById(localId).get());
        scanedCode.setCalendar(calendarRepository.findById(calenderId).get());

        return scanedCodeRepository.save(scanedCode);
    }


    public List<ScanedCode> getScanedCodeByCalander(long ficheId) {
        Calendar fiche = calendarRepository.findById(ficheId).get();
        return scanedCodeRepository.findDesinsectisationByCalendar(fiche);
    }

    public List<ScanedCode> getAllScanedCode() {
        return scanedCodeRepository.findAll();
    }
}
