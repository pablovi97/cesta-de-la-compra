/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "compra_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraCliente.findAll", query = "SELECT c FROM CompraCliente c")
    , @NamedQuery(name = "CompraCliente.findByIdCliente", query = "SELECT c FROM CompraCliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "CompraCliente.findByIdCompra", query = "SELECT c FROM CompraCliente c WHERE c.idCompra = :idCompra")})
public class CompraCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "id_compra")
    private int idCompra;

    public CompraCliente() {
    }

    public CompraCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public CompraCliente(Integer idCliente, int idCompra) {
        this.idCliente = idCliente;
        this.idCompra = idCompra;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraCliente)) {
            return false;
        }
        CompraCliente other = (CompraCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CompraCliente[ idCliente=" + idCliente + " ]";
    }
    
}
