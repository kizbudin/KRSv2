/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package api.stta.bahrie.inter;

import api.stta.bahrie.entiy.DetailKrs;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author bahrie
 */
public interface DetailKrsInterf extends Remote{

    DetailKrs insert(DetailKrs o) throws RemoteException;

    void update(DetailKrs o)throws RemoteException;

    void delete(String nim) throws RemoteException;

    List<DetailKrs> getByNim(String nim)throws RemoteException;

    List<DetailKrs> getAll() throws RemoteException;

}
