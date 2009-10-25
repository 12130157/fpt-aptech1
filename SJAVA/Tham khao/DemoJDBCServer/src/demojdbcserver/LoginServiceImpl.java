/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demojdbcserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tunn
 */
public class LoginServiceImpl extends UnicastRemoteObject implements LoginService{

    public LoginServiceImpl() throws RemoteException{
        super();
    }

    public String login(String name, String pass) throws RemoteException {
        try {
            return connectToJDBC(name, pass);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String connectToJDBC(String name, String pass) throws SQLException {
        String sname=null;
        Connection  cn = null;
        try {
            //
            Class.forName("com.mysql.jdbc.Driver");

            String connStr="jdbc:mysql://localhost:3306/mydata";

            cn = DriverManager.getConnection(connStr, "frun", "frun");

            Statement st=cn.createStatement();

            String sql="select username,password from Account where username='"+name+"' and password='"+pass+"'";

            ResultSet rs=st.executeQuery(sql);

            if(rs!=null&&rs.next()) {
                sname=rs.getString("username");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn!=null)
            cn.close();
        }
        return sname;
    }

}
