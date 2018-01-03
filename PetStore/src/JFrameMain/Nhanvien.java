/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrameMain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author voanh
 */
@Entity
@Table(name = "NHANVIEN", catalog = "QuanLyCuaHangThuCung", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n")
    , @NamedQuery(name = "Nhanvien.findByManv", query = "SELECT n FROM Nhanvien n WHERE n.manv = :manv")
    , @NamedQuery(name = "Nhanvien.findByHoten", query = "SELECT n FROM Nhanvien n WHERE n.hoten = :hoten")
    , @NamedQuery(name = "Nhanvien.findByGioitinh", query = "SELECT n FROM Nhanvien n WHERE n.gioitinh = :gioitinh")
    , @NamedQuery(name = "Nhanvien.findByNgaysinh", query = "SELECT n FROM Nhanvien n WHERE n.ngaysinh = :ngaysinh")
    , @NamedQuery(name = "Nhanvien.findByDiachi", query = "SELECT n FROM Nhanvien n WHERE n.diachi = :diachi")
    , @NamedQuery(name = "Nhanvien.findBySdt", query = "SELECT n FROM Nhanvien n WHERE n.sdt = :sdt")
    , @NamedQuery(name = "Nhanvien.findByChucvu", query = "SELECT n FROM Nhanvien n WHERE n.chucvu = :chucvu")
    , @NamedQuery(name = "Nhanvien.findByLuong", query = "SELECT n FROM Nhanvien n WHERE n.luong = :luong")
    , @NamedQuery(name = "Nhanvien.findByCmnd", query = "SELECT n FROM Nhanvien n WHERE n.cmnd = :cmnd")})
public class Nhanvien implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MANV")
    private String manv;
    @Column(name = "HOTEN")
    private String hoten;
    @Column(name = "GIOITINH")
    private String gioitinh;
    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "DIACHI")
    private String diachi;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "CHUCVU")
    private String chucvu;
    @Column(name = "LUONG")
    private Integer luong;
    @Column(name = "CMND")
    private String cmnd;

    public Nhanvien() {
    }

    public Nhanvien(String manv) {
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        String oldManv = this.manv;
        this.manv = manv;
        changeSupport.firePropertyChange("manv", oldManv, manv);
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        String oldHoten = this.hoten;
        this.hoten = hoten;
        changeSupport.firePropertyChange("hoten", oldHoten, hoten);
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        String oldGioitinh = this.gioitinh;
        this.gioitinh = gioitinh;
        changeSupport.firePropertyChange("gioitinh", oldGioitinh, gioitinh);
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        Date oldNgaysinh = this.ngaysinh;
        this.ngaysinh = ngaysinh;
        changeSupport.firePropertyChange("ngaysinh", oldNgaysinh, ngaysinh);
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        String oldDiachi = this.diachi;
        this.diachi = diachi;
        changeSupport.firePropertyChange("diachi", oldDiachi, diachi);
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        String oldSdt = this.sdt;
        this.sdt = sdt;
        changeSupport.firePropertyChange("sdt", oldSdt, sdt);
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        String oldChucvu = this.chucvu;
        this.chucvu = chucvu;
        changeSupport.firePropertyChange("chucvu", oldChucvu, chucvu);
    }

    public Integer getLuong() {
        return luong;
    }

    public void setLuong(Integer luong) {
        Integer oldLuong = this.luong;
        this.luong = luong;
        changeSupport.firePropertyChange("luong", oldLuong, luong);
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        String oldCmnd = this.cmnd;
        this.cmnd = cmnd;
        changeSupport.firePropertyChange("cmnd", oldCmnd, cmnd);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manv != null ? manv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.manv == null && other.manv != null) || (this.manv != null && !this.manv.equals(other.manv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JFrameMain.Nhanvien[ manv=" + manv + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
