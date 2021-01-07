

package keuangan;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariPetugas;

/**
 *
 * @author perpustakaan
 */
public final class KeuanganRVPBPJS extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int row=0,i;
    private String koderekening="",norawatbayi="";
    private Jurnal jur=new Jurnal();
    private String status="",tampilkan_administrasi_di_billingranap="",tampilkan_ppnobat_ralan="",tampilkan_ppnobat_ranap="",
                   Piutang_BPJS_RVP="",Kerugian_Klaim_BPJS_RVP="",Lebih_Bayar_Klaim_BPJS_RVP="",Tindakan_Ralan="",Beban_Jasa_Medik_Dokter_Tindakan_Ralan="",
                   Utang_Jasa_Medik_Dokter_Tindakan_Ralan="",Beban_Jasa_Medik_Paramedis_Tindakan_Ralan="",Utang_Jasa_Medik_Paramedis_Tindakan_Ralan="",
                   Beban_KSO_Tindakan_Ralan="",Utang_KSO_Tindakan_Ralan="",Beban_Jasa_Sarana_Tindakan_Ralan="",Utang_Jasa_Sarana_Tindakan_Ralan="",
                   HPP_BHP_Tindakan_Ralan="",Persediaan_BHP_Tindakan_Ralan="",Beban_Jasa_Menejemen_Tindakan_Ralan="",Utang_Jasa_Menejemen_Tindakan_Ralan="",
                   Laborat_Ralan="",Beban_Jasa_Medik_Dokter_Laborat_Ralan="",Utang_Jasa_Medik_Dokter_Laborat_Ralan="",Beban_Jasa_Medik_Petugas_Laborat_Ralan="",
                   Utang_Jasa_Medik_Petugas_Laborat_Ralan="",Beban_Kso_Laborat_Ralan="",Utang_Kso_Laborat_Ralan="",HPP_Persediaan_Laborat_Rawat_Jalan="",
                   Persediaan_BHP_Laborat_Rawat_Jalan="",Beban_Jasa_Sarana_Laborat_Ralan="",Utang_Jasa_Sarana_Laborat_Ralan="",Beban_Jasa_Perujuk_Laborat_Ralan="",
                   Utang_Jasa_Perujuk_Laborat_Ralan="",Beban_Jasa_Menejemen_Laborat_Ralan="",Utang_Jasa_Menejemen_Laborat_Ralan="",Radiologi_Ralan="",
                   Beban_Jasa_Medik_Dokter_Radiologi_Ralan="",Utang_Jasa_Medik_Dokter_Radiologi_Ralan="",Beban_Jasa_Medik_Petugas_Radiologi_Ralan="",
                   Utang_Jasa_Medik_Petugas_Radiologi_Ralan="",Beban_Kso_Radiologi_Ralan="",Utang_Kso_Radiologi_Ralan="",HPP_Persediaan_Radiologi_Rawat_Jalan="",
                   Persediaan_BHP_Radiologi_Rawat_Jalan="",Beban_Jasa_Sarana_Radiologi_Ralan="",Utang_Jasa_Sarana_Radiologi_Ralan="",Beban_Jasa_Perujuk_Radiologi_Ralan="",
                   Utang_Jasa_Perujuk_Radiologi_Ralan="",Beban_Jasa_Menejemen_Radiologi_Ralan="",Utang_Jasa_Menejemen_Radiologi_Ralan="",Obat_Ralan="",
                   HPP_Obat_Rawat_Jalan="",Persediaan_Obat_Rawat_Jalan="",Registrasi_Ralan="",Operasi_Ralan="",Beban_Jasa_Medik_Dokter_Operasi_Ralan="",
                   Utang_Jasa_Medik_Dokter_Operasi_Ralan="",Beban_Jasa_Medik_Paramedis_Operasi_Ralan="",Utang_Jasa_Medik_Paramedis_Operasi_Ralan="",
                   HPP_Obat_Operasi_Ralan="",Persediaan_Obat_Kamar_Operasi_Ralan="",Tambahan_Ralan="",Potongan_Ralan="",Tindakan_Ranap="",
                   Beban_Jasa_Medik_Dokter_Tindakan_Ranap="",Utang_Jasa_Medik_Dokter_Tindakan_Ranap="",Beban_Jasa_Medik_Paramedis_Tindakan_Ranap="",
                   Utang_Jasa_Medik_Paramedis_Tindakan_Ranap="",Beban_KSO_Tindakan_Ranap="",Utang_KSO_Tindakan_Ranap="",Beban_Jasa_Sarana_Tindakan_Ranap="",
                   Utang_Jasa_Sarana_Tindakan_Ranap="",Beban_Jasa_Menejemen_Tindakan_Ranap="",Utang_Jasa_Menejemen_Tindakan_Ranap="",HPP_BHP_Tindakan_Ranap="",
                   Persediaan_BHP_Tindakan_Ranap="",Laborat_Ranap="",Beban_Jasa_Medik_Dokter_Laborat_Ranap="",Utang_Jasa_Medik_Dokter_Laborat_Ranap="",
                   Beban_Jasa_Medik_Petugas_Laborat_Ranap="",Utang_Jasa_Medik_Petugas_Laborat_Ranap="",Beban_Kso_Laborat_Ranap="",Utang_Kso_Laborat_Ranap="",
                   HPP_Persediaan_Laborat_Rawat_inap="",Persediaan_BHP_Laborat_Rawat_Inap="",Beban_Jasa_Sarana_Laborat_Ranap="",Utang_Jasa_Sarana_Laborat_Ranap="",
                   Beban_Jasa_Perujuk_Laborat_Ranap="",Utang_Jasa_Perujuk_Laborat_Ranap="",Beban_Jasa_Menejemen_Laborat_Ranap="",Utang_Jasa_Menejemen_Laborat_Ranap="",
                   Radiologi_Ranap="",Beban_Jasa_Medik_Dokter_Radiologi_Ranap="",Utang_Jasa_Medik_Dokter_Radiologi_Ranap="",Beban_Jasa_Medik_Petugas_Radiologi_Ranap="",
                   Utang_Jasa_Medik_Petugas_Radiologi_Ranap="",Beban_Kso_Radiologi_Ranap="",Utang_Kso_Radiologi_Ranap="",HPP_Persediaan_Radiologi_Rawat_Inap="",
                   Persediaan_BHP_Radiologi_Rawat_Inap="",Beban_Jasa_Sarana_Radiologi_Ranap="",Utang_Jasa_Sarana_Radiologi_Ranap="",Beban_Jasa_Perujuk_Radiologi_Ranap="",
                   Utang_Jasa_Perujuk_Radiologi_Ranap="",Beban_Jasa_Menejemen_Radiologi_Ranap="",Utang_Jasa_Menejemen_Radiologi_Ranap="",Obat_Ranap="",
                   HPP_Obat_Rawat_Inap="",Persediaan_Obat_Rawat_Inap="",Registrasi_Ranap="",Service_Ranap="",Tambahan_Ranap="",Potongan_Ranap="",
                   Retur_Obat_Ranap="",Resep_Pulang_Ranap="",Kamar_Inap="",Operasi_Ranap="",Beban_Jasa_Medik_Dokter_Operasi_Ranap="",Utang_Jasa_Medik_Dokter_Operasi_Ranap="",
                   Beban_Jasa_Medik_Paramedis_Operasi_Ranap="",Utang_Jasa_Medik_Paramedis_Operasi_Ranap="",HPP_Obat_Operasi_Ranap="",Persediaan_Obat_Kamar_Operasi_Ranap="",
                   Harian_Ranap="";
    private double total=0,sisapiutang=0,cicilan=0,rugi=0,lebih=0,selisih=0,materialralan=0,bhpralan=0,tarif_tindakandrralan=0,tarif_tindakanprralan=0,ksoralan=0,menejemenralan=0,biaya_rawatralan=0,
                   materialranap=0,bhpranap=0,tarif_tindakandrranap=0,tarif_tindakanprranap=0,ksoranap=0,menejemenranap=0,biaya_rawatranap=0,bagian_rslabralan=0,bhplabralan=0,tarif_perujuklabralan=0,
                   tarif_tindakan_dokterlabralan=0,tarif_tindakan_petugaslabralan=0,ksolabralan=0,menejemenlabralan=0,biayalabralan=0,bagian_rslabranap=0,bhplabranap=0,tarif_perujuklabranap=0,
                   tarif_tindakan_dokterlabranap=0,tarif_tindakan_petugaslabranap=0,ksolabranap=0,menejemenlabranap=0,biayalabranap=0,bagian_rsradiologiralan=0,bhpradiologiralan=0,tarif_perujukradiologiralan=0,
                   tarif_tindakan_dokterradiologiralan=0,tarif_tindakan_petugasradiologiralan=0,ksoradiologiralan=0,menejemenradiologiralan=0,biayaradiologiralan=0,bagian_rsradiologiranap=0,bhpradiologiranap=0,
                   tarif_perujukradiologiranap=0,tarif_tindakan_dokterradiologiranap=0,tarif_tindakan_petugasradiologiranap=0,ksoradiologiranap=0,menejemenradiologiranap=0,biayaradiologiranap=0,
                   jmdokteroperasiralan=0,jmparamedisoperasiralan=0,bhpoperasiralan=0,pendapatanoperasiralan=0,jmdokteroperasiranap=0,jmparamedisoperasiranap=0,bhpoperasiranap=0,pendapatanoperasiranap=0,
                   obatlangsung=0,obatralan=0,hppobatralan=0,obatranap=0,hppobatranap=0,returobat=0,tambahanbiaya=0,potonganbiaya=0,kamar=0,reseppulang=0,totalbiaya=0,registrasi=0,harianranap=0,rugihpp=0;
    private boolean sukses=true;
    private DlgCariPetugas petugas=new DlgCariPetugas(null,false);

    /** Creates new form DlgLhtBiaya
     * @param parent
     * @param modal */
    public KeuanganRVPBPJS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(885,674);

        tabMode=new DefaultTableModel(null,new Object[]{
                "P","No.Rawat/No.tagihan","No.SEP VClaim","Tgl.Piutang","Pasien","Total Piutang","Iur/Ekses",
                "Sudah Dibayar","Sisa Piutang","Tarif InaCBG","Dibayar BPJS","% Bayar","Kerugian","Lebih Bayar",
                "Status","Registrasi","materialralan","bhpralan","tarif_tindakandrralan","tarif_tindakanprralan",
                "ksoralan","menejemenralan","biaya_rawatralan","materialranap","bhpranap","tarif_tindakandrranap",
                "tarif_tindakanprranap","ksoranap","menejemenranap","biaya_rawatranap","bagian_rslabralan","bhplabralan",
                "tarif_perujuklabralan","tarif_tindakan_dokterlabralan","tarif_tindakan_petugaslabralan","ksolabralan",
                "menejemenlabralan","biayalabralan","bagian_rslabranap","bhplabranap","tarif_perujuklabranap",
                "tarif_tindakan_dokterlabranap","tarif_tindakan_petugaslabranap","ksolabranap","menejemenlabranap",
                "biayalabranap","bagian_rsradiologiralan","bhpradiologiralan","tarif_perujukradiologiralan",
                "tarif_tindakan_dokterradiologiralan","tarif_tindakan_petugasradiologiralan","ksoradiologiralan",
                "menejemenradiologiralan","biayaradiologiralan","bagian_rsradiologiranap","bhpradiologiranap",
                "tarif_perujukradiologiranap","tarif_tindakan_dokterradiologiranap","tarif_tindakan_petugasradiologiranap",
                "ksoradiologiranap","menejemenradiologiranap","biayaradiologiranap","jmdokteroperasiralan","jmparamedisoperasiralan",
                "bhpoperasiralan","pendapatanoperasiralan","jmdokteroperasiranap","jmparamedisoperasiranap","bhpoperasiranap",
                "pendapatanoperasiranap","obatlangsung","obatralan","hppobatralan","obatranap","hppobatranap","returobat",
                "tambahanbiaya","potonganbiaya","kamar","reseppulang","harianranap","registrasi"
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if ((colIndex==10)||(colIndex==0)) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class,
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class,
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, java.lang.Double.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbBangsal.setModel(tabMode);
        //tbBangsal.setDefaultRenderer(Object.class, new WarnaTable(jPanel2.getBackground(),tbBangsal.getBackground()));
        tbBangsal.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbBangsal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 82; i++) {
            TableColumn column = tbBangsal.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(110);
            }else if(i==2){
                column.setPreferredWidth(140);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(170);
            }else if(i==5){
                column.setPreferredWidth(80);
            }else if(i==6){
                column.setPreferredWidth(70);
            }else if(i==7){
                column.setPreferredWidth(80);
            }else if(i==8){
                column.setPreferredWidth(80);
            }else if(i==9){
                column.setPreferredWidth(80);
            }else if(i==10){
                column.setPreferredWidth(80);
            }else if(i==11){
                column.setPreferredWidth(48);
            }else if(i==12){
                column.setPreferredWidth(75);
            }else if(i==13){
                column.setPreferredWidth(75);
            }else if(i==14){
                column.setPreferredWidth(40);
            }else{
                //column.setMinWidth(0);
                //column.setMaxWidth(0);
            }
        }
        tbBangsal.setDefaultRenderer(Object.class, new WarnaTable());

        TKd.setDocument(new batasInput((byte)20).getKata(TKd));
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        }  
        
        petugas.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(petugas.getTable().getSelectedRow()!= -1){                   
                    kdptg.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(),0).toString());
                    nmptg.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(),1).toString());
                }  
                kdptg.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        }); 

        try {
            ps=koneksi.prepareStatement("select * from set_nota");
            try {
                rs=ps.executeQuery();
                if(rs.next()){
                    tampilkan_administrasi_di_billingranap=rs.getString("tampilkan_administrasi_di_billingranap");
                    tampilkan_ppnobat_ralan=rs.getString("tampilkan_ppnobat_ralan");
                    tampilkan_ppnobat_ranap=rs.getString("tampilkan_ppnobat_ranap");
                }else{
                    tampilkan_administrasi_di_billingranap="No";
                    tampilkan_ppnobat_ralan="No";
                    tampilkan_ppnobat_ranap="No";
                }
            } catch (Exception e) {
                tampilkan_administrasi_di_billingranap="No";
                tampilkan_ppnobat_ralan="No";
                tampilkan_ppnobat_ranap="No";
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notif : "+e);
        }
        
        Valid.loadCombo(nama_bayar,"nama_bayar","akun_bayar");
        
        try {
            ps=koneksi.prepareStatement("select * from set_akun");
            try {
                rs=ps.executeQuery();
                while(rs.next()){
                    Piutang_BPJS_RVP=rs.getString("Piutang_BPJS_RVP");
                    Kerugian_Klaim_BPJS_RVP=rs.getString("Kerugian_Klaim_BPJS_RVP");
                    Lebih_Bayar_Klaim_BPJS_RVP=rs.getString("Lebih_Bayar_Klaim_BPJS_RVP");
                }
            } catch (Exception e) {
                System.out.println("Notif Rekening : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }   
            
            ps=koneksi.prepareStatement("select * from set_akun_ralan");
            try {
                rs=ps.executeQuery();
                while(rs.next()){
                   Tindakan_Ralan=rs.getString("Tindakan_Ralan");
                   Beban_Jasa_Medik_Dokter_Tindakan_Ralan=rs.getString("Beban_Jasa_Medik_Dokter_Tindakan_Ralan");
                   Utang_Jasa_Medik_Dokter_Tindakan_Ralan=rs.getString("Utang_Jasa_Medik_Dokter_Tindakan_Ralan");
                   Beban_Jasa_Medik_Paramedis_Tindakan_Ralan=rs.getString("Beban_Jasa_Medik_Paramedis_Tindakan_Ralan");
                   Utang_Jasa_Medik_Paramedis_Tindakan_Ralan=rs.getString("Utang_Jasa_Medik_Paramedis_Tindakan_Ralan");
                   Beban_KSO_Tindakan_Ralan=rs.getString("Beban_KSO_Tindakan_Ralan");
                   Utang_KSO_Tindakan_Ralan=rs.getString("Utang_KSO_Tindakan_Ralan");
                   Beban_Jasa_Sarana_Tindakan_Ralan=rs.getString("Beban_Jasa_Sarana_Tindakan_Ralan");
                   Utang_Jasa_Sarana_Tindakan_Ralan=rs.getString("Utang_Jasa_Sarana_Tindakan_Ralan");
                   HPP_BHP_Tindakan_Ralan=rs.getString("HPP_BHP_Tindakan_Ralan");
                   Persediaan_BHP_Tindakan_Ralan=rs.getString("Persediaan_BHP_Tindakan_Ralan");
                   Beban_Jasa_Menejemen_Tindakan_Ralan=rs.getString("Beban_Jasa_Menejemen_Tindakan_Ralan");
                   Utang_Jasa_Menejemen_Tindakan_Ralan=rs.getString("Utang_Jasa_Menejemen_Tindakan_Ralan");
                   Laborat_Ralan=rs.getString("Laborat_Ralan");
                   Beban_Jasa_Medik_Dokter_Laborat_Ralan=rs.getString("Beban_Jasa_Medik_Dokter_Laborat_Ralan");
                   Utang_Jasa_Medik_Dokter_Laborat_Ralan=rs.getString("Utang_Jasa_Medik_Dokter_Laborat_Ralan");
                   Beban_Jasa_Medik_Petugas_Laborat_Ralan=rs.getString("Beban_Jasa_Medik_Petugas_Laborat_Ralan");
                   Utang_Jasa_Medik_Petugas_Laborat_Ralan=rs.getString("Utang_Jasa_Medik_Petugas_Laborat_Ralan");
                   Beban_Kso_Laborat_Ralan=rs.getString("Beban_Kso_Laborat_Ralan");
                   Utang_Kso_Laborat_Ralan=rs.getString("Utang_Kso_Laborat_Ralan");
                   HPP_Persediaan_Laborat_Rawat_Jalan=rs.getString("HPP_Persediaan_Laborat_Rawat_Jalan");
                   Persediaan_BHP_Laborat_Rawat_Jalan=rs.getString("Persediaan_BHP_Laborat_Rawat_Jalan");
                   Beban_Jasa_Sarana_Laborat_Ralan=rs.getString("Beban_Jasa_Sarana_Laborat_Ralan");
                   Utang_Jasa_Sarana_Laborat_Ralan=rs.getString("Utang_Jasa_Sarana_Laborat_Ralan");
                   Beban_Jasa_Perujuk_Laborat_Ralan=rs.getString("Beban_Jasa_Perujuk_Laborat_Ralan");
                   Utang_Jasa_Perujuk_Laborat_Ralan=rs.getString("Utang_Jasa_Perujuk_Laborat_Ralan");
                   Beban_Jasa_Menejemen_Laborat_Ralan=rs.getString("Beban_Jasa_Menejemen_Laborat_Ralan");
                   Utang_Jasa_Menejemen_Laborat_Ralan=rs.getString("Utang_Jasa_Menejemen_Laborat_Ralan");
                   Radiologi_Ralan=rs.getString("Radiologi_Ralan");
                   Beban_Jasa_Medik_Dokter_Radiologi_Ralan=rs.getString("Beban_Jasa_Medik_Dokter_Radiologi_Ralan");
                   Utang_Jasa_Medik_Dokter_Radiologi_Ralan=rs.getString("Utang_Jasa_Medik_Dokter_Radiologi_Ralan");
                   Beban_Jasa_Medik_Petugas_Radiologi_Ralan=rs.getString("Beban_Jasa_Medik_Petugas_Radiologi_Ralan");
                   Utang_Jasa_Medik_Petugas_Radiologi_Ralan=rs.getString("Utang_Jasa_Medik_Petugas_Radiologi_Ralan");
                   Beban_Kso_Radiologi_Ralan=rs.getString("Beban_Kso_Radiologi_Ralan");
                   Utang_Kso_Radiologi_Ralan=rs.getString("Utang_Kso_Radiologi_Ralan");
                   HPP_Persediaan_Radiologi_Rawat_Jalan=rs.getString("HPP_Persediaan_Radiologi_Rawat_Jalan");
                   Persediaan_BHP_Radiologi_Rawat_Jalan=rs.getString("Persediaan_BHP_Radiologi_Rawat_Jalan");
                   Beban_Jasa_Sarana_Radiologi_Ralan=rs.getString("Beban_Jasa_Sarana_Radiologi_Ralan");
                   Utang_Jasa_Sarana_Radiologi_Ralan=rs.getString("Utang_Jasa_Sarana_Radiologi_Ralan");
                   Beban_Jasa_Perujuk_Radiologi_Ralan=rs.getString("Beban_Jasa_Perujuk_Radiologi_Ralan");
                   Utang_Jasa_Perujuk_Radiologi_Ralan=rs.getString("Utang_Jasa_Perujuk_Radiologi_Ralan");
                   Beban_Jasa_Menejemen_Radiologi_Ralan=rs.getString("Beban_Jasa_Menejemen_Radiologi_Ralan");
                   Utang_Jasa_Menejemen_Radiologi_Ralan=rs.getString("Utang_Jasa_Menejemen_Radiologi_Ralan");
                   Obat_Ralan=rs.getString("Obat_Ralan");
                   HPP_Obat_Rawat_Jalan=rs.getString("HPP_Obat_Rawat_Jalan");
                   Persediaan_Obat_Rawat_Jalan=rs.getString("Persediaan_Obat_Rawat_Jalan");
                   Registrasi_Ralan=rs.getString("Registrasi_Ralan");
                   Operasi_Ralan=rs.getString("Operasi_Ralan");
                   Beban_Jasa_Medik_Dokter_Operasi_Ralan=rs.getString("Beban_Jasa_Medik_Dokter_Operasi_Ralan");
                   Utang_Jasa_Medik_Dokter_Operasi_Ralan=rs.getString("Utang_Jasa_Medik_Dokter_Operasi_Ralan");
                   Beban_Jasa_Medik_Paramedis_Operasi_Ralan=rs.getString("Beban_Jasa_Medik_Paramedis_Operasi_Ralan");
                   Utang_Jasa_Medik_Paramedis_Operasi_Ralan=rs.getString("Utang_Jasa_Medik_Paramedis_Operasi_Ralan");
                   HPP_Obat_Operasi_Ralan=rs.getString("HPP_Obat_Operasi_Ralan");
                   Persediaan_Obat_Kamar_Operasi_Ralan=rs.getString("Persediaan_Obat_Kamar_Operasi_Ralan");
                   Tambahan_Ralan=rs.getString("Tambahan_Ralan");
                   Potongan_Ralan=rs.getString("Potongan_Ralan");
                }
            } catch (Exception e) {
                System.out.println("Notif Rekening : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } 
            
            ps=koneksi.prepareStatement("select * from set_akun_ranap");
            try {
                rs=ps.executeQuery();
                while(rs.next()){
                   Tindakan_Ranap=rs.getString("Tindakan_Ranap");
                   Beban_Jasa_Medik_Dokter_Tindakan_Ranap=rs.getString("Beban_Jasa_Medik_Dokter_Tindakan_Ranap");
                   Utang_Jasa_Medik_Dokter_Tindakan_Ranap=rs.getString("Utang_Jasa_Medik_Dokter_Tindakan_Ranap");
                   Beban_Jasa_Medik_Paramedis_Tindakan_Ranap=rs.getString("Beban_Jasa_Medik_Paramedis_Tindakan_Ranap");
                   Utang_Jasa_Medik_Paramedis_Tindakan_Ranap=rs.getString("Utang_Jasa_Medik_Paramedis_Tindakan_Ranap");
                   Beban_KSO_Tindakan_Ranap=rs.getString("Beban_KSO_Tindakan_Ranap");
                   Utang_KSO_Tindakan_Ranap=rs.getString("Utang_KSO_Tindakan_Ranap");
                   Beban_Jasa_Sarana_Tindakan_Ranap=rs.getString("Beban_Jasa_Sarana_Tindakan_Ranap");
                   Utang_Jasa_Sarana_Tindakan_Ranap=rs.getString("Utang_Jasa_Sarana_Tindakan_Ranap");
                   Beban_Jasa_Menejemen_Tindakan_Ranap=rs.getString("Beban_Jasa_Menejemen_Tindakan_Ranap");
                   Utang_Jasa_Menejemen_Tindakan_Ranap=rs.getString("Utang_Jasa_Menejemen_Tindakan_Ranap");
                   HPP_BHP_Tindakan_Ranap=rs.getString("HPP_BHP_Tindakan_Ranap");
                   Persediaan_BHP_Tindakan_Ranap=rs.getString("Persediaan_BHP_Tindakan_Ranap");
                   Laborat_Ranap=rs.getString("Laborat_Ranap");
                   Beban_Jasa_Medik_Dokter_Laborat_Ranap=rs.getString("Beban_Jasa_Medik_Dokter_Laborat_Ranap");
                   Utang_Jasa_Medik_Dokter_Laborat_Ranap=rs.getString("Utang_Jasa_Medik_Dokter_Laborat_Ranap");
                   Beban_Jasa_Medik_Petugas_Laborat_Ranap=rs.getString("Beban_Jasa_Medik_Petugas_Laborat_Ranap");
                   Utang_Jasa_Medik_Petugas_Laborat_Ranap=rs.getString("Utang_Jasa_Medik_Petugas_Laborat_Ranap");
                   Beban_Kso_Laborat_Ranap=rs.getString("Beban_Kso_Laborat_Ranap");
                   Utang_Kso_Laborat_Ranap=rs.getString("Utang_Kso_Laborat_Ranap");
                   HPP_Persediaan_Laborat_Rawat_inap=rs.getString("HPP_Persediaan_Laborat_Rawat_inap");
                   Persediaan_BHP_Laborat_Rawat_Inap=rs.getString("Persediaan_BHP_Laborat_Rawat_Inap");
                   Beban_Jasa_Sarana_Laborat_Ranap=rs.getString("Beban_Jasa_Sarana_Laborat_Ranap");
                   Utang_Jasa_Sarana_Laborat_Ranap=rs.getString("Utang_Jasa_Sarana_Laborat_Ranap");
                   Beban_Jasa_Perujuk_Laborat_Ranap=rs.getString("Beban_Jasa_Perujuk_Laborat_Ranap");
                   Utang_Jasa_Perujuk_Laborat_Ranap=rs.getString("Utang_Jasa_Perujuk_Laborat_Ranap");
                   Beban_Jasa_Menejemen_Laborat_Ranap=rs.getString("Beban_Jasa_Menejemen_Laborat_Ranap");
                   Utang_Jasa_Menejemen_Laborat_Ranap=rs.getString("Utang_Jasa_Menejemen_Laborat_Ranap");
                   Radiologi_Ranap=rs.getString("Radiologi_Ranap");
                   Beban_Jasa_Medik_Dokter_Radiologi_Ranap=rs.getString("Beban_Jasa_Medik_Dokter_Radiologi_Ranap");
                   Utang_Jasa_Medik_Dokter_Radiologi_Ranap=rs.getString("Utang_Jasa_Medik_Dokter_Radiologi_Ranap");
                   Beban_Jasa_Medik_Petugas_Radiologi_Ranap=rs.getString("Beban_Jasa_Medik_Petugas_Radiologi_Ranap");
                   Utang_Jasa_Medik_Petugas_Radiologi_Ranap=rs.getString("Utang_Jasa_Medik_Petugas_Radiologi_Ranap");
                   Beban_Kso_Radiologi_Ranap=rs.getString("Beban_Kso_Radiologi_Ranap");
                   Utang_Kso_Radiologi_Ranap=rs.getString("Utang_Kso_Radiologi_Ranap");
                   HPP_Persediaan_Radiologi_Rawat_Inap=rs.getString("HPP_Persediaan_Radiologi_Rawat_Inap");
                   Persediaan_BHP_Radiologi_Rawat_Inap=rs.getString("Persediaan_BHP_Radiologi_Rawat_Inap");
                   Beban_Jasa_Sarana_Radiologi_Ranap=rs.getString("Beban_Jasa_Sarana_Radiologi_Ranap");
                   Utang_Jasa_Sarana_Radiologi_Ranap=rs.getString("Utang_Jasa_Sarana_Radiologi_Ranap");
                   Beban_Jasa_Perujuk_Radiologi_Ranap=rs.getString("Beban_Jasa_Perujuk_Radiologi_Ranap");
                   Utang_Jasa_Perujuk_Radiologi_Ranap=rs.getString("Utang_Jasa_Perujuk_Radiologi_Ranap");
                   Beban_Jasa_Menejemen_Radiologi_Ranap=rs.getString("Beban_Jasa_Menejemen_Radiologi_Ranap");
                   Utang_Jasa_Menejemen_Radiologi_Ranap=rs.getString("Utang_Jasa_Menejemen_Radiologi_Ranap");
                   Obat_Ranap=rs.getString("Obat_Ranap");HPP_Obat_Rawat_Inap=rs.getString("HPP_Obat_Rawat_Inap");
                   Persediaan_Obat_Rawat_Inap=rs.getString("Persediaan_Obat_Rawat_Inap");
                   Registrasi_Ranap=rs.getString("Registrasi_Ranap");
                   Service_Ranap=rs.getString("Service_Ranap");
                   Tambahan_Ranap=rs.getString("Tambahan_Ranap");
                   Potongan_Ranap=rs.getString("Potongan_Ranap");
                   Retur_Obat_Ranap=rs.getString("Retur_Obat_Ranap");
                   Resep_Pulang_Ranap=rs.getString("Resep_Pulang_Ranap");
                   Kamar_Inap=rs.getString("Kamar_Inap");
                   Operasi_Ranap=rs.getString("Operasi_Ranap");
                   Beban_Jasa_Medik_Dokter_Operasi_Ranap=rs.getString("Beban_Jasa_Medik_Dokter_Operasi_Ranap");
                   Utang_Jasa_Medik_Dokter_Operasi_Ranap=rs.getString("Utang_Jasa_Medik_Dokter_Operasi_Ranap");
                   Beban_Jasa_Medik_Paramedis_Operasi_Ranap=rs.getString("Beban_Jasa_Medik_Paramedis_Operasi_Ranap");
                   Utang_Jasa_Medik_Paramedis_Operasi_Ranap=rs.getString("Utang_Jasa_Medik_Paramedis_Operasi_Ranap");
                   HPP_Obat_Operasi_Ranap=rs.getString("HPP_Obat_Operasi_Ranap");
                }
            } catch (Exception e) {
                System.out.println("Notif Rekening : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } 
            
            ps=koneksi.prepareStatement("select * from set_akun_ranap2");
            try {
                rs=ps.executeQuery();
                while(rs.next()){
                   Persediaan_Obat_Kamar_Operasi_Ranap=rs.getString("Persediaan_Obat_Kamar_Operasi_Ranap");
                   Harian_Ranap=rs.getString("Harian_Ranap");
                }
            } catch (Exception e) {
                System.out.println("Notif Rekening : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TKd = new widget.TextBox();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnDetailPiutang = new javax.swing.JMenuItem();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbBangsal = new widget.Table();
        panelisi4 = new widget.panelisi();
        label33 = new widget.Label();
        Tanggal = new widget.Tanggal();
        jLabel11 = new widget.Label();
        nama_bayar = new widget.ComboBox();
        label19 = new widget.Label();
        kdptg = new widget.TextBox();
        nmptg = new widget.TextBox();
        btnPetugas = new widget.Button();
        jPanel1 = new javax.swing.JPanel();
        panelisi3 = new widget.panelisi();
        jLabel10 = new javax.swing.JLabel();
        LCount = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        LCount1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        LCount2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LCount3 = new javax.swing.JLabel();
        panelisi1 = new widget.panelisi();
        label17 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();
        jLabel15 = new javax.swing.JLabel();
        BtnBayar = new widget.Button();
        BtnPrint = new widget.Button();
        BtnCari1 = new widget.Button();
        BtnKeluar = new widget.Button();

        TKd.setForeground(new java.awt.Color(255, 255, 255));
        TKd.setName("TKd"); // NOI18N

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnDetailPiutang.setBackground(new java.awt.Color(255, 255, 254));
        MnDetailPiutang.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnDetailPiutang.setForeground(new java.awt.Color(50, 50, 50));
        MnDetailPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnDetailPiutang.setText("Detail Piutang");
        MnDetailPiutang.setName("MnDetailPiutang"); // NOI18N
        MnDetailPiutang.setPreferredSize(new java.awt.Dimension(200, 28));
        MnDetailPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnDetailPiutangActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnDetailPiutang);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ RVP Piutang BPJS ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setComponentPopupMenu(jPopupMenu1);
        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbBangsal.setComponentPopupMenu(jPopupMenu1);
        tbBangsal.setName("tbBangsal"); // NOI18N
        tbBangsal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBangsalMouseClicked(evt);
            }
        });
        tbBangsal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbBangsalPropertyChange(evt);
            }
        });
        Scroll.setViewportView(tbBangsal);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label33.setText("Tanggal :");
        label33.setName("label33"); // NOI18N
        label33.setPreferredSize(new java.awt.Dimension(55, 23));
        panelisi4.add(label33);

        Tanggal.setDisplayFormat("dd-MM-yyyy");
        Tanggal.setName("Tanggal"); // NOI18N
        Tanggal.setPreferredSize(new java.awt.Dimension(90, 23));
        Tanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKeyPressed(evt);
            }
        });
        panelisi4.add(Tanggal);

        jLabel11.setText("Akun Bayar :");
        jLabel11.setName("jLabel11"); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(73, 23));
        panelisi4.add(jLabel11);

        nama_bayar.setName("nama_bayar"); // NOI18N
        nama_bayar.setPreferredSize(new java.awt.Dimension(185, 23));
        nama_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nama_bayarKeyPressed(evt);
            }
        });
        panelisi4.add(nama_bayar);

        label19.setText("Petugas :");
        label19.setName("label19"); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(58, 23));
        panelisi4.add(label19);

        kdptg.setName("kdptg"); // NOI18N
        kdptg.setPreferredSize(new java.awt.Dimension(100, 23));
        kdptg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdptgKeyPressed(evt);
            }
        });
        panelisi4.add(kdptg);

        nmptg.setEditable(false);
        nmptg.setName("nmptg"); // NOI18N
        nmptg.setPreferredSize(new java.awt.Dimension(160, 23));
        panelisi4.add(nmptg);

        btnPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugas.setMnemonic('3');
        btnPetugas.setToolTipText("Alt+3");
        btnPetugas.setName("btnPetugas"); // NOI18N
        btnPetugas.setPreferredSize(new java.awt.Dimension(28, 23));
        btnPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasActionPerformed(evt);
            }
        });
        btnPetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasKeyPressed(evt);
            }
        });
        panelisi4.add(btnPetugas);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi3.setName("panelisi3"); // NOI18N
        panelisi3.setPreferredSize(new java.awt.Dimension(99, 44));
        panelisi3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(50, 50, 50));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Belum Dibayar :");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(87, 23));
        panelisi3.add(jLabel10);

        LCount.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        LCount.setForeground(new java.awt.Color(50, 50, 50));
        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(140, 23));
        panelisi3.add(LCount);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(50, 50, 50));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Dipilih :");
        jLabel12.setName("jLabel12"); // NOI18N
        jLabel12.setPreferredSize(new java.awt.Dimension(45, 23));
        panelisi3.add(jLabel12);

        LCount1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        LCount1.setForeground(new java.awt.Color(50, 50, 50));
        LCount1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount1.setText("0");
        LCount1.setName("LCount1"); // NOI18N
        LCount1.setPreferredSize(new java.awt.Dimension(140, 23));
        panelisi3.add(LCount1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(50, 50, 50));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Kerugian :");
        jLabel13.setName("jLabel13"); // NOI18N
        jLabel13.setPreferredSize(new java.awt.Dimension(60, 23));
        panelisi3.add(jLabel13);

        LCount2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        LCount2.setForeground(new java.awt.Color(50, 50, 50));
        LCount2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount2.setText("0");
        LCount2.setName("LCount2"); // NOI18N
        LCount2.setPreferredSize(new java.awt.Dimension(100, 23));
        panelisi3.add(LCount2);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(50, 50, 50));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Lebih Bayar :");
        jLabel14.setName("jLabel14"); // NOI18N
        jLabel14.setPreferredSize(new java.awt.Dimension(70, 23));
        panelisi3.add(jLabel14);

        LCount3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        LCount3.setForeground(new java.awt.Color(50, 50, 50));
        LCount3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount3.setText("0");
        LCount3.setName("LCount3"); // NOI18N
        LCount3.setPreferredSize(new java.awt.Dimension(100, 23));
        panelisi3.add(LCount3);

        jPanel1.add(panelisi3, java.awt.BorderLayout.CENTER);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(55, 55));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label17.setText("Key Word :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(60, 23));
        panelisi1.add(label17);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(190, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi1.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelisi1.add(BtnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelisi1.add(BtnAll);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(50, 50, 50));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setName("jLabel15"); // NOI18N
        jLabel15.setPreferredSize(new java.awt.Dimension(30, 23));
        panelisi1.add(jLabel15);

        BtnBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnBayar.setMnemonic('B');
        BtnBayar.setText("Bayar");
        BtnBayar.setToolTipText("Alt+B");
        BtnBayar.setName("BtnBayar"); // NOI18N
        BtnBayar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBayarActionPerformed(evt);
            }
        });
        BtnBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBayarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnBayar);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi1.add(BtnPrint);

        BtnCari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnCari1.setMnemonic('C');
        BtnCari1.setText("Cari");
        BtnCari1.setToolTipText("Alt+C");
        BtnCari1.setName("BtnCari1"); // NOI18N
        BtnCari1.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCari1ActionPerformed(evt);
            }
        });
        BtnCari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCari1KeyPressed(evt);
            }
        });
        panelisi1.add(BtnCari1);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        jPanel1.add(panelisi1, java.awt.BorderLayout.PAGE_END);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            
            Sequel.queryu("truncate table temporary");
            int row=tabMode.getRowCount();
            for(int i=0;i<row;i++){  
                    Sequel.menyimpan("temporary","'0','"+
                                tabMode.getValueAt(i,0).toString()+"','"+
                                tabMode.getValueAt(i,1).toString()+"','"+
                                tabMode.getValueAt(i,2).toString()+"','"+
                                tabMode.getValueAt(i,3).toString()+"','"+
                                Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,4).toString()))+"','"+
                                Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,5).toString()))+"','"+
                                Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,6).toString()))+"','"+
                                Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,7).toString()))+"','"+
                                tabMode.getValueAt(i,8).toString()+"','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Piutang Pasien"); 
            }
            Sequel.menyimpan("temporary","'0','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Rekap Harian Tindakan Dokter"); 
            Sequel.menyimpan("temporary","'0','TOTAL PIUTANG','',':','','','','','"+LCount.getText()+"','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Rekap Harian Tindakan Dokter"); 
            
            
            Map<String, Object> param = new HashMap<>();                 
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());   
            param.put("logo",Sequel.cariGambar("select logo from setting")); 
            Valid.MyReport("rptRPiutangMasuk.jasper","report","::[ Rekap Piutang Masuk ]::",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBayar, BtnAll);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnAll,TKd);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        kdptg.setText("");
        nmptg.setText("");
        tampil();

}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        tampil();
}//GEN-LAST:event_BtnCariKeyPressed

private void MnDetailPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnDetailPiutangActionPerformed
     if(tabMode.getRowCount()==0){
        JOptionPane.showMessageDialog(null,"Maaf, table masih kosong...!!!!");
        TCari.requestFocus();
    }else{
         if(tbBangsal.getSelectedRow()!= -1){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            status=Sequel.cariIsi("select status_lanjut from reg_periksa where no_rawat=?",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());   
            if(status.equals("Ralan")){
                DlgBilingRalan billing=new DlgBilingRalan(null,false);
                billing.TNoRw.setText(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                billing.isCek();
                billing.isRawat();
                if(Sequel.cariInteger("select count(no_rawat) from piutang_pasien where no_rawat=?",billing.TNoRw.getText())>0){
                    billing.setPiutang();
                }
                billing.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
                billing.setLocationRelativeTo(internalFrame1);
                billing.setVisible(true); 
            }else if(status.equals("Ranap")){
                DlgBilingRanap billing=new DlgBilingRanap(null,false);
                billing.TNoRw.setText(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());            
                billing.isCek();
                billing.isRawat();
                billing.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
                billing.setLocationRelativeTo(internalFrame1);
                billing.setVisible(true); 
            }
            this.setCursor(Cursor.getDefaultCursor());
         }else{
             JOptionPane.showMessageDialog(null,"Silahkan pilih data terlebih dahulu...!!");
         }                   
    } 
}//GEN-LAST:event_MnDetailPiutangActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void BtnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBayarActionPerformed
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis..!!!!");
        }else if(total<=0){
            JOptionPane.showMessageDialog(null,"Maaf, silahkan pilih piutang yang mau dibayar..!!!!");
            TCari.requestFocus();
        }else if(nmptg.getText().trim().equals("")){
            Valid.textKosong(kdptg,"Petugas");
        }else if(nama_bayar.getSelectedItem().toString().trim().equals("")){
            Valid.textKosong(nama_bayar,"Akun Bayar");
        }else if(tabMode.getRowCount()!=0){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            Sequel.AutoComitFalse();
            sukses=true;
            koderekening=Sequel.cariIsi("select kd_rek from akun_bayar where nama_bayar=?",nama_bayar.getSelectedItem().toString());
            
            row=tabMode.getRowCount();
            for(i=0;i<row;i++){  
                if(tabMode.getValueAt(i,0).toString().equals("true")){
                    if(Sequel.menyimpantf("bayar_piutang","?,?,?,?,?,?,?","Data",7,new String[]{
                        Valid.SetTgl(Tanggal.getSelectedItem()+""),Sequel.cariIsi("select no_rkm_medis from reg_periksa where no_rawat=?",tabMode.getValueAt(i,1).toString()),
                        tabMode.getValueAt(i,10).toString(),"diverifikasi oleh "+kdptg.getText(),tabMode.getValueAt(i,1).toString(),koderekening,Piutang_BPJS_RVP
                    })==true){
                        Sequel.mengedit("piutang_pasien","no_rawat='"+tabMode.getValueAt(i,1).toString()+"'","status='Lunas'");
                        Sequel.mengedit("detail_piutang_pasien","no_rawat='"+tabMode.getValueAt(i,1).toString()+"'","sisapiutang=0");
                        
                        /*if(RVPendapatan.getSelectedItem().equals("Tidak")){
                            Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+tabMode.getValueAt(i,8).toString()+"'","kredit=kredit+'"+tabMode.getValueAt(i,8).toString()+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                            if(Valid.SetAngka(tabMode.getValueAt(i,13).toString())>0){
                                
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,12).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Kerugian_Klaim_BPJS_RVP+"','KERUGIAN KLAIM BPJS','"+tabMode.getValueAt(i,12).toString()+"','0'","debet=debet+'"+tabMode.getValueAt(i,12).toString()+"'","kd_rek='"+Kerugian_Klaim_BPJS_RVP+"'");  
                            }  
                        }else{
                            
                        }*/  
                        
                        if(Valid.SetAngka(tabMode.getValueAt(i,11).toString())>=100){
                            Sequel.queryu("delete from tampjurnal");
                            if(Valid.SetAngka(tabMode.getValueAt(i,13).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Lebih_Bayar_Klaim_BPJS_RVP+"','LEBIH BAYAR BPJS','0','"+tabMode.getValueAt(i,13).toString()+"'","kredit=kredit+'"+tabMode.getValueAt(i,13).toString()+"'","kd_rek='"+Lebih_Bayar_Klaim_BPJS_RVP+"'"); 
                            }
                                
                            Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+tabMode.getValueAt(i,8).toString()+"'","kredit=kredit+'"+tabMode.getValueAt(i,8).toString()+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                            Sequel.menyimpan("tampjurnal","'"+koderekening+"','"+nama_bayar.getSelectedItem()+"','"+tabMode.getValueAt(i,10).toString()+"','0'","debet=debet+'"+tabMode.getValueAt(i,10).toString()+"'","kd_rek='"+koderekening+"'"); 
                            sukses=jur.simpanJurnal(tabMode.getValueAt(i,1).toString(),Valid.SetTgl(Tanggal.getSelectedItem()+""),"U","BAYAR PIUTANG BPJS"+", OLEH "+kdptg.getText());  
                        }else if(Valid.SetAngka(tabMode.getValueAt(i,11).toString())<100){
                            Sequel.queryu("delete from tampjurnal");
                            //tindakan ralan
                            if(Valid.SetAngka(tabMode.getValueAt(i,16).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Tindakan_Ralan+"','Beban Jasa Sarana Tindakan Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,16).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,16).toString())+"'","kd_rek='"+Beban_Jasa_Sarana_Tindakan_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Tindakan_Ralan+"','Utang Jasa Sarana Tindakan Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,16).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,16).toString())+"'","kd_rek='"+Utang_Jasa_Sarana_Tindakan_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,18).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Tindakan_Ralan+"','Beban_Jasa_Medik_Dokter_Tindakan_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,18).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,18).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Tindakan_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Tindakan_Ralan+"','Utang_Jasa_Medik_Dokter_Tindakan_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,18).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,18).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Tindakan_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,19).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Tindakan_Ralan+"','Beban_Jasa_Medik_Paramedis_Tindakan_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,19).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,19).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Tindakan_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Tindakan_Ralan+"','Utang_Jasa_Medik_Paramedis_Tindakan_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,19).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,19).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Tindakan_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,20).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_KSO_Tindakan_Ralan+"','Beban_KSO_Tindakan_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,20).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,20).toString())+"'","kd_rek='"+Beban_KSO_Tindakan_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_KSO_Tindakan_Ralan+"','Utang_KSO_Tindakan_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,20).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,20).toString())+"'","kd_rek='"+Utang_KSO_Tindakan_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,21).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Tindakan_Ralan+"','Beban_Jasa_Menejemen_Tindakan_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,21).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,21).toString())+"'","kd_rek='"+Beban_Jasa_Menejemen_Tindakan_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Tindakan_Ralan+"','Utang_Jasa_Menejemen_Tindakan_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,21).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,21).toString())+"'","kd_rek='"+Utang_Jasa_Menejemen_Tindakan_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,22).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,22).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,22).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Tindakan_Ralan+"','PENDAPATAN RAWAT JALAN','"+Valid.SetAngka(tabMode.getValueAt(i,22).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,22).toString())+"'","kd_rek='"+Tindakan_Ralan+"'");   
                            }
                            //tindakan ranap
                            if(Valid.SetAngka(tabMode.getValueAt(i,23).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Tindakan_Ranap+"','Beban_Jasa_Sarana_Tindakan_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,23).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,23).toString())+"'","kd_rek='"+Beban_Jasa_Sarana_Tindakan_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Tindakan_Ranap+"','Utang_Jasa_Sarana_Tindakan_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,23).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,23).toString())+"'","kd_rek='"+Utang_Jasa_Sarana_Tindakan_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,25).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Tindakan_Ranap+"','Beban_Jasa_Medik_Dokter_Tindakan_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,25).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,25).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Tindakan_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Tindakan_Ranap+"','Utang_Jasa_Medik_Dokter_Tindakan_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,25).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,25).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Tindakan_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,26).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Tindakan_Ranap+"','Beban_Jasa_Medik_Paramedis_Tindakan_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,26).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,26).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Tindakan_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Tindakan_Ranap+"','Utang_Jasa_Medik_Paramedis_Tindakan_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,26).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,26).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Tindakan_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,27).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_KSO_Tindakan_Ranap+"','Beban_KSO_Tindakan_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,27).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,27).toString())+"'","kd_rek='"+Beban_KSO_Tindakan_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_KSO_Tindakan_Ranap+"','Utang_KSO_Tindakan_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,27).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,27).toString())+"'","kd_rek='"+Utang_KSO_Tindakan_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,28).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Tindakan_Ranap+"','Beban_Jasa_Menejemen_Tindakan_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,28).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,28).toString())+"'","kd_rek='"+Beban_Jasa_Menejemen_Tindakan_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Tindakan_Ranap+"','Utang_Jasa_Menejemen_Tindakan_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,28).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,28).toString())+"'","kd_rek='"+Utang_Jasa_Menejemen_Tindakan_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,29).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,29).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,29).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Tindakan_Ranap+"','PENDAPATAN RAWAT INAP','"+Valid.SetAngka(tabMode.getValueAt(i,29).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,29).toString())+"'","kd_rek='"+Tindakan_Ranap+"'");   
                            }
                            //laborat ralan
                            if(Valid.SetAngka(tabMode.getValueAt(i,30).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Laborat_Ralan+"','Beban_Jasa_Sarana_Laborat_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,30).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,30).toString())+"'","kd_rek='"+Beban_Jasa_Sarana_Laborat_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Laborat_Ralan+"','Utang_Jasa_Sarana_Laborat_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,30).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,30).toString())+"'","kd_rek='"+Utang_Jasa_Sarana_Laborat_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,32).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Laborat_Ralan+"','Beban_Jasa_Perujuk_Laborat_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,32).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,32).toString())+"'","kd_rek='"+Beban_Jasa_Perujuk_Laborat_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Laborat_Ralan+"','Utang_Jasa_Perujuk_Laborat_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,32).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,32).toString())+"'","kd_rek='"+Utang_Jasa_Perujuk_Laborat_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,33).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Laborat_Ralan+"','Beban_Jasa_Medik_Dokter_Laborat_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,33).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,33).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Laborat_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Laborat_Ralan+"','Utang_Jasa_Medik_Dokter_Laborat_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,33).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,33).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Laborat_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,34).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Laborat_Ralan+"','Beban_Jasa_Medik_Petugas_Laborat_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,34).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,34).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Laborat_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Laborat_Ralan+"','Utang_Jasa_Medik_Petugas_Laborat_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,34).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,34).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Laborat_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,35).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Laborat_Ralan+"','Beban_Kso_Laborat_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,35).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,35).toString())+"'","kd_rek='"+Beban_Kso_Laborat_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Laborat_Ralan+"','Utang_Kso_Laborat_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,35).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,35).toString())+"'","kd_rek='"+Utang_Kso_Laborat_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,36).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Laborat_Ralan+"','Beban_Jasa_Menejemen_Laborat_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,36).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,36).toString())+"'","kd_rek='"+Beban_Jasa_Menejemen_Laborat_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Laborat_Ralan+"','Utang_Jasa_Menejemen_Laborat_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,36).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,36).toString())+"'","kd_rek='"+Utang_Jasa_Menejemen_Laborat_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,37).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,37).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,37).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Laborat_Ralan+"','PENDAPATAN LABORAT RAWAT JALAN','"+Valid.SetAngka(tabMode.getValueAt(i,37).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,37).toString())+"'","kd_rek='"+Laborat_Ralan+"'");   
                            }
                            //laborat ranap
                            if(Valid.SetAngka(tabMode.getValueAt(i,38).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Laborat_Ranap+"','Beban_Jasa_Sarana_Laborat_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,38).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,38).toString())+"'","kd_rek='"+Beban_Jasa_Sarana_Laborat_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Laborat_Ranap+"','Utang_Jasa_Sarana_Laborat_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,38).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,38).toString())+"'","kd_rek='"+Utang_Jasa_Sarana_Laborat_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,40).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Laborat_Ranap+"','Beban_Jasa_Perujuk_Laborat_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,40).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,40).toString())+"'","kd_rek='"+Beban_Jasa_Perujuk_Laborat_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Laborat_Ranap+"','Utang_Jasa_Perujuk_Laborat_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,40).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,40).toString())+"'","kd_rek='"+Utang_Jasa_Perujuk_Laborat_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,41).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Laborat_Ranap+"','Beban_Jasa_Medik_Dokter_Laborat_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,41).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,41).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Laborat_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Laborat_Ranap+"','Utang_Jasa_Medik_Dokter_Laborat_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,41).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,41).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Laborat_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,42).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Laborat_Ranap+"','Beban_Jasa_Medik_Petugas_Laborat_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,42).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,42).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Laborat_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Laborat_Ranap+"','Utang_Jasa_Medik_Petugas_Laborat_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,42).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,42).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Laborat_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,43).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Laborat_Ranap+"','Beban_Kso_Laborat_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,43).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,43).toString())+"'","kd_rek='"+Beban_Kso_Laborat_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Laborat_Ranap+"','Utang_Kso_Laborat_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,43).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,43).toString())+"'","kd_rek='"+Utang_Kso_Laborat_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,44).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Laborat_Ranap+"','Beban_Jasa_Menejemen_Laborat_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,44).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,44).toString())+"'","kd_rek='"+Beban_Jasa_Menejemen_Laborat_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Laborat_Ranap+"','Utang_Jasa_Menejemen_Laborat_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,44).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,44).toString())+"'","kd_rek='"+Utang_Jasa_Menejemen_Laborat_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,45).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,45).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,45).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Laborat_Ranap+"','PENDAPATAN LABORAT RAWAT INAP','"+Valid.SetAngka(tabMode.getValueAt(i,45).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,45).toString())+"'","kd_rek='"+Laborat_Ranap+"'");   
                            }
                            //radiologi ralan
                            if(Valid.SetAngka(tabMode.getValueAt(i,46).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Radiologi_Ralan+"','Beban_Jasa_Sarana_Radiologi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,46).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,46).toString())+"'","kd_rek='"+Beban_Jasa_Sarana_Radiologi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Radiologi_Ralan+"','Utang_Jasa_Sarana_Radiologi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,46).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,46).toString())+"'","kd_rek='"+Utang_Jasa_Sarana_Radiologi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,48).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Radiologi_Ralan+"','Beban_Jasa_Perujuk_Radiologi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,48).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,48).toString())+"'","kd_rek='"+Beban_Jasa_Perujuk_Radiologi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Radiologi_Ralan+"','Utang_Jasa_Perujuk_Radiologi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,48).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,48).toString())+"'","kd_rek='"+Utang_Jasa_Perujuk_Radiologi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,49).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Radiologi_Ralan+"','Beban_Jasa_Medik_Dokter_Radiologi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,49).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,49).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Radiologi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Radiologi_Ralan+"','Utang_Jasa_Medik_Dokter_Radiologi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,49).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,49).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Radiologi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,50).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Radiologi_Ralan+"','Beban_Jasa_Medik_Petugas_Radiologi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,50).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,50).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Radiologi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Radiologi_Ralan+"','Utang_Jasa_Medik_Petugas_Radiologi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,50).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,50).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Radiologi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,51).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Radiologi_Ralan+"','Beban_Kso_Radiologi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,51).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,51).toString())+"'","kd_rek='"+Beban_Kso_Radiologi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Radiologi_Ralan+"','Utang_Kso_Radiologi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,51).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,51).toString())+"'","kd_rek='"+Utang_Kso_Radiologi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,52).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Radiologi_Ralan+"','Beban_Jasa_Menejemen_Radiologi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,52).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,52).toString())+"'","kd_rek='"+Beban_Jasa_Menejemen_Radiologi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Radiologi_Ralan+"','Utang_Jasa_Menejemen_Radiologi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,52).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,52).toString())+"'","kd_rek='"+Utang_Jasa_Menejemen_Radiologi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,53).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,53).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,53).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Radiologi_Ralan+"','PENDAPATAN RADIOLOGI RAWAT JALAN','"+Valid.SetAngka(tabMode.getValueAt(i,53).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,53).toString())+"'","kd_rek='"+Radiologi_Ralan+"'");   
                            }
                            //radiologi ranap
                            if(Valid.SetAngka(tabMode.getValueAt(i,54).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Radiologi_Ranap+"','Beban_Jasa_Sarana_Radiologi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,54).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,54).toString())+"'","kd_rek='"+Beban_Jasa_Sarana_Radiologi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Radiologi_Ranap+"','Utang_Jasa_Sarana_Radiologi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,54).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,54).toString())+"'","kd_rek='"+Utang_Jasa_Sarana_Radiologi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,56).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Radiologi_Ranap+"','Beban_Jasa_Perujuk_Radiologi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,56).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,56).toString())+"'","kd_rek='"+Beban_Jasa_Perujuk_Radiologi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Radiologi_Ranap+"','Utang_Jasa_Perujuk_Radiologi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,56).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,56).toString())+"'","kd_rek='"+Utang_Jasa_Perujuk_Radiologi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,57).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Radiologi_Ranap+"','Beban_Jasa_Medik_Dokter_Radiologi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,57).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,57).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Radiologi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Radiologi_Ranap+"','Utang_Jasa_Medik_Dokter_Radiologi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,57).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,57).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Radiologi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,58).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Radiologi_Ranap+"','Beban_Jasa_Medik_Petugas_Radiologi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,58).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,58).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Radiologi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Radiologi_Ranap+"','Utang_Jasa_Medik_Petugas_Radiologi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,58).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,58).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Radiologi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,59).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Radiologi_Ranap+"','Beban_Kso_Radiologi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,59).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,59).toString())+"'","kd_rek='"+Beban_Kso_Radiologi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Radiologi_Ranap+"','Utang_Kso_Radiologi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,59).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,59).toString())+"'","kd_rek='"+Utang_Kso_Radiologi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,60).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Radiologi_Ranap+"','Beban_Jasa_Menejemen_Radiologi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,60).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,60).toString())+"'","kd_rek='"+Beban_Jasa_Menejemen_Radiologi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Radiologi_Ranap+"','Utang_Jasa_Menejemen_Radiologi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,60).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,60).toString())+"'","kd_rek='"+Utang_Jasa_Menejemen_Radiologi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,61).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,61).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,61).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Radiologi_Ranap+"','PENDAPATAN RADIOLOGI RAWAT INAP','"+Valid.SetAngka(tabMode.getValueAt(i,61).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,61).toString())+"'","kd_rek='"+Radiologi_Ranap+"'");   
                            }
                            //operasi ralan
                            if(Valid.SetAngka(tabMode.getValueAt(i,62).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Operasi_Ralan+"','Beban_Jasa_Medik_Dokter_Operasi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,62).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,62).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Operasi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Operasi_Ralan+"','Utang_Jasa_Medik_Dokter_Operasi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,62).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,62).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Operasi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,63).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Operasi_Ralan+"','Beban_Jasa_Medik_Paramedis_Operasi_Ralan','0','"+Valid.SetAngka(tabMode.getValueAt(i,63).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,63).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Operasi_Ralan+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Operasi_Ralan+"','Utang_Jasa_Medik_Paramedis_Operasi_Ralan','"+Valid.SetAngka(tabMode.getValueAt(i,63).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,63).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Operasi_Ralan+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,65).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT JALAN','0','"+(Valid.SetAngka(tabMode.getValueAt(i,64).toString())+Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"'","kredit=kredit+'"+(Valid.SetAngka(tabMode.getValueAt(i,64).toString())+Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Operasi_Ralan+"','PENDAPATAN OPERASI RAWAT JALAN','"+(Valid.SetAngka(tabMode.getValueAt(i,64).toString())+Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"','0'","debet=debet+'"+(Valid.SetAngka(tabMode.getValueAt(i,64).toString())+Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"'","kd_rek='"+Operasi_Ralan+"'");   
                            }
                            //operasi ranap
                            if(Valid.SetAngka(tabMode.getValueAt(i,66).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Operasi_Ranap+"','Beban_Jasa_Medik_Dokter_Operasi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,66).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,66).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Operasi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Operasi_Ranap+"','Utang_Jasa_Medik_Dokter_Operasi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,66).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,66).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Operasi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,67).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Operasi_Ranap+"','Beban_Jasa_Medik_Paramedis_Operasi_Ranap','0','"+Valid.SetAngka(tabMode.getValueAt(i,67).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,67).toString())+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Operasi_Ranap+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Operasi_Ranap+"','Utang_Jasa_Medik_Paramedis_Operasi_Ranap','"+Valid.SetAngka(tabMode.getValueAt(i,67).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,67).toString())+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Operasi_Ranap+"'");   
                            }
                            if(Valid.SetAngka(tabMode.getValueAt(i,69).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS,'0','"+(Valid.SetAngka(tabMode.getValueAt(i,68).toString())+Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"'","kredit=kredit+'"+(Valid.SetAngka(tabMode.getValueAt(i,68).toString())+Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Operasi_Ranap+"','PENDAPATAN OPERASI RAWAT INAP','"+(Valid.SetAngka(tabMode.getValueAt(i,68).toString())+Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"','0'","debet=debet+'"+(Valid.SetAngka(tabMode.getValueAt(i,68).toString())+Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"'","kd_rek='"+Operasi_Ranap+"'");   
                            }
                            //kamar
                            if(Valid.SetAngka(tabMode.getValueAt(i,78).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,78).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,78).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Kamar_Inap+"','PENDAPATAN KAMAR INAP','"+Valid.SetAngka(tabMode.getValueAt(i,78).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,78).toString())+"'","kd_rek='"+Kamar_Inap+"'");   
                            }
                            //harian
                            if(Valid.SetAngka(tabMode.getValueAt(i,80).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,80).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,80).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Harian_Ranap+"','PENDAPATAN HARIAN KAMAR INAP','"+Valid.SetAngka(tabMode.getValueAt(i,80).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,80).toString())+"'","kd_rek='"+Harian_Ranap+"'");   
                            }
                            //registrasi
                            if(Valid.SetAngka(tabMode.getValueAt(i,81).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,81).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,81).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                    Sequel.menyimpan("tampjurnal","'"+Registrasi_Ralan+"','PENDAPATAN REGISTRASI RALAN','"+Valid.SetAngka(tabMode.getValueAt(i,81).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,81).toString())+"'","kd_rek='"+Registrasi_Ralan+"'");
                                }else{
                                    Sequel.menyimpan("tampjurnal","'"+Registrasi_Ranap+"','PENDAPATAN REGISTRASI RALAN','"+Valid.SetAngka(tabMode.getValueAt(i,81).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,81).toString())+"'","kd_rek='"+Registrasi_Ranap+"'");
                                }
                            }
                            //tambahan biaya
                            if(Valid.SetAngka(tabMode.getValueAt(i,76).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,76).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,76).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                    Sequel.menyimpan("tampjurnal","'"+Tambahan_Ralan+"','PENDAPATAN TAMBAHAN RALAN','"+Valid.SetAngka(tabMode.getValueAt(i,76).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,76).toString())+"'","kd_rek='"+Tambahan_Ralan+"'");
                                }else{
                                    Sequel.menyimpan("tampjurnal","'"+Tambahan_Ranap+"','PENDAPATAN TAMBAHAN RANAP','"+Valid.SetAngka(tabMode.getValueAt(i,76).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,76).toString())+"'","kd_rek='"+Tambahan_Ranap+"'");
                                }
                            }
                            //potongan biaya
                            if(Valid.SetAngka(tabMode.getValueAt(i,77).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','"+Valid.SetAngka(tabMode.getValueAt(i,77).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,77).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                    Sequel.menyimpan("tampjurnal","'"+Potongan_Ralan+"','POTONGAN RALAN','0','"+Valid.SetAngka(tabMode.getValueAt(i,77).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,77).toString())+"'","kd_rek='"+Potongan_Ralan+"'");
                                }else{
                                    Sequel.menyimpan("tampjurnal","'"+Potongan_Ranap+"','POTONGAN RANAP','0','"+Valid.SetAngka(tabMode.getValueAt(i,77).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,77).toString())+"'","kd_rek='"+Potongan_Ranap+"'");
                                }
                            }
                            //resep pulang
                            if(Valid.SetAngka(tabMode.getValueAt(i,79).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,79).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,79).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Resep_Pulang_Ranap+"','PENDAPATAN RESEP PULANG','"+Valid.SetAngka(tabMode.getValueAt(i,79).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,79).toString())+"'","kd_rek='"+Resep_Pulang_Ranap+"'");   
                            }
                            //obat langsung
                            if(Valid.SetAngka(tabMode.getValueAt(i,70).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,70).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,70).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                    Sequel.menyimpan("tampjurnal","'"+Obat_Ralan+"','OBAT LANGSUNG RALAN','"+Valid.SetAngka(tabMode.getValueAt(i,70).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,70).toString())+"'","kd_rek='"+Obat_Ralan+"'");
                                }else{
                                    Sequel.menyimpan("tampjurnal","'"+Obat_Ranap+"','OBAT LANGSUNG RANAP','"+Valid.SetAngka(tabMode.getValueAt(i,70).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,70).toString())+"'","kd_rek='"+Obat_Ranap+"'");
                                }
                            }
                            //obat ralan
                            if(Valid.SetAngka(tabMode.getValueAt(i,71).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,71).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,71).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Obat_Ralan+"','PENDAPATAN OBAT RALAN','"+Valid.SetAngka(tabMode.getValueAt(i,71).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,71).toString())+"'","kd_rek='"+Obat_Ralan+"'");   
                            }
                            //obat ranap
                            if(Valid.SetAngka(tabMode.getValueAt(i,73).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+Valid.SetAngka(tabMode.getValueAt(i,73).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,73).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Obat_Ranap+"','PENDAPATAN OBAT RANAP','"+Valid.SetAngka(tabMode.getValueAt(i,73).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,73).toString())+"'","kd_rek='"+Obat_Ranap+"'");   
                            }
                            //retur obat ranap
                            if(Valid.SetAngka(tabMode.getValueAt(i,75).toString())>0){
                                Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','"+Valid.SetAngka(tabMode.getValueAt(i,75).toString())+"','0'","debet=debet+'"+Valid.SetAngka(tabMode.getValueAt(i,75).toString())+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                Sequel.menyimpan("tampjurnal","'"+Retur_Obat_Ranap+"','PENDAPATAN OBAT RANAP','0','"+Valid.SetAngka(tabMode.getValueAt(i,75).toString())+"'","kredit=kredit+'"+Valid.SetAngka(tabMode.getValueAt(i,75).toString())+"'","kd_rek='"+Retur_Obat_Ranap+"'");   
                            }
                            //jurnal pembatalan beban, utang, piutang, pendapatan
                            sukses=jur.simpanJurnal(tabMode.getValueAt(i,1).toString(),Valid.SetTgl(Tanggal.getSelectedItem()+""),"U","PEMBATALAN PIUTANG PASIEN BPJS, OLEH "+kdptg.getText());     
                            
                            /*if(sukses==true){
                                Sequel.queryu("delete from tampjurnal");
                                //tindakan ralan
                                if(Valid.SetAngka(tabMode.getValueAt(i,16).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Tindakan_Ralan+"','Beban Jasa Sarana Tindakan Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,16).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,16).toString()))+"'","kd_rek='"+Beban_Jasa_Sarana_Tindakan_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Tindakan_Ralan+"','Utang Jasa Sarana Tindakan Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,16).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,16).toString()))+"'","kd_rek='"+Utang_Jasa_Sarana_Tindakan_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,18).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Tindakan_Ralan+"','Beban_Jasa_Medik_Dokter_Tindakan_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,18).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,18).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Tindakan_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Tindakan_Ralan+"','Utang_Jasa_Medik_Dokter_Tindakan_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,18).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,18).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Tindakan_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,19).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Tindakan_Ralan+"','Beban_Jasa_Medik_Paramedis_Tindakan_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,19).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,19).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Tindakan_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Tindakan_Ralan+"','Utang_Jasa_Medik_Paramedis_Tindakan_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,19).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,19).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Tindakan_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,20).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_KSO_Tindakan_Ralan+"','Beban_KSO_Tindakan_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,20).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,20).toString()))+"'","kd_rek='"+Beban_KSO_Tindakan_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_KSO_Tindakan_Ralan+"','Utang_KSO_Tindakan_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,20).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,20).toString()))+"'","kd_rek='"+Utang_KSO_Tindakan_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,21).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Tindakan_Ralan+"','Beban_Jasa_Menejemen_Tindakan_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,21).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,21).toString()))+"'","kd_rek='"+Beban_Jasa_Menejemen_Tindakan_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Tindakan_Ralan+"','Utang_Jasa_Menejemen_Tindakan_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,21).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,21).toString()))+"'","kd_rek='"+Utang_Jasa_Menejemen_Tindakan_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,22).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT JALAN','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,22).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,22).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Tindakan_Ralan+"','PENDAPATAN RAWAT JALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,22).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,22).toString()))+"'","kd_rek='"+Tindakan_Ralan+"'");   
                                }
                                //tindakan ranap
                                if(Valid.SetAngka(tabMode.getValueAt(i,23).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Tindakan_Ranap+"','Beban_Jasa_Sarana_Tindakan_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,23).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,23).toString()))+"'","kd_rek='"+Beban_Jasa_Sarana_Tindakan_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Tindakan_Ranap+"','Utang_Jasa_Sarana_Tindakan_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,23).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,23).toString()))+"'","kd_rek='"+Utang_Jasa_Sarana_Tindakan_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,25).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Tindakan_Ranap+"','Beban_Jasa_Medik_Dokter_Tindakan_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,25).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,25).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Tindakan_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Tindakan_Ranap+"','Utang_Jasa_Medik_Dokter_Tindakan_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,25).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,25).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Tindakan_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,26).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Tindakan_Ranap+"','Beban_Jasa_Medik_Paramedis_Tindakan_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,26).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,26).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Tindakan_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Tindakan_Ranap+"','Utang_Jasa_Medik_Paramedis_Tindakan_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,26).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,26).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Tindakan_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,27).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_KSO_Tindakan_Ranap+"','Beban_KSO_Tindakan_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,27).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,27).toString()))+"'","kd_rek='"+Beban_KSO_Tindakan_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_KSO_Tindakan_Ranap+"','Utang_KSO_Tindakan_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,27).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,27).toString()))+"'","kd_rek='"+Utang_KSO_Tindakan_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,28).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Tindakan_Ranap+"','Beban_Jasa_Menejemen_Tindakan_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,28).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,28).toString()))+"'","kd_rek='"+Beban_Jasa_Menejemen_Tindakan_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Tindakan_Ranap+"','Utang_Jasa_Menejemen_Tindakan_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,28).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,28).toString()))+"'","kd_rek='"+Utang_Jasa_Menejemen_Tindakan_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,29).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT INAP','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,29).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,29).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Tindakan_Ranap+"','PENDAPATAN RAWAT INAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,29).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,29).toString()))+"'","kd_rek='"+Tindakan_Ranap+"'");   
                                }
                                //laborat ralan
                                if(Valid.SetAngka(tabMode.getValueAt(i,30).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Laborat_Ralan+"','Beban_Jasa_Sarana_Laborat_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,30).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,30).toString()))+"'","kd_rek='"+Beban_Jasa_Sarana_Laborat_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Laborat_Ralan+"','Utang_Jasa_Sarana_Laborat_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,30).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,30).toString()))+"'","kd_rek='"+Utang_Jasa_Sarana_Laborat_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,32).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Laborat_Ralan+"','Beban_Jasa_Perujuk_Laborat_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,32).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,32).toString()))+"'","kd_rek='"+Beban_Jasa_Perujuk_Laborat_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Laborat_Ralan+"','Utang_Jasa_Perujuk_Laborat_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,32).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,32).toString()))+"'","kd_rek='"+Utang_Jasa_Perujuk_Laborat_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,33).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Laborat_Ralan+"','Beban_Jasa_Medik_Dokter_Laborat_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,33).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,33).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Laborat_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Laborat_Ralan+"','Utang_Jasa_Medik_Dokter_Laborat_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,33).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,33).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Laborat_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,34).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Laborat_Ralan+"','Beban_Jasa_Medik_Petugas_Laborat_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,34).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,34).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Laborat_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Laborat_Ralan+"','Utang_Jasa_Medik_Petugas_Laborat_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,34).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,34).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Laborat_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,35).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Laborat_Ralan+"','Beban_Kso_Laborat_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,35).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,35).toString()))+"'","kd_rek='"+Beban_Kso_Laborat_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Laborat_Ralan+"','Utang_Kso_Laborat_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,35).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,35).toString()))+"'","kd_rek='"+Utang_Kso_Laborat_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,36).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Laborat_Ralan+"','Beban_Jasa_Menejemen_Laborat_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,36).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,36).toString()))+"'","kd_rek='"+Beban_Jasa_Menejemen_Laborat_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Laborat_Ralan+"','Utang_Jasa_Menejemen_Laborat_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,36).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,36).toString()))+"'","kd_rek='"+Utang_Jasa_Menejemen_Laborat_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,37).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT JALAN','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,37).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,37).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Laborat_Ralan+"','PENDAPATAN LABORAT RAWAT JALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,37).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,37).toString()))+"'","kd_rek='"+Laborat_Ralan+"'");   
                                }
                                //laborat ranap
                                if(Valid.SetAngka(tabMode.getValueAt(i,38).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Laborat_Ranap+"','Beban_Jasa_Sarana_Laborat_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,38).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,38).toString()))+"'","kd_rek='"+Beban_Jasa_Sarana_Laborat_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Laborat_Ranap+"','Utang_Jasa_Sarana_Laborat_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,38).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,38).toString()))+"'","kd_rek='"+Utang_Jasa_Sarana_Laborat_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,40).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Laborat_Ranap+"','Beban_Jasa_Perujuk_Laborat_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,40).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,40).toString()))+"'","kd_rek='"+Beban_Jasa_Perujuk_Laborat_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Laborat_Ranap+"','Utang_Jasa_Perujuk_Laborat_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,40).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,40).toString()))+"'","kd_rek='"+Utang_Jasa_Perujuk_Laborat_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,41).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Laborat_Ranap+"','Beban_Jasa_Medik_Dokter_Laborat_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,41).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,41).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Laborat_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Laborat_Ranap+"','Utang_Jasa_Medik_Dokter_Laborat_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,41).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,41).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Laborat_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,42).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Laborat_Ranap+"','Beban_Jasa_Medik_Petugas_Laborat_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,42).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,42).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Laborat_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Laborat_Ranap+"','Utang_Jasa_Medik_Petugas_Laborat_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,42).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,42).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Laborat_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,43).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Laborat_Ranap+"','Beban_Kso_Laborat_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,43).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,43).toString()))+"'","kd_rek='"+Beban_Kso_Laborat_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Laborat_Ranap+"','Utang_Kso_Laborat_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,43).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,43).toString()))+"'","kd_rek='"+Utang_Kso_Laborat_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,44).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Laborat_Ranap+"','Beban_Jasa_Menejemen_Laborat_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,44).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,44).toString()))+"'","kd_rek='"+Beban_Jasa_Menejemen_Laborat_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Laborat_Ranap+"','Utang_Jasa_Menejemen_Laborat_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,44).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,44).toString()))+"'","kd_rek='"+Utang_Jasa_Menejemen_Laborat_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,45).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT INAP','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,45).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,45).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Laborat_Ranap+"','PENDAPATAN LABORAT RAWAT INAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,45).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,45).toString()))+"'","kd_rek='"+Laborat_Ranap+"'");   
                                }
                                //radiologi ralan
                                if(Valid.SetAngka(tabMode.getValueAt(i,46).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Radiologi_Ralan+"','Beban_Jasa_Sarana_Radiologi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,46).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,46).toString()))+"'","kd_rek='"+Beban_Jasa_Sarana_Radiologi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Radiologi_Ralan+"','Utang_Jasa_Sarana_Radiologi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,46).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,46).toString()))+"'","kd_rek='"+Utang_Jasa_Sarana_Radiologi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,48).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Radiologi_Ralan+"','Beban_Jasa_Perujuk_Radiologi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,48).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,48).toString()))+"'","kd_rek='"+Beban_Jasa_Perujuk_Radiologi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Radiologi_Ralan+"','Utang_Jasa_Perujuk_Radiologi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,48).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,48).toString()))+"'","kd_rek='"+Utang_Jasa_Perujuk_Radiologi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,49).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Radiologi_Ralan+"','Beban_Jasa_Medik_Dokter_Radiologi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,49).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,49).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Radiologi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Radiologi_Ralan+"','Utang_Jasa_Medik_Dokter_Radiologi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,49).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,49).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Radiologi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,50).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Radiologi_Ralan+"','Beban_Jasa_Medik_Petugas_Radiologi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,50).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,50).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Radiologi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Radiologi_Ralan+"','Utang_Jasa_Medik_Petugas_Radiologi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,50).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,50).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Radiologi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,51).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Radiologi_Ralan+"','Beban_Kso_Radiologi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,51).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,51).toString()))+"'","kd_rek='"+Beban_Kso_Radiologi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Radiologi_Ralan+"','Utang_Kso_Radiologi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,51).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,51).toString()))+"'","kd_rek='"+Utang_Kso_Radiologi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,52).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Radiologi_Ralan+"','Beban_Jasa_Menejemen_Radiologi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,52).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,52).toString()))+"'","kd_rek='"+Beban_Jasa_Menejemen_Radiologi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Radiologi_Ralan+"','Utang_Jasa_Menejemen_Radiologi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,52).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,52).toString()))+"'","kd_rek='"+Utang_Jasa_Menejemen_Radiologi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,53).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT JALAN','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,53).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,53).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Radiologi_Ralan+"','PENDAPATAN RADIOLOGI RAWAT JALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,53).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,53).toString()))+"'","kd_rek='"+Radiologi_Ralan+"'");   
                                }
                                //radiologi ranap
                                if(Valid.SetAngka(tabMode.getValueAt(i,54).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Sarana_Radiologi_Ranap+"','Beban_Jasa_Sarana_Radiologi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,54).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,54).toString()))+"'","kd_rek='"+Beban_Jasa_Sarana_Radiologi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Sarana_Radiologi_Ranap+"','Utang_Jasa_Sarana_Radiologi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,54).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,54).toString()))+"'","kd_rek='"+Utang_Jasa_Sarana_Radiologi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,56).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Perujuk_Radiologi_Ranap+"','Beban_Jasa_Perujuk_Radiologi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,56).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,56).toString()))+"'","kd_rek='"+Beban_Jasa_Perujuk_Radiologi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Perujuk_Radiologi_Ranap+"','Utang_Jasa_Perujuk_Radiologi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,56).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,56).toString()))+"'","kd_rek='"+Utang_Jasa_Perujuk_Radiologi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,57).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Radiologi_Ranap+"','Beban_Jasa_Medik_Dokter_Radiologi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,57).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,57).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Radiologi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Radiologi_Ranap+"','Utang_Jasa_Medik_Dokter_Radiologi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,57).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,57).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Radiologi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,58).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Petugas_Radiologi_Ranap+"','Beban_Jasa_Medik_Petugas_Radiologi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,58).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,58).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Petugas_Radiologi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Petugas_Radiologi_Ranap+"','Utang_Jasa_Medik_Petugas_Radiologi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,58).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,58).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Petugas_Radiologi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,59).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Kso_Radiologi_Ranap+"','Beban_Kso_Radiologi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,59).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,59).toString()))+"'","kd_rek='"+Beban_Kso_Radiologi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Kso_Radiologi_Ranap+"','Utang_Kso_Radiologi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,59).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,59).toString()))+"'","kd_rek='"+Utang_Kso_Radiologi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,60).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Menejemen_Radiologi_Ranap+"','Beban_Jasa_Menejemen_Radiologi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,60).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,60).toString()))+"'","kd_rek='"+Beban_Jasa_Menejemen_Radiologi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Menejemen_Radiologi_Ranap+"','Utang_Jasa_Menejemen_Radiologi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,60).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,60).toString()))+"'","kd_rek='"+Utang_Jasa_Menejemen_Radiologi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,61).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT INAP','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,61).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,61).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Radiologi_Ranap+"','PENDAPATAN RADIOLOGI RAWAT INAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,61).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,61).toString()))+"'","kd_rek='"+Radiologi_Ranap+"'");   
                                }
                                //operasi ralan
                                if(Valid.SetAngka(tabMode.getValueAt(i,62).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Operasi_Ralan+"','Beban_Jasa_Medik_Dokter_Operasi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,62).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,62).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Operasi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Operasi_Ralan+"','Utang_Jasa_Medik_Dokter_Operasi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,62).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,62).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Operasi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,63).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Operasi_Ralan+"','Beban_Jasa_Medik_Paramedis_Operasi_Ralan','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,63).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,63).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Operasi_Ralan+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Operasi_Ralan+"','Utang_Jasa_Medik_Paramedis_Operasi_Ralan','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,63).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,63).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Operasi_Ralan+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,65).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT JALAN','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Operasi_Ralan+"','PENDAPATAN OPERASI RAWAT JALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,65).toString()))+"'","kd_rek='"+Operasi_Ralan+"'");   
                                }
                                //operasi ranap
                                if(Valid.SetAngka(tabMode.getValueAt(i,66).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Dokter_Operasi_Ranap+"','Beban_Jasa_Medik_Dokter_Operasi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,66).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,66).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Dokter_Operasi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Dokter_Operasi_Ranap+"','Utang_Jasa_Medik_Dokter_Operasi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,66).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,66).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Dokter_Operasi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,67).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Beban_Jasa_Medik_Paramedis_Operasi_Ranap+"','Beban_Jasa_Medik_Paramedis_Operasi_Ranap','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,67).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,67).toString()))+"'","kd_rek='"+Beban_Jasa_Medik_Paramedis_Operasi_Ranap+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Utang_Jasa_Medik_Paramedis_Operasi_Ranap+"','Utang_Jasa_Medik_Paramedis_Operasi_Ranap','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,67).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,67).toString()))+"'","kd_rek='"+Utang_Jasa_Medik_Paramedis_Operasi_Ranap+"'");   
                                }
                                if(Valid.SetAngka(tabMode.getValueAt(i,69).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG RAWAT INAP','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Operasi_Ranap+"','PENDAPATAN OPERASI RAWAT INAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,69).toString()))+"'","kd_rek='"+Operasi_Ranap+"'");   
                                }
                                //kamar
                                if(Valid.SetAngka(tabMode.getValueAt(i,78).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,78).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,78).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Kamar_Inap+"','PENDAPATAN KAMAR INAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,78).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,78).toString()))+"'","kd_rek='"+Kamar_Inap+"'");   
                                }
                                //harian
                                if(Valid.SetAngka(tabMode.getValueAt(i,80).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,80).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,80).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Harian_Ranap+"','PENDAPATAN HARIAN KAMAR INAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,80).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,80).toString()))+"'","kd_rek='"+Harian_Ranap+"'");   
                                }
                                //registrasi
                                if(Valid.SetAngka(tabMode.getValueAt(i,81).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,81).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,81).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                        Sequel.menyimpan("tampjurnal","'"+Registrasi_Ralan+"','PENDAPATAN REGISTRASI RALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,81).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,81).toString()))+"'","kd_rek='"+Registrasi_Ralan+"'");
                                    }else{
                                        Sequel.menyimpan("tampjurnal","'"+Registrasi_Ranap+"','PENDAPATAN REGISTRASI RALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,81).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,81).toString()))+"'","kd_rek='"+Registrasi_Ranap+"'");
                                    }
                                }
                                //tambahan biaya
                                if(Valid.SetAngka(tabMode.getValueAt(i,76).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,76).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,76).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                        Sequel.menyimpan("tampjurnal","'"+Tambahan_Ralan+"','PENDAPATAN TAMBAHAN RALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,76).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,76).toString()))+"'","kd_rek='"+Tambahan_Ralan+"'");
                                    }else{
                                        Sequel.menyimpan("tampjurnal","'"+Tambahan_Ranap+"','PENDAPATAN TAMBAHAN RANAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,76).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,76).toString()))+"'","kd_rek='"+Tambahan_Ranap+"'");
                                    }
                                }
                                //potongan biaya
                                if(Valid.SetAngka(tabMode.getValueAt(i,77).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,77).toString()))+"'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,77).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                        Sequel.menyimpan("tampjurnal","'"+Potongan_Ralan+"','POTONGAN RALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,77).toString()))+"','0'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,77).toString()))+"'","kd_rek='"+Potongan_Ralan+"'");
                                    }else{
                                        Sequel.menyimpan("tampjurnal","'"+Potongan_Ranap+"','POTONGAN RANAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,77).toString()))+"','0'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,77).toString()))+"'","kd_rek='"+Potongan_Ranap+"'");
                                    }
                                }
                                //resep pulang
                                if(Valid.SetAngka(tabMode.getValueAt(i,79).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,79).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,79).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Resep_Pulang_Ranap+"','PENDAPATAN RESEP PULANG','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,79).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,79).toString()))+"'","kd_rek='"+Resep_Pulang_Ranap+"'");   
                                }
                                //obat langsung
                                if(Valid.SetAngka(tabMode.getValueAt(i,70).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,70).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,70).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    if(tbBangsal.getValueAt(i,14).toString().equals("Ralan")){
                                        Sequel.menyimpan("tampjurnal","'"+Obat_Ralan+"','OBAT LANGSUNG RALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,70).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,70).toString()))+"'","kd_rek='"+Obat_Ralan+"'");
                                    }else{
                                        Sequel.menyimpan("tampjurnal","'"+Obat_Ranap+"','OBAT LANGSUNG RANAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,70).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,70).toString()))+"'","kd_rek='"+Obat_Ranap+"'");
                                    }
                                }
                                //obat ralan
                                if(Valid.SetAngka(tabMode.getValueAt(i,71).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,71).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,71).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Obat_Ralan+"','PENDAPATAN OBAT RALAN','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,71).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,71).toString()))+"'","kd_rek='"+Obat_Ralan+"'");   
                                }
                                //obat ranap
                                if(Valid.SetAngka(tabMode.getValueAt(i,73).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,73).toString()))+"'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,73).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Obat_Ranap+"','PENDAPATAN OBAT RANAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,73).toString()))+"','0'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,73).toString()))+"'","kd_rek='"+Obat_Ranap+"'");   
                                }
                                //retur obat ranap
                                if(Valid.SetAngka(tabMode.getValueAt(i,75).toString())>0){
                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,75).toString()))+"'","kredit=kredit+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,75).toString()))+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+Retur_Obat_Ranap+"','PENDAPATAN OBAT RANAP','"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,75).toString()))+"','0'","debet=debet+'"+((Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100) * Valid.SetAngka(tabMode.getValueAt(i,75).toString()))+"'","kd_rek='"+Retur_Obat_Ranap+"'");   
                                }
                                //jurnal ulang beban, utang, piutang, pendapatan
                                sukses=jur.simpanJurnal(tabMode.getValueAt(i,1).toString(),Valid.SetTgl(Tanggal.getSelectedItem()+""),"U","PEMBATALAN PIUTANG PASIEN BPJS, OLEH "+kdptg.getText());     
                                if(sukses==true){
                                    //jurnal kerugian 
                                    Sequel.queryu("delete from tampjurnal");
                                    if(Valid.SetAngka(tabMode.getValueAt(i,12).toString())>0){
                                        Sequel.menyimpan("tampjurnal","'"+Kerugian_Klaim_BPJS_RVP+"','KERUGIAN KLAIM BPJS','"+tabMode.getValueAt(i,12).toString()+"','0'","debet=debet+'"+tabMode.getValueAt(i,12).toString()+"'","kd_rek='"+Kerugian_Klaim_BPJS_RVP+"'");  
                                    }

                                    Sequel.menyimpan("tampjurnal","'"+Piutang_BPJS_RVP+"','PIUTANG BPJS','0','"+tabMode.getValueAt(i,8).toString()+"'","kredit=kredit+'"+tabMode.getValueAt(i,8).toString()+"'","kd_rek='"+Piutang_BPJS_RVP+"'");     
                                    Sequel.menyimpan("tampjurnal","'"+koderekening+"','"+nama_bayar.getSelectedItem()+"','"+tabMode.getValueAt(i,10).toString()+"','0'","debet=debet+'"+tabMode.getValueAt(i,10).toString()+"'","kd_rek='"+koderekening+"'"); 
                                    sukses=jur.simpanJurnal(tabMode.getValueAt(i,1).toString(),Valid.SetTgl(Tanggal.getSelectedItem()+""),"U","BAYAR PIUTANG BPJS"+", OLEH "+kdptg.getText()); 
                                    
                                    if(sukses==true){
                                        //update RVP Rawat jalan
                                        if(Sequel.queryutf("update rawat_jl_dr set material=material*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakandr=tarif_tindakandr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_rawat=biaya_rawat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        if(Sequel.queryutf("update rawat_jl_pr set material=material*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakanpr=tarif_tindakanpr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_rawat=biaya_rawat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        if(Sequel.queryutf("update rawat_jl_drpr set material=material*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakandr=tarif_tindakandr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakanpr=tarif_tindakanpr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_rawat=biaya_rawat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update RVP Rawat inap
                                        if(Sequel.queryutf("update rawat_inap_dr set material=material*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakandr=tarif_tindakandr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_rawat=biaya_rawat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        if(Sequel.queryutf("update rawat_inap_pr set material=material*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakanpr=tarif_tindakanpr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_rawat=biaya_rawat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        if(Sequel.queryutf("update rawat_inap_drpr set material=material*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakandr=tarif_tindakandr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakanpr=tarif_tindakanpr*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_rawat=biaya_rawat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp laborat
                                        if(Sequel.queryutf("update periksa_lab set bagian_rs=bagian_rs*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_perujuk=tarif_perujuk*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakan_dokter=tarif_tindakan_dokter*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakan_petugas=tarif_tindakan_petugas*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya=biaya*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        if(Sequel.queryutf("update detail_periksa_lab set bagian_rs=bagian_rs*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",bagian_perujuk=bagian_perujuk*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",bagian_dokter=bagian_dokter*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",bagian_laborat=bagian_laborat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_item=biaya_item*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp radiologi
                                        if(Sequel.queryutf("update periksa_radiologi set bagian_rs=bagian_rs*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_perujuk=tarif_perujuk*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakan_dokter=tarif_tindakan_dokter*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tarif_tindakan_petugas=tarif_tindakan_petugas*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",kso=kso*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",menejemen=menejemen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya=biaya*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp operasi
                                        if(Sequel.queryutf("update operasi set biayaoperator1=biayaoperator1*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaoperator2=biayaoperator2*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaoperator3=biayaoperator3*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaasisten_operator1=biayaasisten_operator1*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaasisten_operator2=biayaasisten_operator2*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaasisten_operator3=biayaasisten_operator3*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayainstrumen=biayainstrumen*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayadokter_anak=biayadokter_anak*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaperawaat_resusitas=biayaperawaat_resusitas*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayadokter_anestesi=biayadokter_anestesi*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaasisten_anestesi=biayaasisten_anestesi*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaasisten_anestesi2=biayaasisten_anestesi2*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayabidan=biayabidan*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayabidan2=biayabidan2*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayabidan3=biayabidan3*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaperawat_luar=biayaperawat_luar*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayaalat=biayaalat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayasewaok=biayasewaok*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",akomodasi=akomodasi*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",bagian_rs=bagian_rs*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_omloop=biaya_omloop*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_omloop2=biaya_omloop2*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_omloop3=biaya_omloop3*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_omloop4=biaya_omloop4*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_omloop5=biaya_omloop5*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biayasarpras=biayasarpras*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_dokter_pjanak=biaya_dokter_pjanak*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",biaya_dokter_umum=biaya_dokter_umum*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp kamar
                                        if(Sequel.queryutf("update kamar_inap set trf_kamar=trf_kamar*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",ttl_biaya=ttl_biaya*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp registrasi
                                        if(Sequel.queryutf("update reg_periksa set biaya_reg=biaya_reg*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp tambahan biaya
                                        if(Sequel.queryutf("update tambahan_biaya set besar_biaya=besar_biaya*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp pengurangan biaya
                                        if(Sequel.queryutf("update pengurangan_biaya set besar_pengurangan=besar_pengurangan*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp resep pulang
                                        if(Sequel.queryutf("update resep_pulang set harga=harga*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",total=total*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp obat langsung
                                        if(Sequel.queryutf("update tagihan_obat_langsung set besar_tagihan=besar_tagihan*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp obat
                                        if(Sequel.queryutf("update detail_pemberian_obat set biaya_obat=biaya_obat*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",total=total*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",embalase=embalase*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",tuslah=tuslah*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_rawat='"+tabMode.getValueAt(i,1).toString()+"'")==false){
                                            sukses=false;
                                        }
                                        //update rvp retur obat
                                        if(Sequel.queryutf("update detreturjual set h_retur=h_retur*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+",subtotal=subtotal*"+(Valid.SetAngka(tabMode.getValueAt(i,11).toString())/100)+" where no_retur_jual like '%"+tabMode.getValueAt(i,1).toString()+"%'")==false){
                                            sukses=false;
                                        }
                                    }
                                }
                            }*/
                        }       

                        if(sukses==true){
                            if(Sequel.menyimpantf2("rvp_klaim_bpjs","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","No.Rawat",81,new String[]{
                                    tabMode.getValueAt(i,1).toString(),Valid.SetTgl(Tanggal.getSelectedItem()+""),kdptg.getText(),tabMode.getValueAt(i,5).toString(),tabMode.getValueAt(i,6).toString(),tabMode.getValueAt(i,7).toString(),tabMode.getValueAt(i,8).toString(),
                                    tabMode.getValueAt(i,9).toString(),tabMode.getValueAt(i,10).toString(),tabMode.getValueAt(i,11).toString(),tabMode.getValueAt(i,12).toString(),tabMode.getValueAt(i,13).toString(),tabMode.getValueAt(i,16).toString(),
                                    tabMode.getValueAt(i,17).toString(),tabMode.getValueAt(i,18).toString(),tabMode.getValueAt(i,19).toString(),tabMode.getValueAt(i,20).toString(),tabMode.getValueAt(i,21).toString(),tabMode.getValueAt(i,22).toString(),
                                    tabMode.getValueAt(i,23).toString(),tabMode.getValueAt(i,24).toString(),tabMode.getValueAt(i,25).toString(),tabMode.getValueAt(i,26).toString(),tabMode.getValueAt(i,27).toString(),tabMode.getValueAt(i,28).toString(),
                                    tabMode.getValueAt(i,29).toString(),tabMode.getValueAt(i,30).toString(),tabMode.getValueAt(i,31).toString(),tabMode.getValueAt(i,32).toString(),tabMode.getValueAt(i,33).toString(),tabMode.getValueAt(i,34).toString(),
                                    tabMode.getValueAt(i,35).toString(),tabMode.getValueAt(i,36).toString(),tabMode.getValueAt(i,37).toString(),tabMode.getValueAt(i,38).toString(),tabMode.getValueAt(i,39).toString(),tabMode.getValueAt(i,40).toString(),
                                    tabMode.getValueAt(i,41).toString(),tabMode.getValueAt(i,42).toString(),tabMode.getValueAt(i,43).toString(),tabMode.getValueAt(i,44).toString(),tabMode.getValueAt(i,45).toString(),tabMode.getValueAt(i,46).toString(),
                                    tabMode.getValueAt(i,47).toString(),tabMode.getValueAt(i,48).toString(),tabMode.getValueAt(i,49).toString(),tabMode.getValueAt(i,50).toString(),tabMode.getValueAt(i,51).toString(),tabMode.getValueAt(i,52).toString(),
                                    tabMode.getValueAt(i,53).toString(),tabMode.getValueAt(i,54).toString(),tabMode.getValueAt(i,55).toString(),tabMode.getValueAt(i,56).toString(),tabMode.getValueAt(i,57).toString(),tabMode.getValueAt(i,58).toString(),
                                    tabMode.getValueAt(i,59).toString(),tabMode.getValueAt(i,60).toString(),tabMode.getValueAt(i,61).toString(),tabMode.getValueAt(i,62).toString(),tabMode.getValueAt(i,63).toString(),tabMode.getValueAt(i,64).toString(),
                                    tabMode.getValueAt(i,65).toString(),tabMode.getValueAt(i,66).toString(),tabMode.getValueAt(i,67).toString(),tabMode.getValueAt(i,68).toString(),tabMode.getValueAt(i,69).toString(),tabMode.getValueAt(i,70).toString(),
                                    tabMode.getValueAt(i,71).toString(),tabMode.getValueAt(i,72).toString(),tabMode.getValueAt(i,73).toString(),tabMode.getValueAt(i,74).toString(),tabMode.getValueAt(i,75).toString(),tabMode.getValueAt(i,76).toString(),
                                    tabMode.getValueAt(i,77).toString(),tabMode.getValueAt(i,78).toString(),tabMode.getValueAt(i,79).toString(),tabMode.getValueAt(i,80).toString(),tabMode.getValueAt(i,81).toString(),tabMode.getValueAt(i,2).toString(),
                                    koderekening,Piutang_BPJS_RVP
                                })==false){
                                    sukses=false;
                            }
                        }
                    }else{
                        sukses=false;
                    }
                }
            }
            
            if(sukses==true){
                Sequel.Commit();
            }else{
                sukses=false;
                JOptionPane.showMessageDialog(null,"Terjadi kesalahan saat pemrosesan data, transaksi dibatalkan.\nPeriksa kembali data sebelum melanjutkan menyimpan..!!");
                Sequel.RollBack();
            }
            
            Sequel.AutoComitTrue();
            
            if(sukses==true){
                tampil();
            }
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_BtnBayarActionPerformed

    private void BtnBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBayarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBayarKeyPressed

    private void nama_bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_bayarKeyPressed
        Valid.pindah(evt,Tanggal,TCari);
    }//GEN-LAST:event_nama_bayarKeyPressed

    private void TanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKeyPressed
        Valid.pindah(evt,kdptg,nama_bayar);
    }//GEN-LAST:event_TanggalKeyPressed

    private void tbBangsalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBangsalMouseClicked
        if(tabMode.getRowCount()!=0){
            if(tbBangsal.getSelectedColumn()==0){
                getdata();
            }
        }
    }//GEN-LAST:event_tbBangsalMouseClicked

    private void tbBangsalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbBangsalPropertyChange
        if(this.isVisible()==true){
            try {
                if(tbBangsal.getSelectedRow()!= -1){
                    if(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),0).toString().equals("true")){
                        tbBangsal.setValueAt((( (Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),10).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),6).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),7).toString())) / Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),5).toString()) )*100),tbBangsal.getSelectedRow(),11);
                        selisih=0;
                        selisih=(Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),10).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),6).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),7).toString()))-Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),5).toString());
                        if(selisih>=0){
                            tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),12);
                            tbBangsal.setValueAt(selisih,tbBangsal.getSelectedRow(),13);
                        }else{
                            selisih=( (Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),17).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),24).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),31).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),39).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),47).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),55).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),64).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),68).toString())) * 
                                    ((100-Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),11).toString()))/100) );
                            rugihpp=(Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),72).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),74).toString())-Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),75).toString()))-( (Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),79).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),70).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),71).toString())+Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),73).toString())-Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),75).toString())) * (Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),11).toString())/100) );
                            if(rugihpp>0){
                                selisih=selisih+rugihpp;
                            }
                            tbBangsal.setValueAt(selisih,tbBangsal.getSelectedRow(),12);
                            tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),13);
                        }
                    }
                }
            } catch (Exception e) {
            }
            row=tbBangsal.getRowCount();
            total=0;
            lebih=0;
            rugi=0;
            for(i=0;i<row;i++){  
                if(tbBangsal.getValueAt(i,0).toString().equals("true")){
                    try {
                        total=total+Valid.SetAngka(tbBangsal.getValueAt(i,10).toString()); 
                    } catch (Exception e) {
                    }

                    try {
                       rugi=rugi+Valid.SetAngka(tbBangsal.getValueAt(i,12).toString());
                    } catch (Exception e) {
                    }

                    try {
                       lebih=lebih+Valid.SetAngka(tbBangsal.getValueAt(i,13).toString());
                    } catch (Exception e) {
                    }
                }
            }
            LCount1.setText(Valid.SetAngka(total));
            LCount2.setText(Valid.SetAngka(rugi));
            LCount3.setText(Valid.SetAngka(lebih));
        }
    }//GEN-LAST:event_tbBangsalPropertyChange

    private void btnPetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasKeyPressed
        //Valid.pindah(evt,DTPCari2,TCari);
    }//GEN-LAST:event_btnPetugasKeyPressed

    private void btnPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasActionPerformed
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setAlwaysOnTop(false);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasActionPerformed

    private void kdptgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdptgKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            Sequel.cariIsi("select nama from petugas where nip=?", nmptg,kdptg.getText());           
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            Sequel.cariIsi("select nama from petugas where nip=?", nmptg,kdptg.getText()); 
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Sequel.cariIsi("select nama from petugas where nip=?", nmptg,kdptg.getText()); 
        }else if(evt.getKeyCode()==KeyEvent.VK_UP){
            btnPetugasActionPerformed(null);
        }
    }//GEN-LAST:event_kdptgKeyPressed

    private void BtnCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCari1ActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        KeuanganCariRVPBPJS form=new KeuanganCariRVPBPJS(null,false);
        form.isCek();
        form.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        form.setLocationRelativeTo(internalFrame1);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnCari1ActionPerformed

    private void BtnCari1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCari1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnCari,BtnKeluar);
        }
    }//GEN-LAST:event_BtnCari1KeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            KeuanganRVPBPJS dialog = new KeuanganRVPBPJS(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnBayar;
    private widget.Button BtnCari;
    private widget.Button BtnCari1;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private javax.swing.JLabel LCount;
    private javax.swing.JLabel LCount1;
    private javax.swing.JLabel LCount2;
    private javax.swing.JLabel LCount3;
    private javax.swing.JMenuItem MnDetailPiutang;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.TextBox TKd;
    private widget.Tanggal Tanggal;
    private widget.Button btnPetugas;
    private widget.InternalFrame internalFrame1;
    private javax.swing.JLabel jLabel10;
    private widget.Label jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private widget.TextBox kdptg;
    private widget.Label label17;
    private widget.Label label19;
    private widget.Label label33;
    private widget.ComboBox nama_bayar;
    private widget.TextBox nmptg;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi3;
    private widget.panelisi panelisi4;
    private widget.Table tbBangsal;
    // End of variables declaration//GEN-END:variables

    public void tampil(){
        Valid.tabelKosong(tabMode);
        try{
            sisapiutang=0;
            ps=koneksi.prepareStatement(
                   "select piutang_pasien.no_rawat,piutang_pasien.tgl_piutang, concat(piutang_pasien.no_rkm_medis,' ',pasien.nm_pasien) as namapasien, "+
                   "piutang_pasien.totalpiutang,piutang_pasien.uangmuka,piutang_pasien.sisapiutang,bridging_sep.no_sep,inacbg_grouping_stage1.tarif, "+
                   "reg_periksa.biaya_reg,reg_periksa.status_lanjut from piutang_pasien inner join pasien on piutang_pasien.no_rkm_medis=pasien.no_rkm_medis "+
                   "inner join reg_periksa on piutang_pasien.no_rawat=reg_periksa.no_rawat "+
                   "inner join bridging_sep on bridging_sep.no_rawat=reg_periksa.no_rawat "+
                   "inner join inacbg_grouping_stage1 on bridging_sep.no_sep=inacbg_grouping_stage1.no_sep "+
                   "where piutang_pasien.status='Belum Lunas' "+
                   (TCari.getText().trim().equals("")?"":"and (piutang_pasien.no_rawat like ? or piutang_pasien.no_rkm_medis like ? "+
                   "or pasien.nm_pasien like ? or bridging_sep.no_sep like ? or reg_periksa.status_lanjut like ?)")+" order by piutang_pasien.tgl_piutang");
            try {
                if(!TCari.getText().equals("")){
                    ps.setString(1,"%"+TCari.getText()+"%");
                    ps.setString(2,"%"+TCari.getText()+"%");
                    ps.setString(3,"%"+TCari.getText()+"%");
                    ps.setString(4,"%"+TCari.getText()+"%");
                    ps.setString(5,"%"+TCari.getText()+"%");
                }
                    
                rs=ps.executeQuery();
                while(rs.next()){
                    cicilan=Sequel.cariIsiAngka("SELECT ifnull(SUM(bayar_piutang.besar_cicilan),0) FROM bayar_piutang where bayar_piutang.no_rawat=?",rs.getString("no_rawat"));
                    tabMode.addRow(new Object[]{
                        false,rs.getString("no_rawat"),rs.getString("no_sep"),rs.getString("tgl_piutang"),rs.getString("namapasien"),
                        rs.getDouble("totalpiutang"),rs.getDouble("uangmuka"),cicilan,(rs.getDouble("sisapiutang")-cicilan),
                        rs.getDouble("tarif"),null,0,0,0,rs.getString("status_lanjut"),rs.getDouble("biaya_reg"),0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0
                    });
                    sisapiutang=sisapiutang+rs.getDouble("sisapiutang")-cicilan;
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            
            ps=koneksi.prepareStatement(
                   "select piutang_pasien.no_rawat,piutang_pasien.tgl_piutang, concat(piutang_pasien.no_rkm_medis,' ',pasien.nm_pasien) as namapasien, "+
                   "piutang_pasien.totalpiutang,piutang_pasien.uangmuka,piutang_pasien.sisapiutang,inacbg_klaim_baru2.no_sep,inacbg_grouping_stage12.tarif, "+
                   "reg_periksa.biaya_reg,reg_periksa.status_lanjut from piutang_pasien inner join pasien on piutang_pasien.no_rkm_medis=pasien.no_rkm_medis "+
                   "inner join reg_periksa on piutang_pasien.no_rawat=reg_periksa.no_rawat "+
                   "inner join inacbg_klaim_baru2 on inacbg_klaim_baru2.no_rawat=reg_periksa.no_rawat "+
                   "inner join inacbg_grouping_stage12 on inacbg_klaim_baru2.no_sep=inacbg_grouping_stage12.no_sep "+
                   "where piutang_pasien.status='Belum Lunas' "+
                   (TCari.getText().trim().equals("")?"":"and (piutang_pasien.no_rawat like ? or piutang_pasien.no_rkm_medis like ? "+
                   "or pasien.nm_pasien like ? or inacbg_klaim_baru2.no_sep like ? or reg_periksa.status_lanjut like ?)")+" order by piutang_pasien.tgl_piutang");
            try {
                if(!TCari.getText().equals("")){
                    ps.setString(1,"%"+TCari.getText()+"%");
                    ps.setString(2,"%"+TCari.getText()+"%");
                    ps.setString(3,"%"+TCari.getText()+"%");
                    ps.setString(4,"%"+TCari.getText()+"%");
                    ps.setString(5,"%"+TCari.getText()+"%");
                }
                    
                rs=ps.executeQuery();
                while(rs.next()){
                    cicilan=Sequel.cariIsiAngka("SELECT ifnull(SUM(bayar_piutang.besar_cicilan),0) FROM bayar_piutang where bayar_piutang.no_rawat=?",rs.getString("no_rawat"));
                    tabMode.addRow(new Object[]{
                        false,rs.getString("no_rawat"),rs.getString("no_sep"),rs.getString("tgl_piutang"),rs.getString("namapasien"),
                        rs.getDouble("totalpiutang"),rs.getDouble("uangmuka"),cicilan,(rs.getDouble("sisapiutang")-cicilan),
                        rs.getDouble("tarif"),null,0,0,0,rs.getString("status_lanjut"),rs.getDouble("biaya_reg"),0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0
                    });
                    sisapiutang=sisapiutang+rs.getDouble("sisapiutang")-cicilan;
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            LCount.setText(Valid.SetAngka(sisapiutang));
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
    }
    
    private void getdata() {
        try {
            if(tbBangsal.getSelectedRow()!= -1){
                if(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),0).toString().equals("true")){
                    tbBangsal.setValueAt(Double.parseDouble(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),9).toString()),tbBangsal.getSelectedRow(),10);
                    tbBangsal.setValueAt((( (Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),10).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),6).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),7).toString())) / Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),5).toString()) )*100),tbBangsal.getSelectedRow(),11);
                    materialralan=0;bhpralan=0;tarif_tindakandrralan=0;tarif_tindakanprralan=0;ksoralan=0;menejemenralan=0;biaya_rawatralan=0;
                    materialranap=0;bhpranap=0;tarif_tindakandrranap=0;tarif_tindakanprranap=0;ksoranap=0;menejemenranap=0;biaya_rawatranap=0;
                    bagian_rslabralan=0;bhplabralan=0;tarif_perujuklabralan=0;tarif_tindakan_dokterlabralan=0;tarif_tindakan_petugaslabralan=0;ksolabralan=0;menejemenlabralan=0;biayalabralan=0;
                    bagian_rslabranap=0;bhplabranap=0;tarif_perujuklabranap=0;tarif_tindakan_dokterlabranap=0;tarif_tindakan_petugaslabranap=0;ksolabranap=0;menejemenlabranap=0;biayalabranap=0;
                    bagian_rsradiologiralan=0;bhpradiologiralan=0;tarif_perujukradiologiralan=0;tarif_tindakan_dokterradiologiralan=0;tarif_tindakan_petugasradiologiralan=0;ksoradiologiralan=0;menejemenradiologiralan=0;biayaradiologiralan=0;
                    bagian_rsradiologiranap=0;bhpradiologiranap=0;tarif_perujukradiologiranap=0;tarif_tindakan_dokterradiologiranap=0;tarif_tindakan_petugasradiologiranap=0;ksoradiologiranap=0;menejemenradiologiranap=0;biayaradiologiranap=0;
                    jmdokteroperasiralan=0;jmparamedisoperasiralan=0;bhpoperasiralan=0;pendapatanoperasiralan=0;
                    jmdokteroperasiranap=0;jmparamedisoperasiranap=0;bhpoperasiranap=0;pendapatanoperasiranap=0;
                    obatlangsung=0;obatralan=0;hppobatralan=0;obatranap=0;hppobatranap=0;returobat=0;tambahanbiaya=0;potonganbiaya=0;
                    kamar=0;reseppulang=0;norawatbayi="";registrasi=0;harianranap=0;
                    status=tbBangsal.getValueAt(tbBangsal.getSelectedRow(),14).toString();
                    registrasi=Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),15).toString());
                    //cek obat langsung
                    obatlangsung=Sequel.cariIsiAngka("select besar_tagihan from tagihan_obat_langsung where no_rawat=? ",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                    //cek tambahan biaya
                    tambahanbiaya=Sequel.cariIsiAngka("select sum(besar_biaya) from tambahan_biaya where no_rawat=? ",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                    //cek potongan biaya
                    potonganbiaya=Sequel.cariIsiAngka("select sum(besar_pengurangan) from pengurangan_biaya where no_rawat=? ",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                    //cek rawat jalan
                    ps=koneksi.prepareStatement(
                            "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                            "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_jl_drpr where no_rawat=?");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        if(rs.next()){
                            materialralan=rs.getDouble("material");
                            bhpralan=rs.getDouble("bhp");
                            tarif_tindakandrralan=rs.getDouble("tarif_tindakandr");
                            tarif_tindakanprralan=rs.getDouble("tarif_tindakanpr");
                            ksoralan=rs.getDouble("kso");
                            menejemenralan=rs.getDouble("menejemen");
                            biaya_rawatralan=rs.getDouble("biaya_rawat");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    ps=koneksi.prepareStatement(
                            "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,"+
                            "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_jl_dr where no_rawat=?");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        if(rs.next()){
                            materialralan=+materialralan+rs.getDouble("material");
                            bhpralan=bhpralan+rs.getDouble("bhp");
                            tarif_tindakandrralan=tarif_tindakandrralan+rs.getDouble("tarif_tindakandr");
                            ksoralan=ksoralan+rs.getDouble("kso");
                            menejemenralan=menejemenralan+rs.getDouble("menejemen");
                            biaya_rawatralan=biaya_rawatralan+rs.getDouble("biaya_rawat");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    ps=koneksi.prepareStatement(
                            "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                            "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_jl_pr where no_rawat=?");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        if(rs.next()){
                            materialralan=+materialralan+rs.getDouble("material");
                            bhpralan=bhpralan+rs.getDouble("bhp");
                            tarif_tindakanprralan=tarif_tindakanprralan+rs.getDouble("tarif_tindakanpr");
                            ksoralan=ksoralan+rs.getDouble("kso");
                            menejemenralan=menejemenralan+rs.getDouble("menejemen");
                            biaya_rawatralan=biaya_rawatralan+rs.getDouble("biaya_rawat");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    //cek lab ralan
                    ps=koneksi.prepareStatement(
                            "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                            "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_lab "+
                            "where no_rawat=? and status='Ralan'");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        if(rs.next()){
                            bagian_rslabralan=rs.getDouble("bagian_rs");
                            bhplabralan=rs.getDouble("bhp");
                            tarif_perujuklabralan=rs.getDouble("tarif_perujuk");
                            tarif_tindakan_dokterlabralan=rs.getDouble("tarif_tindakan_dokter");
                            tarif_tindakan_petugaslabralan=rs.getDouble("tarif_tindakan_petugas");
                            ksolabralan=rs.getDouble("kso");
                            menejemenlabralan=rs.getDouble("menejemen");
                            biayalabralan=rs.getDouble("biaya");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    ps=koneksi.prepareStatement(
                            "select sum(detail_periksa_lab.bagian_rs) as bagian_rs,sum(detail_periksa_lab.bhp) as bhp,sum(detail_periksa_lab.bagian_perujuk) as bagian_perujuk,"+
                            "sum(detail_periksa_lab.bagian_dokter) as bagian_dokter,sum(detail_periksa_lab.bagian_laborat) as bagian_laborat,sum(detail_periksa_lab.kso) as kso,"+
                            "sum(detail_periksa_lab.menejemen) as menejemen,sum(detail_periksa_lab.biaya_item) as biaya_item from detail_periksa_lab inner join periksa_lab on "+
                            "detail_periksa_lab.no_rawat=periksa_lab.no_rawat and detail_periksa_lab.kd_jenis_prw=periksa_lab.kd_jenis_prw and detail_periksa_lab.tgl_periksa=periksa_lab.tgl_periksa "+
                            "and detail_periksa_lab.jam=periksa_lab.jam where detail_periksa_lab.no_rawat=? and periksa_lab.status='Ralan'");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        if(rs.next()){
                            bagian_rslabralan=bagian_rslabralan+rs.getDouble("bagian_rs");
                            bhplabralan=bhplabralan+rs.getDouble("bhp");
                            tarif_perujuklabralan=tarif_perujuklabralan+rs.getDouble("bagian_perujuk");
                            tarif_tindakan_dokterlabralan=tarif_tindakan_dokterlabralan+rs.getDouble("bagian_dokter");
                            tarif_tindakan_petugaslabralan=tarif_tindakan_petugaslabralan+rs.getDouble("bagian_laborat");
                            ksolabralan=ksolabralan+rs.getDouble("kso");
                            menejemenlabralan=menejemenlabralan+rs.getDouble("menejemen");
                            biayalabralan=biayalabralan+rs.getDouble("biaya_item");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    //cek radiologi ralan
                    ps=koneksi.prepareStatement(
                            "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                            "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_radiologi "+
                            "where no_rawat=? and status='Ralan'");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        if(rs.next()){
                            bagian_rsradiologiralan=rs.getDouble("bagian_rs");
                            bhpradiologiralan=rs.getDouble("bhp");
                            tarif_perujukradiologiralan=rs.getDouble("tarif_perujuk");
                            tarif_tindakan_dokterradiologiralan=rs.getDouble("tarif_tindakan_dokter");
                            tarif_tindakan_petugasradiologiralan=rs.getDouble("tarif_tindakan_petugas");
                            ksoradiologiralan=rs.getDouble("kso");
                            menejemenradiologiralan=rs.getDouble("menejemen");
                            biayaradiologiralan=rs.getDouble("biaya");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    //cek operasi ralan
                    ps=koneksi.prepareStatement(
                            "select sum(biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as jmdokter, "+
                            "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5) as jmparamedis,"+
                            "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5+biayaalat+biayasewaok+akomodasi+bagian_rs+biayasarpras+biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as pendapatan "+
                            "from operasi where no_rawat=? and status='Ralan'");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        if(rs.next()){
                            jmdokteroperasiralan=rs.getDouble("jmdokter");
                            jmparamedisoperasiralan=rs.getDouble("jmparamedis");
                            pendapatanoperasiralan=rs.getDouble("pendapatan");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    bhpoperasiralan=Sequel.cariIsiAngka("select sum(beri_obat_operasi.hargasatuan*beri_obat_operasi.jumlah) from beri_obat_operasi inner join operasi on beri_obat_operasi.no_rawat=operasi.no_rawat and beri_obat_operasi.tanggal=operasi.tgl_operasi where operasi.status='Ralan' and beri_obat_operasi.no_rawat=?",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                    //cek obat rawat jalan
                    ps=koneksi.prepareStatement("select sum(h_beli*jml) as hpp,sum(total) as total from detail_pemberian_obat where no_rawat=? and status='Ralan'");
                    try {
                        ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        rs=ps.executeQuery();
                        while(rs.next()){
                            obatralan=rs.getDouble("total");
                            hppobatralan=rs.getDouble("hpp");
                        }
                    } catch (Exception e) {
                        System.out.println("Notif : "+e);
                    } finally{
                        if(rs!=null){
                            rs.close();
                        }
                        if(ps!=null){
                            ps.close();
                        }
                    }
                    if(status.equals("Ranap")){
                        //cek rawat inap
                        ps=koneksi.prepareStatement(
                                "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                                "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_inap_drpr where no_rawat=?");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            if(rs.next()){
                                materialranap=rs.getDouble("material");
                                bhpranap=rs.getDouble("bhp");
                                tarif_tindakandrranap=rs.getDouble("tarif_tindakandr");
                                tarif_tindakanprranap=rs.getDouble("tarif_tindakanpr");
                                ksoranap=rs.getDouble("kso");
                                menejemenranap=rs.getDouble("menejemen");
                                biaya_rawatranap=rs.getDouble("biaya_rawat");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        ps=koneksi.prepareStatement(
                                "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,"+
                                "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_inap_dr where no_rawat=?");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            if(rs.next()){
                                materialranap=+materialranap+rs.getDouble("material");
                                bhpranap=bhpranap+rs.getDouble("bhp");
                                tarif_tindakandrranap=tarif_tindakandrranap+rs.getDouble("tarif_tindakandr");
                                ksoranap=ksoranap+rs.getDouble("kso");
                                menejemenranap=menejemenranap+rs.getDouble("menejemen");
                                biaya_rawatranap=biaya_rawatranap+rs.getDouble("biaya_rawat");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        ps=koneksi.prepareStatement(
                                "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                                "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_inap_pr where no_rawat=?");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            if(rs.next()){
                                materialranap=+materialranap+rs.getDouble("material");
                                bhpranap=bhpranap+rs.getDouble("bhp");
                                tarif_tindakanprranap=tarif_tindakanprranap+rs.getDouble("tarif_tindakanpr");
                                ksoranap=ksoranap+rs.getDouble("kso");
                                menejemenranap=menejemenranap+rs.getDouble("menejemen");
                                biaya_rawatranap=biaya_rawatranap+rs.getDouble("biaya_rawat");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        //cek lab ranap
                        ps=koneksi.prepareStatement(
                                "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                                "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_lab "+
                                "where no_rawat=? and status='Ranap'");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            if(rs.next()){
                                bagian_rslabranap=rs.getDouble("bagian_rs");
                                bhplabranap=rs.getDouble("bhp");
                                tarif_perujuklabranap=rs.getDouble("tarif_perujuk");
                                tarif_tindakan_dokterlabranap=rs.getDouble("tarif_tindakan_dokter");
                                tarif_tindakan_petugaslabranap=rs.getDouble("tarif_tindakan_petugas");
                                ksolabranap=rs.getDouble("kso");
                                menejemenlabranap=rs.getDouble("menejemen");
                                biayalabranap=rs.getDouble("biaya");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        ps=koneksi.prepareStatement(
                                "select sum(detail_periksa_lab.bagian_rs) as bagian_rs,sum(detail_periksa_lab.bhp) as bhp,sum(detail_periksa_lab.bagian_perujuk) as bagian_perujuk,"+
                                "sum(detail_periksa_lab.bagian_dokter) as bagian_dokter,sum(detail_periksa_lab.bagian_laborat) as bagian_laborat,sum(detail_periksa_lab.kso) as kso,"+
                                "sum(detail_periksa_lab.menejemen) as menejemen,sum(detail_periksa_lab.biaya_item) as biaya_item from detail_periksa_lab inner join periksa_lab on "+
                                "detail_periksa_lab.no_rawat=periksa_lab.no_rawat and detail_periksa_lab.kd_jenis_prw=periksa_lab.kd_jenis_prw and detail_periksa_lab.tgl_periksa=periksa_lab.tgl_periksa "+
                                "and detail_periksa_lab.jam=periksa_lab.jam where detail_periksa_lab.no_rawat=? and periksa_lab.status='Ranap'");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            if(rs.next()){
                                bagian_rslabranap=bagian_rslabranap+rs.getDouble("bagian_rs");
                                bhplabranap=bhplabranap+rs.getDouble("bhp");
                                tarif_perujuklabranap=tarif_perujuklabranap+rs.getDouble("bagian_perujuk");
                                tarif_tindakan_dokterlabranap=tarif_tindakan_dokterlabranap+rs.getDouble("bagian_dokter");
                                tarif_tindakan_petugaslabranap=tarif_tindakan_petugaslabranap+rs.getDouble("bagian_laborat");
                                ksolabranap=ksolabranap+rs.getDouble("kso");
                                menejemenlabranap=menejemenlabranap+rs.getDouble("menejemen");
                                biayalabranap=biayalabranap+rs.getDouble("biaya_item");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        //cek radiologi ranap
                        ps=koneksi.prepareStatement(
                                "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                                "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_radiologi "+
                                "where no_rawat=? and status='Ranap'");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            if(rs.next()){
                                bagian_rsradiologiranap=rs.getDouble("bagian_rs");
                                bhpradiologiranap=rs.getDouble("bhp");
                                tarif_perujukradiologiranap=rs.getDouble("tarif_perujuk");
                                tarif_tindakan_dokterradiologiranap=rs.getDouble("tarif_tindakan_dokter");
                                tarif_tindakan_petugasradiologiranap=rs.getDouble("tarif_tindakan_petugas");
                                ksoradiologiranap=rs.getDouble("kso");
                                menejemenradiologiranap=rs.getDouble("menejemen");
                                biayaradiologiranap=rs.getDouble("biaya");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        //cek operasi ranap
                        ps=koneksi.prepareStatement(
                                "select sum(biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as jmdokter, "+
                                "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5) as jmparamedis,"+
                                "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5+biayaalat+biayasewaok+akomodasi+bagian_rs+biayasarpras+biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as pendapatan "+
                                "from operasi where no_rawat=? and status='Ranap'");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            if(rs.next()){
                                jmdokteroperasiranap=rs.getDouble("jmdokter");
                                jmparamedisoperasiranap=rs.getDouble("jmparamedis");
                                pendapatanoperasiranap=rs.getDouble("pendapatan");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        bhpoperasiranap=Sequel.cariIsiAngka("select sum(beri_obat_operasi.hargasatuan*beri_obat_operasi.jumlah) from beri_obat_operasi inner join operasi on beri_obat_operasi.no_rawat=operasi.no_rawat and beri_obat_operasi.tanggal=operasi.tgl_operasi where operasi.status='Ranap' and beri_obat_operasi.no_rawat=?",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        //cek obat rawat ranap
                        ps=koneksi.prepareStatement("select sum(h_beli*jml) as hpp,sum(total) as total from detail_pemberian_obat where no_rawat=? and status='Ranap'");
                        try {
                            ps.setString(1,tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                            rs=ps.executeQuery();
                            while(rs.next()){
                                obatranap=rs.getDouble("total");
                                hppobatranap=rs.getDouble("hpp");
                            }
                        } catch (Exception e) {
                            System.out.println("Notif : "+e);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                        //cek retur obat
                        returobat=Sequel.cariIsiAngka("select sum(detreturjual.subtotal) from detreturjual where no_retur_jual like ?","%"+tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString()+"%");
                        //cek kamar 
                        kamar=Sequel.cariIsiAngka("select sum(totalbiaya) from billing where status='Kamar' and no_rawat=?",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        //cek harian 
                        harianranap=Sequel.cariIsiAngka("select sum(totalbiaya) from billing where status='Harian' and no_rawat=?",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        //cek resep pulang 
                        reseppulang=Sequel.cariIsiAngka("select sum(total) from resep_pulang where no_rawat=?",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        norawatbayi=Sequel.cariIsi("select no_rawat2 from ranap_gabung where no_rawat=?",tbBangsal.getValueAt(tbBangsal.getSelectedRow(),1).toString());
                        if(!norawatbayi.equals("")){
                            //cek obat langsung bayi
                            obatlangsung=obatlangsung+Sequel.cariIsiAngka("select besar_tagihan from tagihan_obat_langsung where no_rawat=? ",norawatbayi);
                            //cek tambahan biaya bayi
                            tambahanbiaya=tambahanbiaya+Sequel.cariIsiAngka("select sum(besar_biaya) from tambahan_biaya where no_rawat=? ",norawatbayi);
                            //cek potongan biaya bayi
                            potonganbiaya=potonganbiaya+Sequel.cariIsiAngka("select sum(besar_pengurangan) from pengurangan_biaya where no_rawat=? ",norawatbayi);
                            //cek rawat jalan bayi
                            ps=koneksi.prepareStatement(
                                    "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                                    "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_jl_drpr where no_rawat=?");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    materialralan=materialralan+rs.getDouble("material");
                                    bhpralan=bhpralan+rs.getDouble("bhp");
                                    tarif_tindakandrralan=tarif_tindakandrralan+rs.getDouble("tarif_tindakandr");
                                    tarif_tindakanprralan=tarif_tindakanprralan+rs.getDouble("tarif_tindakanpr");
                                    ksoralan=ksoralan+rs.getDouble("kso");
                                    menejemenralan=menejemenralan+rs.getDouble("menejemen");
                                    biaya_rawatralan=biaya_rawatralan+rs.getDouble("biaya_rawat");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            ps=koneksi.prepareStatement(
                                    "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,"+
                                    "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_jl_dr where no_rawat=?");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    materialralan=+materialralan+rs.getDouble("material");
                                    bhpralan=bhpralan+rs.getDouble("bhp");
                                    tarif_tindakandrralan=tarif_tindakandrralan+rs.getDouble("tarif_tindakandr");
                                    ksoralan=ksoralan+rs.getDouble("kso");
                                    menejemenralan=menejemenralan+rs.getDouble("menejemen");
                                    biaya_rawatralan=biaya_rawatralan+rs.getDouble("biaya_rawat");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            ps=koneksi.prepareStatement(
                                    "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                                    "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_jl_pr where no_rawat=?");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    materialralan=+materialralan+rs.getDouble("material");
                                    bhpralan=bhpralan+rs.getDouble("bhp");
                                    tarif_tindakanprralan=tarif_tindakanprralan+rs.getDouble("tarif_tindakanpr");
                                    ksoralan=ksoralan+rs.getDouble("kso");
                                    menejemenralan=menejemenralan+rs.getDouble("menejemen");
                                    biaya_rawatralan=biaya_rawatralan+rs.getDouble("biaya_rawat");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek lab ralan bayi
                            ps=koneksi.prepareStatement(
                                    "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                                    "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_lab "+
                                    "where no_rawat=? and status='Ralan'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    bagian_rslabralan=bagian_rslabralan+rs.getDouble("bagian_rs");
                                    bhplabralan=bhplabralan+rs.getDouble("bhp");
                                    tarif_perujuklabralan=tarif_perujuklabralan+rs.getDouble("tarif_perujuk");
                                    tarif_tindakan_dokterlabralan=tarif_tindakan_dokterlabralan+rs.getDouble("tarif_tindakan_dokter");
                                    tarif_tindakan_petugaslabralan=tarif_tindakan_petugaslabralan+rs.getDouble("tarif_tindakan_petugas");
                                    ksolabralan=ksolabralan+rs.getDouble("kso");
                                    menejemenlabralan=menejemenlabralan+rs.getDouble("menejemen");
                                    biayalabralan=biayalabralan+rs.getDouble("biaya");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            ps=koneksi.prepareStatement(
                                    "select sum(detail_periksa_lab.bagian_rs) as bagian_rs,sum(detail_periksa_lab.bhp) as bhp,sum(detail_periksa_lab.bagian_perujuk) as bagian_perujuk,"+
                                    "sum(detail_periksa_lab.bagian_dokter) as bagian_dokter,sum(detail_periksa_lab.bagian_laborat) as bagian_laborat,sum(detail_periksa_lab.kso) as kso,"+
                                    "sum(detail_periksa_lab.menejemen) as menejemen,sum(detail_periksa_lab.biaya_item) as biaya_item from detail_periksa_lab inner join periksa_lab on "+
                                    "detail_periksa_lab.no_rawat=periksa_lab.no_rawat and detail_periksa_lab.kd_jenis_prw=periksa_lab.kd_jenis_prw and detail_periksa_lab.tgl_periksa=periksa_lab.tgl_periksa "+
                                    "and detail_periksa_lab.jam=periksa_lab.jam where detail_periksa_lab.no_rawat=? and periksa_lab.status='Ralan'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    bagian_rslabralan=bagian_rslabralan+rs.getDouble("bagian_rs");
                                    bhplabralan=bhplabralan+rs.getDouble("bhp");
                                    tarif_perujuklabralan=tarif_perujuklabralan+rs.getDouble("bagian_perujuk");
                                    tarif_tindakan_dokterlabralan=tarif_tindakan_dokterlabralan+rs.getDouble("bagian_dokter");
                                    tarif_tindakan_petugaslabralan=tarif_tindakan_petugaslabralan+rs.getDouble("bagian_laborat");
                                    ksolabralan=ksolabralan+rs.getDouble("kso");
                                    menejemenlabralan=menejemenlabralan+rs.getDouble("menejemen");
                                    biayalabralan=biayalabralan+rs.getDouble("biaya_item");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek radiologi ralan bayi
                            ps=koneksi.prepareStatement(
                                    "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                                    "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_radiologi "+
                                    "where no_rawat=? and status='Ralan'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    bagian_rsradiologiralan=bagian_rsradiologiralan+rs.getDouble("bagian_rs");
                                    bhpradiologiralan=bhpradiologiralan+rs.getDouble("bhp");
                                    tarif_perujukradiologiralan=tarif_perujukradiologiralan+rs.getDouble("tarif_perujuk");
                                    tarif_tindakan_dokterradiologiralan=tarif_tindakan_dokterradiologiralan+rs.getDouble("tarif_tindakan_dokter");
                                    tarif_tindakan_petugasradiologiralan=tarif_tindakan_petugasradiologiralan+rs.getDouble("tarif_tindakan_petugas");
                                    ksoradiologiralan=ksoradiologiralan+rs.getDouble("kso");
                                    menejemenradiologiralan=menejemenradiologiralan+rs.getDouble("menejemen");
                                    biayaradiologiralan=biayaradiologiralan+rs.getDouble("biaya");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek operasi ralan hayi
                            ps=koneksi.prepareStatement(
                                    "select sum(biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as jmdokter, "+
                                    "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5) as jmparamedis,"+
                                    "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5+biayaalat+biayasewaok+akomodasi+bagian_rs+biayasarpras+biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as pendapatan "+
                                    "from operasi where no_rawat=? and status='Ralan'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    jmdokteroperasiralan=jmdokteroperasiralan+rs.getDouble("jmdokter");
                                    jmparamedisoperasiralan=jmparamedisoperasiralan+rs.getDouble("jmparamedis");
                                    pendapatanoperasiralan=pendapatanoperasiralan+rs.getDouble("pendapatan");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            bhpoperasiralan=bhpoperasiralan+Sequel.cariIsiAngka("select sum(beri_obat_operasi.hargasatuan*beri_obat_operasi.jumlah) from beri_obat_operasi inner join operasi on beri_obat_operasi.no_rawat=operasi.no_rawat and beri_obat_operasi.tanggal=operasi.tgl_operasi where operasi.status='Ralan' and beri_obat_operasi.no_rawat=?",norawatbayi);
                            //cek obat rawat jalan bayi
                            ps=koneksi.prepareStatement("select sum(h_beli*jml) as hpp,sum(total) as total from detail_pemberian_obat where no_rawat=? and status='Ralan'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                while(rs.next()){
                                    obatralan=obatralan+rs.getDouble("total");
                                    hppobatralan=hppobatralan+rs.getDouble("hpp");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek rawat inap bayi
                            ps=koneksi.prepareStatement(
                                    "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                                    "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_inap_drpr where no_rawat=?");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    materialranap=materialranap+rs.getDouble("material");
                                    bhpranap=bhpranap+rs.getDouble("bhp");
                                    tarif_tindakandrranap=tarif_tindakandrranap+rs.getDouble("tarif_tindakandr");
                                    tarif_tindakanprranap=tarif_tindakanprranap+rs.getDouble("tarif_tindakanpr");
                                    ksoranap=ksoranap+rs.getDouble("kso");
                                    menejemenranap=menejemenranap+rs.getDouble("menejemen");
                                    biaya_rawatranap=biaya_rawatranap+rs.getDouble("biaya_rawat");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            ps=koneksi.prepareStatement(
                                    "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakandr) as tarif_tindakandr,"+
                                    "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_inap_dr where no_rawat=?");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    materialranap=+materialranap+rs.getDouble("material");
                                    bhpranap=bhpranap+rs.getDouble("bhp");
                                    tarif_tindakandrranap=tarif_tindakandrranap+rs.getDouble("tarif_tindakandr");
                                    ksoranap=ksoranap+rs.getDouble("kso");
                                    menejemenranap=menejemenranap+rs.getDouble("menejemen");
                                    biaya_rawatranap=biaya_rawatranap+rs.getDouble("biaya_rawat");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            ps=koneksi.prepareStatement(
                                    "select sum(material) as material,sum(bhp) as bhp,sum(tarif_tindakanpr) as tarif_tindakanpr,"+
                                    "sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya_rawat) as biaya_rawat from rawat_inap_pr where no_rawat=?");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    materialranap=+materialranap+rs.getDouble("material");
                                    bhpranap=bhpranap+rs.getDouble("bhp");
                                    tarif_tindakanprranap=tarif_tindakanprranap+rs.getDouble("tarif_tindakanpr");
                                    ksoranap=ksoranap+rs.getDouble("kso");
                                    menejemenranap=menejemenranap+rs.getDouble("menejemen");
                                    biaya_rawatranap=biaya_rawatranap+rs.getDouble("biaya_rawat");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek lab ranap bayi
                            ps=koneksi.prepareStatement(
                                    "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                                    "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_lab "+
                                    "where no_rawat=? and status='Ranap'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    bagian_rslabranap=bagian_rslabranap+rs.getDouble("bagian_rs");
                                    bhplabranap=bhplabranap+rs.getDouble("bhp");
                                    tarif_perujuklabranap=tarif_perujuklabranap+rs.getDouble("tarif_perujuk");
                                    tarif_tindakan_dokterlabranap=tarif_tindakan_dokterlabranap+rs.getDouble("tarif_tindakan_dokter");
                                    tarif_tindakan_petugaslabranap=tarif_tindakan_petugaslabranap+rs.getDouble("tarif_tindakan_petugas");
                                    ksolabranap=ksolabranap+rs.getDouble("kso");
                                    menejemenlabranap=menejemenlabranap+rs.getDouble("menejemen");
                                    biayalabranap=biayalabranap+rs.getDouble("biaya");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            ps=koneksi.prepareStatement(
                                    "select sum(detail_periksa_lab.bagian_rs) as bagian_rs,sum(detail_periksa_lab.bhp) as bhp,sum(detail_periksa_lab.bagian_perujuk) as bagian_perujuk,"+
                                    "sum(detail_periksa_lab.bagian_dokter) as bagian_dokter,sum(detail_periksa_lab.bagian_laborat) as bagian_laborat,sum(detail_periksa_lab.kso) as kso,"+
                                    "sum(detail_periksa_lab.menejemen) as menejemen,sum(detail_periksa_lab.biaya_item) as biaya_item from detail_periksa_lab inner join periksa_lab on "+
                                    "detail_periksa_lab.no_rawat=periksa_lab.no_rawat and detail_periksa_lab.kd_jenis_prw=periksa_lab.kd_jenis_prw and detail_periksa_lab.tgl_periksa=periksa_lab.tgl_periksa "+
                                    "and detail_periksa_lab.jam=periksa_lab.jam where detail_periksa_lab.no_rawat=? and periksa_lab.status='Ranap'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    bagian_rslabranap=bagian_rslabranap+rs.getDouble("bagian_rs");
                                    bhplabranap=bhplabranap+rs.getDouble("bhp");
                                    tarif_perujuklabranap=tarif_perujuklabranap+rs.getDouble("bagian_perujuk");
                                    tarif_tindakan_dokterlabranap=tarif_tindakan_dokterlabranap+rs.getDouble("bagian_dokter");
                                    tarif_tindakan_petugaslabranap=tarif_tindakan_petugaslabranap+rs.getDouble("bagian_laborat");
                                    ksolabranap=ksolabranap+rs.getDouble("kso");
                                    menejemenlabranap=menejemenlabranap+rs.getDouble("menejemen");
                                    biayalabranap=biayalabranap+rs.getDouble("biaya_item");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek radiologi ranap bayi
                            ps=koneksi.prepareStatement(
                                    "select sum(bagian_rs) as bagian_rs,sum(bhp) as bhp,sum(tarif_perujuk) as tarif_perujuk,sum(tarif_tindakan_dokter) as tarif_tindakan_dokter,"+
                                    "sum(tarif_tindakan_petugas) as tarif_tindakan_petugas,sum(kso) as kso,sum(menejemen) as menejemen,sum(biaya) as biaya from periksa_radiologi "+
                                    "where no_rawat=? and status='Ranap'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    bagian_rsradiologiranap=bagian_rsradiologiranap+rs.getDouble("bagian_rs");
                                    bhpradiologiranap=bhpradiologiranap+rs.getDouble("bhp");
                                    tarif_perujukradiologiranap=tarif_perujukradiologiranap+rs.getDouble("tarif_perujuk");
                                    tarif_tindakan_dokterradiologiranap=tarif_tindakan_dokterradiologiranap+rs.getDouble("tarif_tindakan_dokter");
                                    tarif_tindakan_petugasradiologiranap=tarif_tindakan_petugasradiologiranap+rs.getDouble("tarif_tindakan_petugas");
                                    ksoradiologiranap=ksoradiologiranap+rs.getDouble("kso");
                                    menejemenradiologiranap=menejemenradiologiranap+rs.getDouble("menejemen");
                                    biayaradiologiranap=biayaradiologiranap+rs.getDouble("biaya");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek operasi ranap bayi
                            ps=koneksi.prepareStatement(
                                    "select sum(biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as jmdokter, "+
                                    "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5) as jmparamedis,"+
                                    "sum(biayaasisten_operator1+biayaasisten_operator2+biayaasisten_operator3+biayainstrumen+biayaperawaat_resusitas+biayaasisten_anestesi+biayaasisten_anestesi2+biayabidan+biayabidan2+biayabidan3+biayaperawat_luar+biaya_omloop+biaya_omloop2+biaya_omloop3+biaya_omloop4+biaya_omloop5+biayaalat+biayasewaok+akomodasi+bagian_rs+biayasarpras+biayaoperator1+biayaoperator2+biayaoperator3+biayadokter_anak+biayadokter_anestesi+biaya_dokter_pjanak+biaya_dokter_umum) as pendapatan "+
                                    "from operasi where no_rawat=? and status='Ranap'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                if(rs.next()){
                                    jmdokteroperasiranap=jmdokteroperasiranap+rs.getDouble("jmdokter");
                                    jmparamedisoperasiranap=jmparamedisoperasiranap+rs.getDouble("jmparamedis");
                                    pendapatanoperasiranap=pendapatanoperasiranap+rs.getDouble("pendapatan");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            bhpoperasiranap=bhpoperasiranap+Sequel.cariIsiAngka("select sum(beri_obat_operasi.hargasatuan*beri_obat_operasi.jumlah) from beri_obat_operasi inner join operasi on beri_obat_operasi.no_rawat=operasi.no_rawat and beri_obat_operasi.tanggal=operasi.tgl_operasi where operasi.status='Ranap' and beri_obat_operasi.no_rawat=?",norawatbayi);
                            //cek obat rawat ranap bayi
                            ps=koneksi.prepareStatement("select sum(h_beli*jml) as hpp,sum(total) as total from detail_pemberian_obat where no_rawat=? and status='Ranap'");
                            try {
                                ps.setString(1,norawatbayi);
                                rs=ps.executeQuery();
                                while(rs.next()){
                                    obatranap=obatranap+rs.getDouble("total");
                                    hppobatranap=hppobatranap+rs.getDouble("hpp");
                                }
                            } catch (Exception e) {
                                System.out.println("Notif : "+e);
                            } finally{
                                if(rs!=null){
                                    rs.close();
                                }
                                if(ps!=null){
                                    ps.close();
                                }
                            }
                            //cek retur obat bayi
                            returobat=returobat+Sequel.cariIsiAngka("select sum(detreturjual.subtotal) from detreturjual where no_retur_jual like ?","%"+norawatbayi+"%");
                            //cek resep pulang bayi
                            reseppulang=reseppulang+Sequel.cariIsiAngka("select sum(total) from resep_pulang where no_rawat=?",norawatbayi);
                        }
                    }
                    if(status.equals("Ralan")){
                        if(tampilkan_ppnobat_ralan.equals("Yes")){
                            obatlangsung=obatlangsung+(Valid.roundUp(obatralan*0.1,100));
                        }
                    }else if(status.equals("Ranap")){
                        if(tampilkan_ppnobat_ranap.equals("Yes")){
                            obatlangsung=obatlangsung+(Valid.roundUp((obatralan+obatranap-returobat)*0.1,100));
                        }
                        if(tampilkan_administrasi_di_billingranap.equals("No")){
                            registrasi=0;
                        }
                    }
                    totalbiaya=registrasi+biaya_rawatralan+biaya_rawatranap+biayalabralan+biayalabranap+biayaradiologiralan+biayaradiologiranap+
                               bhpoperasiralan+pendapatanoperasiralan+bhpoperasiranap+pendapatanoperasiranap+obatlangsung+obatralan+obatranap-returobat+
                               tambahanbiaya-potonganbiaya+kamar+reseppulang+harianranap;
                    if(Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),5).toString())==totalbiaya){
                        tbBangsal.setValueAt(materialralan,tbBangsal.getSelectedRow(),16);
                        tbBangsal.setValueAt(bhpralan,tbBangsal.getSelectedRow(),17);
                        tbBangsal.setValueAt(tarif_tindakandrralan,tbBangsal.getSelectedRow(),18);
                        tbBangsal.setValueAt(tarif_tindakanprralan,tbBangsal.getSelectedRow(),19);
                        tbBangsal.setValueAt(ksoralan,tbBangsal.getSelectedRow(),20);
                        tbBangsal.setValueAt(menejemenralan,tbBangsal.getSelectedRow(),21);
                        tbBangsal.setValueAt(biaya_rawatralan,tbBangsal.getSelectedRow(),22);
                        tbBangsal.setValueAt(materialranap,tbBangsal.getSelectedRow(),23);
                        tbBangsal.setValueAt(bhpranap,tbBangsal.getSelectedRow(),24);
                        tbBangsal.setValueAt(tarif_tindakandrranap,tbBangsal.getSelectedRow(),25);
                        tbBangsal.setValueAt(tarif_tindakanprranap,tbBangsal.getSelectedRow(),26);
                        tbBangsal.setValueAt(ksoranap,tbBangsal.getSelectedRow(),27);
                        tbBangsal.setValueAt(menejemenranap,tbBangsal.getSelectedRow(),28);
                        tbBangsal.setValueAt(biaya_rawatranap,tbBangsal.getSelectedRow(),29);
                        tbBangsal.setValueAt(bagian_rslabralan,tbBangsal.getSelectedRow(),30);
                        tbBangsal.setValueAt(bhplabralan,tbBangsal.getSelectedRow(),31);
                        tbBangsal.setValueAt(tarif_perujuklabralan,tbBangsal.getSelectedRow(),32);
                        tbBangsal.setValueAt(tarif_tindakan_dokterlabralan,tbBangsal.getSelectedRow(),33);
                        tbBangsal.setValueAt(tarif_tindakan_petugaslabralan,tbBangsal.getSelectedRow(),34);
                        tbBangsal.setValueAt(ksolabralan,tbBangsal.getSelectedRow(),35);
                        tbBangsal.setValueAt(menejemenlabralan,tbBangsal.getSelectedRow(),36);
                        tbBangsal.setValueAt(biayalabralan,tbBangsal.getSelectedRow(),37);
                        tbBangsal.setValueAt(bagian_rslabranap,tbBangsal.getSelectedRow(),38);
                        tbBangsal.setValueAt(bhplabranap,tbBangsal.getSelectedRow(),39);
                        tbBangsal.setValueAt(tarif_perujuklabranap,tbBangsal.getSelectedRow(),40);
                        tbBangsal.setValueAt(tarif_tindakan_dokterlabranap,tbBangsal.getSelectedRow(),41);
                        tbBangsal.setValueAt(tarif_tindakan_petugaslabranap,tbBangsal.getSelectedRow(),42);
                        tbBangsal.setValueAt(ksolabranap,tbBangsal.getSelectedRow(),43);
                        tbBangsal.setValueAt(menejemenlabranap,tbBangsal.getSelectedRow(),44);
                        tbBangsal.setValueAt(biayalabranap,tbBangsal.getSelectedRow(),45);
                        tbBangsal.setValueAt(bagian_rsradiologiralan,tbBangsal.getSelectedRow(),46);
                        tbBangsal.setValueAt(bhpradiologiralan,tbBangsal.getSelectedRow(),47);
                        tbBangsal.setValueAt(tarif_perujukradiologiralan,tbBangsal.getSelectedRow(),48);
                        tbBangsal.setValueAt(tarif_tindakan_dokterradiologiralan,tbBangsal.getSelectedRow(),49);
                        tbBangsal.setValueAt(tarif_tindakan_petugasradiologiralan,tbBangsal.getSelectedRow(),50);
                        tbBangsal.setValueAt(ksoradiologiralan,tbBangsal.getSelectedRow(),51);
                        tbBangsal.setValueAt(menejemenradiologiralan,tbBangsal.getSelectedRow(),52);
                        tbBangsal.setValueAt(biayaradiologiralan,tbBangsal.getSelectedRow(),53);
                        tbBangsal.setValueAt(bagian_rsradiologiranap,tbBangsal.getSelectedRow(),54);
                        tbBangsal.setValueAt(bhpradiologiranap,tbBangsal.getSelectedRow(),55);
                        tbBangsal.setValueAt(tarif_perujukradiologiranap,tbBangsal.getSelectedRow(),56);
                        tbBangsal.setValueAt(tarif_tindakan_dokterradiologiranap,tbBangsal.getSelectedRow(),57);
                        tbBangsal.setValueAt(tarif_tindakan_petugasradiologiranap,tbBangsal.getSelectedRow(),58);
                        tbBangsal.setValueAt(ksoradiologiranap,tbBangsal.getSelectedRow(),59);
                        tbBangsal.setValueAt(menejemenradiologiranap,tbBangsal.getSelectedRow(),60);
                        tbBangsal.setValueAt(biayaradiologiranap,tbBangsal.getSelectedRow(),61);
                        tbBangsal.setValueAt(jmdokteroperasiralan,tbBangsal.getSelectedRow(),62);
                        tbBangsal.setValueAt(jmparamedisoperasiralan,tbBangsal.getSelectedRow(),63);
                        tbBangsal.setValueAt(bhpoperasiralan,tbBangsal.getSelectedRow(),64);
                        tbBangsal.setValueAt(pendapatanoperasiralan,tbBangsal.getSelectedRow(),65);
                        tbBangsal.setValueAt(jmdokteroperasiranap,tbBangsal.getSelectedRow(),66);
                        tbBangsal.setValueAt(jmparamedisoperasiranap,tbBangsal.getSelectedRow(),67);
                        tbBangsal.setValueAt(bhpoperasiranap,tbBangsal.getSelectedRow(),68);
                        tbBangsal.setValueAt(pendapatanoperasiranap,tbBangsal.getSelectedRow(),69);
                        tbBangsal.setValueAt(obatlangsung,tbBangsal.getSelectedRow(),70);
                        tbBangsal.setValueAt(obatralan,tbBangsal.getSelectedRow(),71);
                        tbBangsal.setValueAt(hppobatralan,tbBangsal.getSelectedRow(),72);
                        tbBangsal.setValueAt(obatranap,tbBangsal.getSelectedRow(),73);
                        tbBangsal.setValueAt(hppobatranap,tbBangsal.getSelectedRow(),74);
                        tbBangsal.setValueAt(returobat,tbBangsal.getSelectedRow(),75);
                        tbBangsal.setValueAt(tambahanbiaya,tbBangsal.getSelectedRow(),76);
                        tbBangsal.setValueAt(potonganbiaya,tbBangsal.getSelectedRow(),77);
                        tbBangsal.setValueAt(kamar,tbBangsal.getSelectedRow(),78);
                        tbBangsal.setValueAt(reseppulang,tbBangsal.getSelectedRow(),79);
                        tbBangsal.setValueAt(harianranap,tbBangsal.getSelectedRow(),80);
                        tbBangsal.setValueAt(registrasi,tbBangsal.getSelectedRow(),81);
                        
                        selisih=0;
                        selisih=(Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),10).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),6).toString())+Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),7).toString()))-Valid.SetAngka(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),5).toString());
                        if(selisih>=0){
                            tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),12);
                            tbBangsal.setValueAt(selisih,tbBangsal.getSelectedRow(),13);
                        }else{
                            selisih=( (bhpralan+bhpranap+bhplabralan+bhplabranap+bhpradiologiralan+bhpradiologiranap+bhpoperasiralan+bhpoperasiranap) * ((100-Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),11).toString()))/100) );
                            rugihpp=(hppobatralan+hppobatranap-returobat)-( (reseppulang+obatlangsung+obatralan+obatranap-returobat)*(Valid.SetAngka(tabMode.getValueAt(tbBangsal.getSelectedRow(),11).toString())/100) );
                            if(rugihpp>0){
                                selisih=selisih+rugihpp;
                            }
                            tbBangsal.setValueAt(selisih,tbBangsal.getSelectedRow(),12);
                            tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),13);
                        } 
                    }else{
                        JOptionPane.showMessageDialog(null,"Ditemukan perbedaan Total Biaya pada closing billing,\nsilahkan cek data billing dengan Hapus Nota Salah... !!! ");
                        tbBangsal.setValueAt(false,tbBangsal.getSelectedRow(),0);
                        tbBangsal.setValueAt(null,tbBangsal.getSelectedRow(),10);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),11);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),16);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),17);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),18);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),19);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),20);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),21);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),22);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),23);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),24);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),25);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),26);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),27);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),28);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),29);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),30);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),31);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),32);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),33);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),34);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),35);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),36);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),37);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),38);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),39);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),40);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),41);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),42);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),43);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),44);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),45);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),46);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),47);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),48);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),49);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),50);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),51);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),52);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),53);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),54);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),55);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),56);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),57);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),58);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),59);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),60);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),61);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),62);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),63);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),64);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),65);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),66);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),67);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),68);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),69);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),70);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),71);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),72);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),73);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),74);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),75);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),76);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),77);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),78);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),79);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),80);
                        tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),81);
                    }  
                }else if(tbBangsal.getValueAt(tbBangsal.getSelectedRow(),0).toString().equals("false")){
                    tbBangsal.setValueAt(null,tbBangsal.getSelectedRow(),10);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),11);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),12);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),13);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),16);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),17);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),18);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),19);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),20);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),21);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),22);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),23);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),24);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),25);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),26);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),27);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),28);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),29);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),30);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),31);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),32);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),33);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),34);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),35);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),36);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),37);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),38);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),39);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),40);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),41);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),42);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),43);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),44);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),45);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),46);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),47);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),48);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),49);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),50);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),51);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),52);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),53);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),54);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),55);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),56);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),57);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),58);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),59);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),60);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),61);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),62);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),63);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),64);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),65);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),66);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),67);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),68);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),69);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),70);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),71);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),72);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),73);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),74);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),75);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),76);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),77);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),78);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),79);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),80);
                    tbBangsal.setValueAt(0,tbBangsal.getSelectedRow(),81);
                }
            }  
        } catch (Exception e) {
        }
        row=tbBangsal.getRowCount();
        total=0;
        lebih=0;
        rugi=0;
        for(i=0;i<row;i++){  
            if(tbBangsal.getValueAt(i,0).toString().equals("true")){
                 try {
                     total=total+Valid.SetAngka(tbBangsal.getValueAt(i,10).toString()); 
                 } catch (Exception e) {
                 }
                  
                 try {
                    rugi=rugi+Valid.SetAngka(tbBangsal.getValueAt(i,12).toString());
                 } catch (Exception e) {
                 }
                 
                 try {
                    lebih=lebih+Valid.SetAngka(tbBangsal.getValueAt(i,13).toString());
                 } catch (Exception e) {
                 } 
            }
        }
        LCount1.setText(Valid.SetAngka(total));
        LCount2.setText(Valid.SetAngka(rugi));
        LCount3.setText(Valid.SetAngka(lebih));
    }
    
    public void isCek(){
        TCari.requestFocus();
        if(akses.getjml2()>=1){
            kdptg.setEditable(false);
            BtnBayar.setEnabled(akses.getbayar_piutang());
            kdptg.setText(akses.getkode());
            Sequel.cariIsi("select nama from petugas where nip=?", nmptg,kdptg.getText());
        } 
    }
}
