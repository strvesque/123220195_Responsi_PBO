/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Mahasiswa.InputDataMhs;
import View.Mahasiswa.EditDataMhs;
import View.Mahasiswa.ViewDataMhs;
import Model.Mahasiswa.*;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Lab Informatika
 */
public class ControllerMahasiswa {
    ViewDataMhs halamanTable;
    InputDataMhs halamanInput;
    EditDataMhs halamanEdit;

    InterfaceDAOMahasiswa daoMahasiswa;

    List<ModelMahasiswa> daftarMahasiswa;
    
    public ControllerMahasiswa(ViewDataMhs halamanTable) {
        this.halamanTable = halamanTable;
        this.daoMahasiswa = new DAOMahasiswa();
    }
    
    public ControllerMahasiswa(InputDataMhs halamanInput) {
        this.halamanInput = halamanInput;
        this.daoMahasiswa = new DAOMahasiswa();
    }
    
    public ControllerMahasiswa(EditDataMhs halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoMahasiswa = new DAOMahasiswa();
    }

    public void showAllMahasiswa() {
    
        daftarMahasiswa = daoMahasiswa.getAll();

        ModelTableMahasiswa table = new ModelTableMahasiswa(daftarMahasiswa);

        halamanTable.getTableMahasiswa().setModel(table);
    }

    public void insertMahasiswa() {
        try {
       
            ModelMahasiswa mahasiswaBaru = new ModelMahasiswa();
            String nama = halamanInput.getInputNama();
            String nim = halamanInput.getInputNIM();
            String angkatan = halamanInput.getInputAngkatan();

            if ("".equals(nama) || "".equals(nim) || "".equals(angkatan)) {
                throw new Exception("Nama, NIM, dan Angkatan tidak boleh kosong!");
            }
     
            mahasiswaBaru.setNama(nama);
            mahasiswaBaru.setNim(nim);
            mahasiswaBaru.setAngkatan(angkatan);
        
            daoMahasiswa.insert(mahasiswaBaru);
        
            JOptionPane.showMessageDialog(null, "Mahasiswa baru berhasil ditambahkan.");
        
            halamanInput.dispose();
            new ViewDataMhs();
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editMahasiswa(int id) {
        try {
        
            ModelMahasiswa mahasiswaYangMauDiedit = new ModelMahasiswa();
            String nama = halamanEdit.getInputNama();
            String nim = halamanEdit.getInputNIM();
            String angkatan = halamanEdit.getInputAngkatan();

            if ("".equals(nama) || "".equals(nim) || "".equals(angkatan)) {
                throw new Exception("Nama, NIM, dan Angkatan tidak boleh kosong!");
            }
        
            mahasiswaYangMauDiedit.setId(id);
            mahasiswaYangMauDiedit.setNama(nama);
            mahasiswaYangMauDiedit.setNim(nim);
            mahasiswaYangMauDiedit.setAngkatan(angkatan);
        
            daoMahasiswa.update(mahasiswaYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil diubah.");

            halamanEdit.dispose();
            new ViewDataMhs();
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(Integer baris) {
    
        Integer id = (int) halamanTable.getTableMahasiswa().getValueAt(baris, 0);
        String nama = halamanTable.getTableMahasiswa().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Mahasiswa",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
    
            daoMahasiswa.delete(id);
    
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllMahasiswa();
        }
    }
}
