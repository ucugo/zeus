package com.mahull.zeus.domain.filter;

import com.mahull.zeus.domain.demographic.DemographicAge;
import com.mahull.zeus.domain.demographic.DemographicGender;
import com.mahull.zeus.domain.demographic.DemographicLanguage;
import com.mahull.zeus.domain.demographic.DemographicRace;
import com.mahull.zeus.domain.location.GeoIPLocation;
import com.mahull.zeus.domain.location.GeoIPLocationGroup;
import com.mahull.zeus.domain.device.Handset;
import com.mahull.zeus.domain.device.HandsetGroup;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="filter_campaign")
public class CampaignFilter {

    private static final Logger logger = LoggerFactory.getLogger(CampaignFilter.class);
    private boolean allowBypassingProxies=false;
    private boolean filterOutHandsets=false;
    private boolean filterOutGeoLocations=false;

    @Id
    private UUID id;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "filter_campaign_handset_groups",
            joinColumns = {
                    @JoinColumn(name = "campaign_filter_id")},
            inverseJoinColumns={@JoinColumn(name="handset_group_id")
            })
    private Set<HandsetGroup> handsetGroups=new HashSet<>();

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "filter_campaign_geo_ip_location_groups",
            joinColumns = {
                    @JoinColumn(name = "campaign_filter_id")},
            inverseJoinColumns={@JoinColumn(name="geo_ip_location_group_id")
            })
    private Set<GeoIPLocationGroup> geoIPLocationGroups=new HashSet<>();
    @Type(type="text")
    private String ipTargetingRanges;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "filter_campaign_demographic_genders",
            joinColumns = {
                    @JoinColumn(name = "campaign_filter_id")},
            inverseJoinColumns={@JoinColumn(name="demographic_id")
            })
    private Set<DemographicGender> demographicGenders=new HashSet<>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "filter_campaign_demographic_sexual_preferences",
            joinColumns = {
                    @JoinColumn(name = "campaign_filter_id")},
            inverseJoinColumns={@JoinColumn(name="demographic_id")
            })
    private Set<DemographicGender> demographicSexualPreferences=new HashSet<>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "filter_campaign_demographic_languages",
            joinColumns = {
                    @JoinColumn(name = "campaign_filter_id")},
            inverseJoinColumns={@JoinColumn(name="demographic_id")
            })
    private Set<DemographicLanguage> demographicLanguages=new HashSet<>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "filter_campaign_demographic_races",
            joinColumns = {
                    @JoinColumn(name = "campaign_filter_id")},
            inverseJoinColumns={@JoinColumn(name="demographic_id")
            })
    private Set<DemographicRace> demographicRaces=new HashSet<>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "filter_campaign_demographic_ages",
            joinColumns = {
                    @JoinColumn(name = "campaign_filter_id")},
            inverseJoinColumns={@JoinColumn(name="demographic_id")
            })
    private Set<DemographicAge> demographicAges=new HashSet<>();



    @Transient
    private Object lock=new Object();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isAllowBypassingProxies() {
        return allowBypassingProxies;
    }
    public void setAllowBypassingProxies(boolean allowBypassingProxies) {
        this.allowBypassingProxies = allowBypassingProxies;
    }
    public boolean isFilterOutHandsets() {
        return filterOutHandsets;
    }
    public void setFilterOutHandsets(boolean filterOutHandsets) {
        this.filterOutHandsets = filterOutHandsets;
    }
    public boolean isFilterOutGeoLocations() {
        return filterOutGeoLocations;
    }
    public void setFilterOutGeoLocations(boolean filterOutGeoLocations) {
        this.filterOutGeoLocations = filterOutGeoLocations;
    }
    public Set<HandsetGroup> getHandsetGroups() {
        return handsetGroups;
    }
    public void setHandsetGroups(Set<HandsetGroup> handsetGroups) {
        this.handsetGroups = handsetGroups;
    }
    public Set<GeoIPLocationGroup> getGeoIPLocationGroups() {
        return geoIPLocationGroups;
    }
    public void setGeoIPLocationGroups(Set<GeoIPLocationGroup> geoIPLocationGroups) {
        this.geoIPLocationGroups = geoIPLocationGroups;
    }
    public String getIpTargetingRanges() {
        return ipTargetingRanges;
    }
    public void setIpTargetingRanges(String ipTargetingRanges) {
        this.ipTargetingRanges = ipTargetingRanges;
    }
    public Set<DemographicAge> getDemographicAges() {
        return demographicAges;
    }
    public void setDemographicAges(Set<DemographicAge> demographicAges) {
        this.demographicAges = demographicAges;
    }
    public Set<DemographicGender> getDemographicGenders() {
        return demographicGenders;
    }
    public void setDemographicGenders(Set<DemographicGender> demographicGenders) {
        this.demographicGenders = demographicGenders;
    }
    public Set<DemographicLanguage> getDemographicLanguages() {
        return demographicLanguages;
    }
    public void setDemographicLanguages(Set<DemographicLanguage> demographicLanguages) {
        this.demographicLanguages = demographicLanguages;
    }
    public Set<DemographicRace> getDemographicRaces() {
        return demographicRaces;
    }
    public void setDemographicRaces(Set<DemographicRace> demographicRaces) {
        this.demographicRaces = demographicRaces;
    }
    public Set<DemographicGender> getDemographicSexualPreferences() {
        return demographicSexualPreferences;
    }
    public void setDemographicSexualPreferences(Set<DemographicGender> demographicSexualPreferences) {
        this.demographicSexualPreferences = demographicSexualPreferences;
    }
//======================================================================================


    public Set<GeoIPLocation> getAllEnabledGeoIPLocationsExcludeParentsIfMoreSpecificIsAvailable(boolean quite){
        Set<GeoIPLocation> out = new HashSet<GeoIPLocation>();
        out.addAll(getGeoIPLocationChildren(1,quite));
        out.addAll(getGeoIPLocationChildren(2,quite));
        out.addAll(getGeoIPLocationChildren(3,quite));
        out.addAll(getGeoIPLocationChildren(4,quite));
        return out;
    }
    private Set<GeoIPLocation> getGeoIPLocationChildren(int level,boolean quite){
        Set<GeoIPLocation> out = new HashSet<GeoIPLocation>();
        for(GeoIPLocationGroup parent : getGeoIPLocationGroups()){
            if(level == 4){
                if(!parent.isParent() && isParentInGroupList(parent)){
                    if(!quite){
                        logger.info("Adding locations for group CampaignFilterId:[{}] ParamLevel:[{}] -- Level:[{}] L1Name:[{}] L2Name:[{}] L3Name:[{}] L4Name:[{}] -- Count:[{}]",new Object[]{
                                getId(),
                                level,
                                parent.getParentLevel(),
                                parent.getGroupLevel1Name(),
                                parent.getGroupLevel2Name(),
                                parent.getGroupLevel3Name(),
                                parent.getGroupLevel4Name(),
                                parent.getGeoIPLocations().size()
                        });
                    }
                    out.addAll(parent.getGeoIPLocations());
                }
            }else{
                if(parent.isParent() && parent.getParentLevel() == level){
                    boolean hasChildren = false;
                    for(GeoIPLocationGroup child : getGeoIPLocationGroups()){
                        if(parent.isParent(child)){
                            hasChildren = true;
                            break;
                        }
                    }
                    if(!hasChildren && isParentInGroupList(parent)){
                        if(!quite){
                            logger.info("Adding locations for parent group CampaignFilterId:[{}] ParamLevel:[{}] -- Level:[{}] L1Name:[{}] L2Name:[{}] L3Name:[{}] L4Name:[{}] -- Count:[{}]",new Object[]{
                                    getId(),
                                    level,
                                    parent.getParentLevel(),
                                    parent.getGroupLevel1Name(),
                                    parent.getGroupLevel2Name(),
                                    parent.getGroupLevel3Name(),
                                    parent.getGroupLevel4Name(),
                                    parent.getGeoIPLocations().size()
                            });
                        }
                        out.addAll(parent.getGeoIPLocations());
                    }
                }
            }
        }
        return out;
    }
    private boolean isParentInGroupList(GeoIPLocationGroup child){
        if(child.getParentLevel() == 1){
            return true;
        }
        for(GeoIPLocationGroup parent : getGeoIPLocationGroups()){
            if(parent.isParent(child)){
                return isParentInGroupList(parent);
            }
        }
        return false;
    }
    public Set<Handset> getAllEnabledHandsetsExcludeParentsIfMoreSpecificIsAvailable(boolean quite){
        Set<Handset> out = new HashSet<Handset>();
        out.addAll(getHandsetChildren(1,quite));
        out.addAll(getHandsetChildren(2,quite));
        out.addAll(getHandsetChildren(3,quite));
        out.addAll(getHandsetChildren(4,quite));
        return out;
    }
    private Set<Handset> getHandsetChildren(int level, boolean quite){
        Set<Handset> out = new HashSet<Handset>();
        for(HandsetGroup parent : getHandsetGroups()){
            if(level == 4){
                if(!parent.isParent() && isParentInGroupList(parent)){
                    if(!quite){
                        logger.info("Adding handsets for group ParamLevel:[{}] -- Level:[{}] L1Name:[{}] L2Name:[{}] L3Name:[{}] L4Name:[{}] -- Count:[{}]",new Object[]{
                                level,
                                parent.getParentLevel(),
                                parent.getGroupLevel1Name(),
                                parent.getGroupLevel2Name(),
                                parent.getGroupLevel3Name(),
                                parent.getGroupLevel4Name(),
                                parent.getHandsets().size()
                        });
                    }
                    out.addAll(parent.getHandsets());
                }
            }else{
                if(parent.isParent() && parent.getParentLevel() == level){
                    boolean hasChildren = false;
                    for(HandsetGroup child : getHandsetGroups()){
                        if(parent.isParent(child)){
                            hasChildren = true;
                            break;
                        }
                    }
                    if(!hasChildren && isParentInGroupList(parent)){
                        if(!quite){
                            logger.info("Adding handsets for parent group ParamLevel:[{}] -- Level:[{}] L1Name:[{}] L2Name:[{}] L3Name:[{}] L4Name:[{}] -- Count:[{}]",new Object[]{
                                    level,
                                    parent.getParentLevel(),
                                    parent.getGroupLevel1Name(),
                                    parent.getGroupLevel2Name(),
                                    parent.getGroupLevel3Name(),
                                    parent.getGroupLevel4Name(),
                                    parent.getHandsets().size()
                            });
                        }
                        out.addAll(parent.getHandsets());
                    }
                }
            }
        }
        return out;
    }

    private boolean isParentInGroupList(HandsetGroup child){
        if(child.getParentLevel() == 1){
            return true;
        }
        for(HandsetGroup parent : getHandsetGroups()){
            if(parent.isParent(child)){
                return isParentInGroupList(parent);
            }
        }
        return false;
    }




    public boolean isFilterGroupSelected (HandsetGroup group){
        return this.handsetGroups.contains(group);
    }
    public boolean isFilterGroupSelected (GeoIPLocationGroup group){
        return this.geoIPLocationGroups.contains(group);
    }
    public static boolean validateIPTargetingRanges(String targetingIpRanges) {
        if(StringUtils.isBlank(targetingIpRanges)){
            return false;
        }
        try{
//            DatabaseIPRangeLocationDatasource db = new DatabaseIPRangeLocationDatasource(targetingIpRanges, new GeoIPLocation());
            return true;
        }catch (IllegalArgumentException e) {
            logger.warn("CampaignFilter IPRange validation failed.  Type: IllegalArgumentException  Reason: " + e.getMessage(),e);
        }catch (Exception e) {
            logger.warn("CampaignFilter IPRange validation failed.  Type: Exception  Reason: " + e.getMessage(),e);
        }
        return false;
    }
}
