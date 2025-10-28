package com.abdhu.pemakaian_service.service;

import com.abdhu.pemakaian_service.model.Pemakaian;
import com.abdhu.pemakaian_service.repository.PemakaianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PemakaianService {

    @Autowired
    private PemakaianRepository pemakaianRepository;

    public List<Pemakaian> getAllPemakaian() {
        return pemakaianRepository.findAll();
    }

    public Optional<Pemakaian> getPemakaianById(String kdTransaksi) {
        return pemakaianRepository.findById(kdTransaksi);
    }

    public Pemakaian savePemakaian(Pemakaian pemakaian) {
        
        return pemakaianRepository.save(pemakaian);
    }

    public void deletePemakaian(String kdTransaksi) {
        pemakaianRepository.deleteById(kdTransaksi);
    }

    public Pemakaian updatePemakaian(String kdTransaksi, Pemakaian pemakaianDetails) {
        Pemakaian pemakaian = pemakaianRepository.findById(kdTransaksi)
                .orElseThrow(() -> new RuntimeException("Pemakaian tidak ditemukan: " + kdTransaksi));

        pemakaian.setKdTransaksi(kdTransaksi);
        pemakaian.setPelanggan(pemakaianDetails.getPelanggan());
        pemakaian.setMeterBulanIni(pemakaianDetails.getMeterBulanIni());
        pemakaian.setMeterBulanLalu(pemakaianDetails.getMeterBulanLalu());
        pemakaian.setTarifPermeter(pemakaianDetails.getTarifPermeter());

        return pemakaianRepository.save(pemakaian);
    }
}