package modelosReserva;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResDao {

 private static Connection con = null;
 public static int save(Res r) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("insert into reserva(id,fecha_inicio,fecha_fin,nombre_cliente,tipo_habitacion,num_habitacion,dias,valor_total) values (?,?,?,?,?,?,?,?)");
   ps.setInt(1, r.getId());
   ps.setString(2, r.getFecha_inicio());
   ps.setString(3, r.getFecha_fin());
   ps.setString(4, r.getNombre_cliente());
   ps.setString(5, r.getTipo_habitacion());
   ps.setInt(6, r.getNum_habitacion());
   ps.setInt(7, r.getDias());
   ps.setInt(8, r.getValor_total());
    

   status = ps.executeUpdate();

   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return status;
 }

 public static int update(Res r) {
  int status = 0;
  try {
   con = DataBase.getDBConnection();
   
   PreparedStatement ps = con.prepareStatement("update reserva set fecha_inicio=?,fecha_fin=?,nombre_cliente=?,tipo_habitacion=?,num_habitacion=?,dias=?,valor_total=? where id=?");
   ps.setString(1, r.getFecha_inicio());
   ps.setString(2, r.getFecha_fin());
   ps.setString(3, r.getNombre_cliente());
   ps.setString(4, r.getTipo_habitacion());
   ps.setInt(5, r.getNum_habitacion());
   ps.setInt(6, r.getDias());
   ps.setInt(7, r.getValor_total());
   ps.setInt(8, r.getId());
   
   
   
   
   
   

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
   PreparedStatement ps = con.prepareStatement("delete from Reserva where id=?");
   ps.setInt(1, id);
   status = ps.executeUpdate();

   con.close();
  } catch (Exception e) {
   e.printStackTrace();
  }

  return status;
 }

 public static Res getReservaById(int id) {
  Res r = new Res();

  try {
   con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("select * from Reserva where id=?");
   ps.setInt(1, id);
   ResultSet rs = ps.executeQuery();
   if (rs.next()) {
     r.setId(rs.getInt(1));
     r.setFecha_inicio(rs.getString(2));
     r.setFecha_fin(rs.getString(3));
     r.setNombre_cliente(rs.getString(4));
     r.setTipo_habitacion(rs.getString(5));
     r.setNum_habitacion(rs.getInt(6));
     r.setDias(rs.getInt(7));
     r.setValor_total(rs.getInt(8));
 
   }
   con.close();
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return r;
 }

 public static List<Res> getAllReservas() {
  List<Res> list = new ArrayList<Res>();

  try {
   Connection con = DataBase.getDBConnection();
   PreparedStatement ps = con.prepareStatement("select * from reserva");
   ResultSet rs = ps.executeQuery();
   while (rs.next()) {
    Res r = new Res();
   r.setId(rs.getInt(1));
     r.setFecha_inicio(rs.getString(2));
     r.setFecha_fin(rs.getString(3));
     r.setNombre_cliente(rs.getString(4));
     r.setTipo_habitacion(rs.getString(5));
     r.setNum_habitacion(rs.getInt(6));
     r.setDias(rs.getInt(7));
     r.setValor_total(rs.getInt(8));
    
  
    list.add(r);
   }
   con.close();
  } catch (Exception e) {
   e.printStackTrace();
  }

  return list;
 }

 public static void main(String[] args) {
  System.out.println(ResDao.getAllReservas());

 }
}
