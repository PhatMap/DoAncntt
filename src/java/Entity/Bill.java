/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TranTrungPhat
 */
@Entity
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id"),
    @NamedQuery(name = "Bill.findByAccid", query = "SELECT b FROM Bill b WHERE b.accid = :accid"),
    @NamedQuery(name = "Bill.findByDatetime", query = "SELECT b FROM Bill b WHERE b.datetime = :datetime"),
    @NamedQuery(name = "Bill.findByTotal", query = "SELECT b FROM Bill b WHERE b.total = :total"),
    @NamedQuery(name = "Bill.findByStatus", query = "SELECT b FROM Bill b WHERE b.status = :status"),
    @NamedQuery(name = "Bill.findBySdt", query = "SELECT b FROM Bill b WHERE b.sdt = :sdt")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "accid")
    private Integer accid;
    @Lob
    @Column(name = "detail")
    private String detail;
    @Column(name = "datetime")
    private String datetime;
    @Column(name = "total")
    private Integer total;
    @Column(name = "status")
    private String status;
    @Lob
    @Column(name = "name")
    private String name;
    @Column(name = "sdt")
    private String sdt;
    @Lob
    @Column(name = "address")
    private String address;

    public Bill() {
    }

    public Bill(Integer id, Integer accid, String detail, String datetime, Integer total,String name,String sdt,String address) {
        this.id = id;
        this.accid = accid;
        this.detail = detail;
        this.datetime = datetime;
        this.total = total;
        this.status = "Not Received";
        this.name = name;
        this.sdt = sdt;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bill[ id=" + id + " ]";
    }
    
}
