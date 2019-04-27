package com.mahull.zeus.dao.entity.device.value;

import java.util.HashSet;

public enum WurflCapabilityList {

    BrandName("brand_name",false),
    ModelName("model_name",false),
    MarketingName("marketing_name",false),
    ModelExtraInfo("model_extra_info",false),

    Os("device_os",false),
    OsVersion("device_os_version",false),

    Browser("mobile_browser",false),
    BrowserVersion("mobile_browser_version",false),

    MayHaveMsisdn("can_assign_phone_number",false),
    HasWifi("wifi",false),
    IsWirelessDevice("is_wireless_device",false),
    IsTablet("is_tablet",false),
    ScreenWidth("resolution_width",false),
    ScreenHeight("resolution_height",false),
    MaxImageWidth("max_image_width",false),
    MakePhoneCallString("xhtml_make_phone_call_string",false),
    MakePhoneSmsString("xhtml_send_sms_string",false)
    ;
    private final String capabilityName;
    private final String description;
    private final boolean virtual;

    private WurflCapabilityList(String capabilityName, boolean virtual){
        this(capabilityName,virtual,null);
    }
    private WurflCapabilityList(String capabilityName, boolean virtual, String description){
        this.capabilityName=capabilityName;
        this.description=description;
        this.virtual=virtual;
    }

    public String getCapabilityName() {
        return capabilityName;
    }
    public String getDescription() {
        return description;
    }
    public boolean isVirtual() {
        return virtual;
    }
    public static HashSet<String> getRequiredCapabilities(){
        HashSet<String> out = new HashSet<String>();
        for(WurflCapabilityList entry : WurflCapabilityList.values()){
            out.add(entry.getCapabilityName());
        }
        return out;
    }
}
