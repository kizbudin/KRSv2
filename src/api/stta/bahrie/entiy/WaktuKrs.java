/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.stta.bahrie.entiy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bahrie
 */
public class WaktuKrs implements Serializable {

    private String id_wktu;
    private String nim;
    private String semester;
    private String ta;
    private Date tanggal_pengisian;
    private List<DetailKrs> detailKrs = new ArrayList<DetailKrs>();

    public List<DetailKrs> getDetailKrs() {
        return detailKrs;
    }

    public void setDetailKrs(List<DetailKrs> detailKrs) {
        this.detailKrs = detailKrs;
    }

    public String getId_wktu() {
        return id_wktu;
    }

    public void setId_wktu(String id_wktu) {
        this.id_wktu = id_wktu;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public Date getTanggal_pengisian() {
        return tanggal_pengisian;
    }

    public void setTanggal_pengisian(Date tanggal_pengisian) {
        this.tanggal_pengisian = tanggal_pengisian;
    }
}
