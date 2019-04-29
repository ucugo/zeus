package com.mahull.zeus.dao.entity.location;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="geo_ip_location_group")
public class GeoIPLocationGroup {

    public static final String PARENT_VALUE="*ALL*";

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @Enumerated(EnumType.STRING)
    private GeoIpLocationGroupType geoIpLocationGroupType;
    private String groupLevel1Name;
    private String groupLevel2Name;
    private String groupLevel3Name;
    private String groupLevel4Name;
    private String groupExpression;
    private boolean enabled;
    private Date lastViewedBeforeChange=new Date();
    @Transient
    private Date loadedAt=new Date();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "geo_ip_location_group_geo_ip_locations", joinColumns = { @JoinColumn(name = "geo_ip_location_group_id")}, inverseJoinColumns={@JoinColumn(name="geo_ip_location_id")})
    private Set<GeoIpLocation> geoIpLocations;

    public GeoIpLocationGroupType getGeoIpLocationGroupType() {
        return geoIpLocationGroupType;
    }
    public void setGeoIpLocationGroupType(GeoIpLocationGroupType geoIpLocationGroupType) {
        this.geoIpLocationGroupType = geoIpLocationGroupType;
    }
    public String getGroupLevel1Name() {
        return groupLevel1Name;
    }
    public void setGroupLevel1Name(String groupLevel1Name) {
        this.groupLevel1Name = groupLevel1Name;
    }
    public String getGroupLevel2Name() {
        return groupLevel2Name;
    }
    public void setGroupLevel2Name(String groupLevel2Name) {
        this.groupLevel2Name = groupLevel2Name;
    }
    public String getGroupLevel3Name() {
        return groupLevel3Name;
    }
    public void setGroupLevel3Name(String groupLevel3Name) {
        this.groupLevel3Name = groupLevel3Name;
    }
    public String getGroupLevel4Name() {
        return groupLevel4Name;
    }
    public void setGroupLevel4Name(String groupLevel4Name) {
        this.groupLevel4Name = groupLevel4Name;
    }
    public String getGroupExpression() {
        return groupExpression;
    }
    public void setGroupExpression(String groupExpression) {
        this.groupExpression = groupExpression;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Date getLastViewedBeforeChange() {
        return lastViewedBeforeChange;
    }
    public void setLastViewedBeforeChange(Date lastViewedBeforeChange) {
        this.lastViewedBeforeChange = lastViewedBeforeChange;
    }
    public Date getLoadedAt() {
        return loadedAt;
    }
    public void setLoadedAt(Date loadedAt) {
        this.loadedAt = loadedAt;
    }
    public Set<GeoIpLocation> getGeoIpLocations() {
        return geoIpLocations;
    }
    public void setGeoIpLocations(Set<GeoIpLocation> geoIpLocations) {
        this.geoIpLocations = geoIpLocations;
    }

    public boolean isParent(){
        return
                PARENT_VALUE.equalsIgnoreCase(getGroupLevel2Name()) ||
                        PARENT_VALUE.equalsIgnoreCase(getGroupLevel3Name()) ||
                        PARENT_VALUE.equalsIgnoreCase(getGroupLevel4Name());
    }
    public boolean isParent(GeoIPLocationGroup child){
        if(!this.isParent()){
            return false;
        }
        if(this.getParentLevel() != child.getParentLevel()-1){
            return false;
        }
        if(this.getParentLevel() >= 1){
            if(!this.getGroupLevel1Name().equalsIgnoreCase(child.getGroupLevel1Name())){
                return false;
            }
        }
        if(this.getParentLevel() >= 2){
            if(!this.getGroupLevel2Name().equalsIgnoreCase(child.getGroupLevel2Name())){
                return false;
            }
        }
        if(this.getParentLevel() >= 3){
            if(!this.getGroupLevel3Name().equalsIgnoreCase(child.getGroupLevel3Name())){
                return false;
            }
        }
        return true;
    }

    public int getParentLevel(){
        int level = 0;
        level = level == 0 && getGroupLevel2Name().equalsIgnoreCase(GeoIPLocationGroup.PARENT_VALUE)?1:level;
        level = level == 0 && getGroupLevel3Name().equalsIgnoreCase(GeoIPLocationGroup.PARENT_VALUE)?2:level;
        level = level == 0 && getGroupLevel4Name().equalsIgnoreCase(GeoIPLocationGroup.PARENT_VALUE)?3:level;
        return level;
    }
    public enum GeoIpLocationGroupType {
        Network
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
