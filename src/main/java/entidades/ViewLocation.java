/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
 * @author eopg9
 */
@Entity
@Table(name = "VIEW_ALL_LOCATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewLocation.findAll", query = "SELECT v FROM ViewLocation v"),
    @NamedQuery(name = "ViewLocation.findByLocationId", query = "SELECT v FROM ViewLocation v WHERE v.locationId = :locationId"),
    @NamedQuery(name = "ViewLocation.findByStreetAddress", query = "SELECT v FROM ViewLocation v WHERE v.streetAddress = :streetAddress"),
    @NamedQuery(name = "ViewLocation.findByPostalCode", query = "SELECT v FROM ViewLocation v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "ViewLocation.findByCity", query = "SELECT v FROM ViewLocation v WHERE v.city = :city"),
    @NamedQuery(name = "ViewLocation.findByStateProvince", query = "SELECT v FROM ViewLocation v WHERE v.stateProvince = :stateProvince"),
    @NamedQuery(name = "ViewLocation.findByCountryId", query = "SELECT v FROM ViewLocation v WHERE v.countryId = :countryId")})
public class ViewLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOCATION_ID")
    private Short locationId;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Column(name = "COUNTRY_ID")
    private String countryId;

    public ViewLocation() {
    }

    public ViewLocation(Short locationId) {
        this.locationId = locationId;
    }

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewLocation)) {
            return false;
        }
        ViewLocation other = (ViewLocation) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ViewLocation[ locationId=" + locationId + " ]";
    }
    
}
