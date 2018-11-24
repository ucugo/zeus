package com.mahull.zeus.domain.advertiser;

public enum ApprovalState {
    Approved("Approved"), Disapproved("Rejected"), Pending("Pending");
    private final String displayName;
    private ApprovalState(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
