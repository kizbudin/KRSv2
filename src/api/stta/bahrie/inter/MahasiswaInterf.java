/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package api.stta.bahrie.inter;

import api.stta.bahrie.entiy.Mahasiswa;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author bahrie
 */
public interface MahasiswaInterf extends Remote{

    Mahasiswa insert(Mahasiswa o) throws RemoteException;

    void update(Mahasiswa o)throws RemoteException;

    void delete(String nim) throws RemoteException;

    Mahasiswa getByNim(String nim)throws RemoteException;

    List<Mahasiswa> getAll() throws RemoteException;

    void insertJmlhKrs(int jmlh,String nim) throws RemoteException;

    List<Mahasiswa> getByDosen(String dosen) throws RemoteException;

    Mahasiswa getByProdi(String prodi) throws RemoteException;

}
