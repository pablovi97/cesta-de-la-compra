/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carritocompra.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "DETALLE_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d")
    , @NamedQuery(name = "DetallePedido.findByDetalleID", query = "SELECT d FROM DetallePedido d WHERE d.detalleID = :detalleID")
    , @NamedQuery(name = "DetallePedido.findByArticuloPrecio", query = "SELECT d FROM DetallePedido d WHERE d.articuloPrecio = :articuloPrecio")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detalleID")
    private Integer detalleID;
    @Column(name = "articuloPrecio")
    private Integer articuloPrecio;
    @JoinColumn(name = "pedidoID", referencedColumnName = "pedidoID")
    @ManyToOne
    private Pedido pedidoID;
    @JoinColumn(name = "articuloID", referencedColumnName = "articuloID")
    @ManyToOne
    private Articulo articuloID;

    public DetallePedido() {
    }

    public DetallePedido(Integer detalleID) {
        this.detalleID = detalleID;
    }

    public Integer getDetalleID() {
        return detalleID;
    }

    public void setDetalleID(Integer detalleID) {
        this.detalleID = detalleID;
    }

    public Integer getArticuloPrecio() {
        return articuloPrecio;
    }

    public void setArticuloPrecio(Integer articuloPrecio) {
        this.articuloPrecio = articuloPrecio;
    }

    public Pedido getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(Pedido pedidoID) {
        this.pedidoID = pedidoID;
    }

    public Articulo getArticuloID() {
        return articuloID;
    }

    public void setArticuloID(Articulo articuloID) {
        this.articuloID = articuloID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleID != null ? detalleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.detalleID == null && other.detalleID != null) || (this.detalleID != null && !this.detalleID.equals(other.detalleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carritocompra.modelo.DetallePedido[ detalleID=" + detalleID + " ]";
    }
    
}
