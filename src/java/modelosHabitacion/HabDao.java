package modelosHabitacion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HabDao {

 private static Connection con = null;
 public static int save(Hab h) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("insert into habitacion(id,tipo,nro,precio,estado) values (?,?,?,?,?)");
   ps.setInt(1, h.getId());
   ps.setString(2, h.getTipo());
   ps.setInt(3, h.getNro());
   ps.setInt(4, h.getPrecio());
    ps.setString(5, h.getEstado());

   status = ps.executeUpdate();

   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return status;
 }

 public static int update(Hab h) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   
   PreparedStatement ps = con.prepareStatement("update habitacion set tipo=?,nro=?,precio=?, estado=? where id=?");
   ps.setString(1, h.getTipo());
   ps.setInt(2, h.getNro());
   ps.setInt(3, h.getPrecio());
   ps.setString(4, h.getEstado());
   ps.setInt(5, h.getId());
   
   
   
   
   

   status = ps.executeUpdate();

   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return status;
 }

 public static int delete(int id) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("delete from habitacion where id=?");
   ps.setInt(1, id);
   status = ps.executeUpdate();

   con.close();
  } catch (Exception e) {
   e.printStackTrace();
  }

  return status;
 }

 public static Hab getHabitacionById(int id) {
  Hab h = new Hab();

  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("select * from habitacion where id=?");
   ps.setInt(1, id);
   ResultSet rs = ps.executeQuery();
   if (rs.next()) {
     h.setId(rs.getInt(1));
    h.setTipo(rs.getString(2));
    h.setNro(rs.getInt(3));
    h.setPrecio(rs.getInt(4));
    h.setEstado(rs.getString(5));
    
   }
   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return h;
 }

 public static List<Hab> getAllHabitaciones() {
  List<Hab> list = new ArrayList<Hab>();

  try {
   Connection con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("select * from habitacion");
   ResultSet rs = ps.executeQuery();
   while (rs.next()) {
    Hab h = new Hab();
    h.setId(rs.getInt(1));
    h.setTipo(rs.getString(2));
    h.setNro(rs.getInt(3));
    h.setPrecio(rs.getInt(4));
     h.setEstado(rs.getString(5));
    
  
    list.add(h);
   }
   con.close();
  } catch (Exception e) {
   e.printStackTrace();
  }

  return list;
 }

 public static void main(String[] args) {
  System.out.println(HabDao.getAllHabitaciones());

 }
}
