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
public class Mk implements Serializable {

    private String kd_mk;
    private String mk;
    private int sks;
    private String jurusan;
    private String kd_dosen;
    private Dosen dosen;

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKd_dosen() {
        return kd_dosen;
    }

    public void setKd_dosen(String kd_dosen) {
        this.kd_dosen = kd_dosen;
    }

    public String getKd_mk() {
        return kd_mk;
    }

    public void setKd_mk(String kd_mk) {
        this.kd_mk = kd_mk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
