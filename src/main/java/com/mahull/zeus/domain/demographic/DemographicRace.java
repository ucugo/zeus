package com.mahull.zeus.domain.demographic;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "demographic_race")
public class DemographicRace extends AbstractDemographic {

    @Override
    protected String convertStringToValuesType(String input) {
        return StringUtils.trimToNull(input);
    }
}
