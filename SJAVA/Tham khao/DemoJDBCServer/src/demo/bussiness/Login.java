/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.bussiness;

/**
 *
 * @author tunn
 */
public class Login {
    private AccountManager manager=new AccountManager();
    public boolean login(Account obj) {
        return false;
    }
    public boolean login(String name,String pass) {
        Account a=manager.getAccountByName(name);
        if(a!=null&&a.getPassword().equals(pass)) {
            return true;
        }
        return false;
    }
}
