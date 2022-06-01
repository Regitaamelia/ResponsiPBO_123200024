/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class ViewTransaksi extends JFrame {
    String pindah;
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","NAMA BARANG","NAMA KASIR","QUANTITY","HARGA SATUAN","DISKON","HARGA TOTAL"}; //membuat kolom dgn array tipe object;
    final JTextField fidTrans = new JTextField();
    final JTextField fnamaBarang = new JTextField();
    final JTextField fnamaKasir = new JTextField();
    final JTextField fqty = new JTextField();
    final JTextField fharga = new JTextField();
    final JTextField fdiskon = new JTextField();
   
    JLabel lidTrans= new JLabel("Input Id Transaksi");
    JLabel lnamaBarang = new JLabel("Nama Barang");
    JLabel lnamaKasir = new JLabel("Nama Kasir");
    JLabel lqty = new JLabel("Quantity");
    JLabel lharga = new JLabel("Harga Satuan");
    JLabel ldiskon = new JLabel("Diskon");
    
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    
    public ViewTransaksi() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(1100,600);
        setVisible(true);
        setResizable(false);
        setTitle("Menu Transaksi");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lidTrans);
        add(fidTrans);
        add(lnamaBarang);
        add(fnamaBarang);
        add(lnamaKasir);
        add(fnamaKasir);
        add(lqty);
        add(fqty);
        add(lharga);
        add(fharga);
        add(ldiskon);
        add(fdiskon);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);

        scrollPane.setBounds(20, 35, 700, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lidTrans.setBounds(750, 35, 120, 20);
        fidTrans.setBounds(750, 60, 170, 20);
        lnamaBarang.setBounds(750, 90, 120, 20);
        fnamaBarang.setBounds(750, 115, 170, 20);
        lnamaKasir.setBounds(750, 145, 120, 20);
        fnamaKasir.setBounds(750, 170, 170, 20);
        lqty.setBounds(750, 200, 120, 20);
        fqty.setBounds(750, 225, 170, 20);
        lharga.setBounds(750, 255, 120, 20);
        fharga.setBounds(750, 280, 170, 20);
        ldiskon.setBounds(750, 310, 120, 20);
        fdiskon.setBounds(750, 335, 170, 20);
  
        btnTambah.setBounds(750, 400, 80, 20);
        btnUpdate.setBounds(750, 430, 80, 20);
        btnDelete.setBounds(850, 400, 80, 20);
        btnClear.setBounds(850, 430, 80, 20);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //mengambil data dari tabel yang di klik
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                pindah =tabel.getValueAt(baris, 0).toString();
                fidTrans.setText(tabel.getValueAt(baris, 0).toString());
                fnamaBarang.setText(tabel.getValueAt(baris, 1).toString());
                fnamaKasir.setText( tabel.getValueAt(baris, 2).toString());
                fqty.setText(tabel.getValueAt(baris, 3).toString());
                fharga.setText(tabel.getValueAt(baris, 4).toString()); 
                fdiskon.setText(tabel.getValueAt(baris, 5).toString());
            }
        });
    }
    
    public JTextField getFidTrans() {
        return fidTrans;
    }
    public JTextField getFnamaBarang() {
        return fnamaBarang;
    }
    public JTextField getFnamaKasir() {
        return fnamaKasir;
    }
    public JTextField getFqty() {
        return fqty;
    }
    public JTextField getFharga() {
        return fharga;
    }
    public JTextField getFdiskon() {
        return fdiskon;
    }
}
