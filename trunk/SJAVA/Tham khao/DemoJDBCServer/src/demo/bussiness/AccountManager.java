/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.bussiness;

import demo.data.AccountDA;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;

/**
 *
 * @author tunn
 */
public class AccountManager {
    AccountDA da=new AccountDA();
    public void update(Account obj) {
        da.update(obj.getUsername(), obj.getPassword());
    }

    public Account getAccountByName(String name) {
        try {
            RowSet rs = da.getAccountByName2(name);
            if(rs!=null) {
                Account temp = null;
                if(rs.next()) {
                    String sname=rs.getString("username");
                    String spass=rs.getString("password");

                    temp=new Account(sname,spass);
                }
                return temp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Account obj) {

    }

    public void delete(Account obj) {
        
    }
}
