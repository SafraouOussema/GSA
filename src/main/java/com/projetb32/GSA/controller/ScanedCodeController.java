package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.ScanedCode;
import com.projetb32.GSA.repository.ScanedCodeRepository;
import com.projetb32.GSA.service.ScanedCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class ScanedCodeController {
     
    @Autowired
    private ScanedCodeRepository ficheRepository;
    @Autowired
    private ScanedCodeService ficheService;


    @GetMapping("/scanedCode")
    public ResponseEntity<List<ScanedCode>> GetScanedCode() {
        List<ScanedCode> listfiche = null;
        listfiche = ficheRepository.findAll();
        if (listfiche.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listfiche, HttpStatus.OK);
    }


    @GetMapping("/scanedCodecalanderid/{calanderid}")
	public ResponseEntity<List<ScanedCode>>  Getcalandarbydateanduser(@PathVariable Long calanderid ) 
	{
        List<ScanedCode> scanedCodeList;
        scanedCodeList = ficheService.getScanedCodeByCalander(calanderid);		
        return new ResponseEntity<>(scanedCodeList, HttpStatus.OK);
	} 
 
   
    @PostMapping("/scanedCode/{userId}/{calenderId}/{localId}")
    public ResponseEntity<ScanedCode> addFiche(@RequestBody ScanedCode fiche, @PathVariable long userId, @PathVariable long calenderId, @PathVariable  long localId) {
        ScanedCode ficheLocal = ficheService.addScanedCode(fiche, userId,calenderId,localId);

        if (ficheLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ficheLocal, HttpStatus.OK);

    } 


    @DeleteMapping("/scanedCode/{scanedCodeId}")
    public ResponseEntity<ScanedCode> deleteFiche(@PathVariable long scanedCodeId) {
        ficheRepository.deleteById(scanedCodeId);
        return ResponseEntity.accepted().build();
    }


}
