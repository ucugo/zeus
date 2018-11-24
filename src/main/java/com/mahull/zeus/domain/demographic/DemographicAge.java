package com.mahull.zeus.domain.demographic;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class DemographicAge extends AbstractDemographic<Integer> {

    @Override
    protected Integer convertStringToValuesType(String input) {
        return NumberUtils.createInteger(StringUtils.trimToNull(input));
    }
    @Override
    protected String[] split(String input) {
        String[] inputItems = super.split(input);
        List<String> out = new ArrayList<String>();
        for(String inputItem : inputItems){
            if(inputItem.contains(">>")){
                String[] range = inputItem.split(">>");
                for(int i = convertStringToValuesType(range[0]) ; i <= convertStringToValuesType(range[0]) ; i++){
                    out.add("" + i);
                }
            }else{
                out.add(inputItem);
            }
        }
        return out.toArray(new String[0]);
    }
}
