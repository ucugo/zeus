package com.mahull.zeus.domain.advertiser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "advert_category")
public class AdvertCategory {

    @Id
    @GeneratedValue
    private UUID id;

    public static List<AdvertCategory> getDefaultCategories() {
        return Arrays.asList(new AdvertCategory("Other"),
                new AdvertCategory("Adult"),
                new AdvertCategory("Glamour"),
                new AdvertCategory("Dating"),
                new AdvertCategory("Content")
        );
    }

    @javax.validation.constraints.NotBlank
    private String categoryName;

    public AdvertCategory() {

    }

    private AdvertCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
