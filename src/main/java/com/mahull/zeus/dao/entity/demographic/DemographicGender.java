package com.mahull.zeus.dao.entity.demographic;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "demographic_gender")
public class DemographicGender extends AbstractDemographic {

    @Override
    protected String convertStringToValuesType(String input) {
        return StringUtils.trimToNull(input);
    }
}
