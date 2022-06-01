/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

import responsi.Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author HP
 */
public class Controller {
     ModelTransaksi modelTransaksi;
    ViewTransaksi viewTransaksi ;
    
    Controller(ViewTransaksi viewTransaksi, ModelTransaksi modelTransaksi) {
    this.modelTransaksi = modelTransaksi;
    this.viewTransaksi = viewTransaksi;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(modelTransaksi.getBanyakData() != 0){
            String data[][] = modelTransaksi.readData();
            viewTransaksi.tabel.setModel((new JTable(data, viewTransaksi.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada / Kosong");
        }
    
    //aksi ketika menekan tombol tambah
    viewTransaksi.btnTambah.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String idTrans = viewTransaksi.getFidTrans().getText();
        String namaBarang = viewTransaksi.getFnamaBarang().getText();
        String namaKasir = viewTransaksi.getFnamaKasir().getText();
        int qty = Integer.parseInt(viewTransaksi.getFqty().getText());
        int harga = Integer.parseInt(viewTransaksi.getFharga().getText());
        int diskon = Integer.parseInt(viewTransaksi.getFdiskon().getText());
        double total = (qty*harga)-(qty*harga*(diskon*0.01));
        if (idTrans.equals("")||namaBarang.equals("")||namaKasir.equals("")||qty==0||harga==0) {
            JOptionPane.showMessageDialog(viewTransaksi, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelTransaksi.tambahData(idTrans,namaBarang,namaKasir,qty,harga,diskon,total);
            viewTransaksi.dispose();
            MVC mvc = new MVC();
            mvc.menu();
        }
        }
    });
    
    //aksi ketika menekan tombol update
    viewTransaksi.btnUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String pindah = viewTransaksi.pindah;
        String idTrans = viewTransaksi.getFidTrans().getText();
        String namaBarang = viewTransaksi.getFnamaBarang().getText();
        String namaKasir = viewTransaksi.getFnamaKasir().getText();
        int qty = Integer.parseInt(viewTransaksi.getFqty().getText());
        int harga = Integer.parseInt(viewTransaksi.getFharga().getText());
        int diskon = Integer.parseInt(viewTransaksi.getFdiskon().getText()); 
        double total = (qty*harga)-(qty*harga*(diskon*0.01));
        if (idTrans.equals("")||namaBarang.equals("")||namaKasir.equals("")||qty==0||harga==0) {
            JOptionPane.showMessageDialog(viewTransaksi, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelTransaksi.updateData(idTrans,namaBarang,namaKasir,qty,harga,diskon,total,pindah);
            viewTransaksi.dispose();
            MVC mvc = new MVC();
            mvc.menu();
        }
        }
    });
    
    //aksi ketika menekan tombol delete
    viewTransaksi.btnDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String idTrans = viewTransaksi.getFidTrans().getText();

        if (idTrans.equals("")) {
            JOptionPane.showMessageDialog(viewTransaksi, "Isi ID Transaksi Yang Akan Dihapus");
        }else {
            modelTransaksi.deleteData(idTrans);
            viewTransaksi.dispose();
            MVC mvc = new MVC();
            mvc.menu();
        }
        }
    });
    
    //aksi ketika menekan tombol clear
     viewTransaksi.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTransaksi.fidTrans.setText("");
                viewTransaksi.fnamaBarang.setText("");
                viewTransaksi.fnamaKasir.setText("");
                viewTransaksi.fqty.setText("");
                viewTransaksi.fharga.setText("");
                viewTransaksi.fdiskon.setText("");
            }
        });
    }
}
