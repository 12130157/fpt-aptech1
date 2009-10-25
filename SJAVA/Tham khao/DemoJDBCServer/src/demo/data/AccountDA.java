/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.data;

import com.sun.rowset.WebRowSetImpl;
import demojdbcserver.LoginServiceImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author tunn
 */
public class AccountDA {
    public void update(String name,String pass) {

    }

    public ResultSet getAccountByName(String name) throws SQLException {
        Connection  cn = null;
        try {
            //
            Class.forName("com.mysql.jdbc.Driver");

            String connStr="jdbc:mysql://localhost:3306/mydata";

            cn = DriverManager.getConnection(connStr, "frun", "frun");

            Statement st=cn.createStatement();

            String sql="select username,password from Account where username='"+name+"'";

            ResultSet rs=st.executeQuery(sql);

            if(rs!=null&&rs.next()) {
                return rs;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //if(cn!=null)
            //cn.close();
        }
        return null;
    }

    public RowSet getAccountByName2(String name) throws SQLException {
        Connection  cn = null;
        try {
            //
            Class.forName("com.mysql.jdbc.Driver");

            String connStr="jdbc:mysql://localhost:3306/mydata";

            cn = DriverManager.getConnection(connStr, "frun", "frun");

            Statement st=cn.createStatement();

            String sql="select username,password from Account where username='"+name+"'";

            ResultSet rs=st.executeQuery(sql);

            WebRowSet rowset=new WebRowSetImpl();

            if(rs!=null) {
                rowset.populate(rs);
                return rowset;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cn!=null)
            cn.close();
        }
        return null;
    }
}
