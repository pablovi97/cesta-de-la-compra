/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carritocompra.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByArticuloID", query = "SELECT a FROM Articulo a WHERE a.articuloID = :articuloID")
    , @NamedQuery(name = "Articulo.findByArticuloNombre", query = "SELECT a FROM Articulo a WHERE a.articuloNombre = :articuloNombre")
    , @NamedQuery(name = "Articulo.findByArticuloPrecio", query = "SELECT a FROM Articulo a WHERE a.articuloPrecio = :articuloPrecio")
    , @NamedQuery(name = "Articulo.findByArticuloCantidad", query = "SELECT a FROM Articulo a WHERE a.articuloCantidad = :articuloCantidad")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "articuloID")
    private Integer articuloID;
    @Column(name = "articuloNombre")
    private String articuloNombre;
    @Column(name = "articuloPrecio")
    private Integer articuloPrecio;
    @Column(name = "articuloCantidad")
    private Integer articuloCantidad;
    @OneToMany(mappedBy = "articuloID")
    private List<DetallePedido> detallePedidoList;

    public Articulo() {
    }

    public Articulo(Integer articuloID) {
        this.articuloID = articuloID;
    }

    public Integer getArticuloID() {
        return articuloID;
    }

    public void setArticuloID(Integer articuloID) {
        this.articuloID = articuloID;
    }

    public String getArticuloNombre() {
        return articuloNombre;
    }

    public void setArticuloNombre(String articuloNombre) {
        this.articuloNombre = articuloNombre;
    }

    public Integer getArticuloPrecio() {
        return articuloPrecio;
    }

    public void setArticuloPrecio(Integer articuloPrecio) {
        this.articuloPrecio = articuloPrecio;
    }

    public Integer getArticuloCantidad() {
        return articuloCantidad;
    }

    public void setArticuloCantidad(Integer articuloCantidad) {
        this.articuloCantidad = articuloCantidad;
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
        hash += (articuloID != null ? articuloID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.articuloID == null && other.articuloID != null) || (this.articuloID != null && !this.articuloID.equals(other.articuloID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getArticuloNombre();
    }
    
}
