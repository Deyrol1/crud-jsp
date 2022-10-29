package modelosUsuario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

 private static Connection con = null;
 public static int save(Emp e) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("insert into usuario(cedula,nombre,cargo) values (?,?,?)");
   ps.setInt(1, e.getCedula());
   ps.setString(2, e.getNombre());
   ps.setString(3, e.getCargo());

   status = ps.executeUpdate();

   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return status;
 }

 public static int update(Emp e) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   
   PreparedStatement ps = con.prepareStatement("update usuario set nombre=?,cargo=? where cedula=?");
   ps.setString(1, e.getNombre());
   ps.setString(2, e.getCargo());
   ps.setInt(3, e.getCedula());
   
   
   
   

   status = ps.executeUpdate();

   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return status;
 }

 public static int delete(int cedula) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("delete from usuario where cedula=?");
   ps.setInt(1, cedula);
   status = ps.executeUpdate();

   con.close();
  } catch (Exception e) {
   e.printStackTrace();
  }

  return status;
 }

 public static Emp getEmployeeByCedula(int cedula) {
  Emp e = new Emp();

  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("select * from usuario where cedula=?");
   ps.setInt(1, cedula);
   ResultSet rs = ps.executeQuery();
   if (rs.next()) {
    e.setCedula(rs.getInt(1));
    e.setNombre(rs.getString(2));
    e.setCargo(rs.getString(3));
   }
   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return e;
 }

 public static List<Emp> getAllEmployees() {
  List<Emp> list = new ArrayList<Emp>();

  try {
   Connection con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("select * from usuario");
   ResultSet rs = ps.executeQuery();
   while (rs.next()) {
    Emp e = new Emp();
    e.setCedula(rs.getInt(1));
    e.setNombre(rs.getString(2));
    e.setCargo(rs.getString(3));
  
    list.add(e);
   }
   con.close();
  } catch (Exception e) {
   e.printStackTrace();
  }

  return list;
 }

 public static void main(String[] args) {
  System.out.println(EmpDao.getAllEmployees());

 }
}
