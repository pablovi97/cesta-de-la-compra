/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carritocompra.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByPedidoID", query = "SELECT p FROM Pedido p WHERE p.pedidoID = :pedidoID")
    , @NamedQuery(name = "Pedido.findByPedidoFecha", query = "SELECT p FROM Pedido p WHERE p.pedidoFecha = :pedidoFecha")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pedidoID")
    private Integer pedidoID;
    @Column(name = "pedidoFecha")
    @Temporal(TemporalType.DATE)
    private Date pedidoFecha;
    @JoinColumn(name = "clienteID", referencedColumnName = "clienteID")
    @ManyToOne
    private Cliente clienteID;
    @OneToMany(mappedBy = "pedidoID")
    private List<DetallePedido> detallePedidoList;

    public Pedido() {
    }

    public Pedido(Integer pedidoID) {
        this.pedidoID = pedidoID;
    }

    public Integer getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(Integer pedidoID) {
        this.pedidoID = pedidoID;
    }

    public Date getPedidoFecha() {
        return pedidoFecha;
    }

    public void setPedidoFecha(Date pedidoFecha) {
        this.pedidoFecha = pedidoFecha;
    }

    public Cliente getClienteID() {
        return clienteID;
    }

    public void setClienteID(Cliente clienteID) {
        this.clienteID = clienteID;
    }

    @XmlTransient
    public List<DetallePedido> getDetallePedidoList() {
        return detallePedidoList;
    }

    public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoID != null ? pedidoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoID == null && other.pedidoID != null) || (this.pedidoID != null && !this.pedidoID.equals(other.pedidoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carritocompra.modelo.Pedido[ pedidoID=" + pedidoID + " ]";
    }
    
}
