package com.abdhu.pemakaian_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pemakaian {
    @Id
    private String kdTransaksi;
    private String pelanggan;
    private Double meterBulanIni;
    private Double meterBulanLalu;
    private Double pemakaian;
    private Double tarifPermeter;
    private Double total;

    public void calculatePemakaian() {
        this.pemakaian = this.meterBulanIni - this.meterBulanLalu;
    }

    public void calculateTotal() {
        this.total = this.pemakaian * this.tarifPermeter;
    }

    
    public void setMeterBulanIni(Double meterBulanIni) {
        this.meterBulanIni = meterBulanIni;
        if (this.meterBulanLalu != null) {
            calculatePemakaian();
            if (this.tarifPermeter != null) {
                calculateTotal();
            }
        }
    }

    public void setMeterBulanLalu(Double meterBulanLalu) {
        this.meterBulanLalu = meterBulanLalu;
        if (this.meterBulanIni != null) {
            calculatePemakaian();
            if (this.tarifPermeter != null) {
                calculateTotal();
            }
        }
    }

    public void setTarifPermeter(Double tarifPermeter) {
        this.tarifPermeter = tarifPermeter;
        if (this.pemakaian != null) {
            calculateTotal();
        }
    }

    // @Override
    // public String toString() {
    //     return "Peminjaman{" +
    //             "id=" + id +
    //             ", anggotaId=" + anggotaId +
    //             ", bukuId=" + bukuId +
    //             ", tanggal_pinjam=" + tanggal_pinjam +
    //             ", tanggal_kembali=" + tanggal_kembali +
    //             ", status=" + status +
    //             '}';
    // }

}