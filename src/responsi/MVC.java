/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

/**
 *
 * @author HP
 */
public class MVC {
    public void menu() {
        ViewTransaksi viewTransaksi = new ViewTransaksi();
        ModelTransaksi modelTransaksi = new ModelTransaksi();
        Controller controller = new Controller(viewTransaksi,modelTransaksi);
    }
}
