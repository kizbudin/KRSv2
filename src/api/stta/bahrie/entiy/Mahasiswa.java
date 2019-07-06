/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.stta.bahrie.entiy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bahrie
 */
public class Mahasiswa implements Serializable {

    private String nim;
    private String nama;
    private String prodi;
    private String kd_dosen;
    private int jumlah_krs;
    private String pwd;
    private Dosen dosen;
    

   


    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getJumlah_krs() {
        return jumlah_krs;
    }

    public void setJumlah_krs(int jumlah_krs) {
        this.jumlah_krs = jumlah_krs;
    }

    public String getKd_dosen() {
        return kd_dosen;
    }

    public void setKd_dosen(String kd_dosen) {
        this.kd_dosen = kd_dosen;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}
