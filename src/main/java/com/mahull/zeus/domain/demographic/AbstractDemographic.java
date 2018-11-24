package com.mahull.zeus.domain.demographic;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractDemographic<ListValueType> {

    private String displayName;
    private String value;

    @Id
    @GeneratedValue
    private UUID uuid;
    @Transient
    List<ListValueType> values;

    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        _setValues(value,true);
        this.value = value;
    }
    public List<ListValueType> getValues() {
        _setValues(getValue(), false);
        return this.values;
    }
    private void _setValues(String rawValue,boolean forceChange){
        if(this.values != null && !forceChange){
            return;
        }
        if(rawValue==null){
            this.value=null;
            return;
        }
        List<ListValueType> values = new ArrayList<ListValueType>();

        for(String value : split(rawValue)){
            ListValueType lvt = convertStringToValuesType(value);
            if(lvt != null){
                values.add(lvt);
            }
        }
        this.values=values;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    protected String[] split(String input){
        return StringUtils.split(input, ",");
    }
    protected abstract ListValueType convertStringToValuesType(String input);
}
