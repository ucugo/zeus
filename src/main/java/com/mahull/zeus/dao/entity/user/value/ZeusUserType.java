package com.mahull.zeus.dao.entity.user.value;

public enum ZeusUserType {

    Admin, Internal, External;

    public static String[] getNames() {
        String[] out = new String[values().length];
        for(int i = 0 ; i < values().length ; i++ ){
            out[i] = values()[i].name();
        }
        return out;
    }
}
