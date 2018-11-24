package com.mahull.zeus.domain.advertiser;

public class DisplayabilityResult {

    public static DisplayabilityResult displayable() {
        return new DisplayabilityResult(true, "");
    }

    public static DisplayabilityResult notDisplayable(String reason) {
        return new DisplayabilityResult(false, reason);
    }

    private final boolean displayable;
    private final String reason;

    private DisplayabilityResult(boolean displayable, String reason) {
        this.displayable = displayable;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public boolean isDisplayable() {
        return displayable;
    }
}
