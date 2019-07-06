/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.stta.bahrie.entiy;

import java.io.Serializable;

/**
 *
 * @author bahrie
 */
public class Dosen implements Serializable{

    
    private String kd_dosen;
    private String dosen;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getKd_dosen() {
        return kd_dosen;
    }

    public void setKd_dosen(String kd_dosen) {
        this.kd_dosen = kd_dosen;
    }
}
