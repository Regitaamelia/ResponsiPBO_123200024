/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class ModelTransaksi {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from transactions"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //menghitung banyak baris yang ada di database
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        return jmlData;
    }
    
    public String[][] readData(){ //dua dimensi baris-kolom
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya
            String data[][] = new String[getBanyakData()][7]; // nemampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `transactions`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);// result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("id_trans"); // Harus sesuai database
                data[jmlData][1] = resultSet.getString("nama_barang"); // Harus sesuai database
                data[jmlData][2] = resultSet.getString("nama_kasir"); // Harus sesuai database
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahData(String idTrans,String namaBarang,String namaKasir,int qty,int harga,int diskon,double total){
        
         try {
            String query = "INSERT INTO transactions VALUES ('"+idTrans+"','"+namaBarang+"','"+namaKasir+"','"+qty+"','"+harga+"','"+diskon+"','"+total+"')";  
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Data Berhasil Ditambahkan !!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Data Sudah Ada !!");
        }
    }
    
    public void updateData(String idTrans,String namaBarang,String namaKasir,int qty,int harga,int diskon,double total,String pindah){
            
        try {
            String query = "update transactions set id_trans=?, "
                    + "nama_barang=?, nama_kasir=?, qty=?, price_per_qty=?, discount=?, price_total=? where id_trans=?";
            PreparedStatement preparedStmt = connector.koneksi.prepareStatement(query);
            preparedStmt.setString(1, idTrans);
            preparedStmt.setString(2, namaBarang);
            preparedStmt.setString(3, namaKasir);
            preparedStmt.setInt(4, qty);
            preparedStmt.setInt(5, harga);
            preparedStmt.setInt(6, diskon);
            preparedStmt.setDouble(7, total);
            preparedStmt.setString(8, pindah);
            preparedStmt.execute();
            
           if(pindah.compareTo(idTrans)==0)
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate !!");
            else
                JOptionPane.showMessageDialog(null,"Data Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String idTrans){
        try{
            String query = "DELETE from transactions WHERE id_trans = '"+idTrans+"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}
