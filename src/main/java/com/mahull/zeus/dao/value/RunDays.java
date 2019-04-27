package com.mahull.zeus.dao.value;

public enum RunDays {
    RUN_ON_MONDAY("Monday"),
    RUN_ON_TUESDAY("Tuesday"),
    RUN_ON_WEDNESDAY("Wednesday"),
    RUN_ON_THURSDAY("Thursday"),
    RUN_ON_FRIDAY("Friday"),
    RUN_ON_SATURDAY("Saturday"),
    RUN_ON_SUNDAY ("Sunday");

    private final String day;

    RunDays(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
