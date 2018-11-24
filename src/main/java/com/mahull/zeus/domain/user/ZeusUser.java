package com.mahull.zeus.domain.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "zeus_users")
public class ZeusUser {
    private static final long serialVersionUID = -839799760599537172L;
    public static final String RequestScopeAttributeName="pollen8user";

    @Id
    @GeneratedValue
    private UUID uuid;

    @NotNull
    private String username;
    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ZeusUserType accountType;

    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String skypeName;
    @NotNull
    private String emailAddress;
    @NotNull
    private String contactNumberCellphone;
    private String contactNumberLandline;
    @NotNull
    private String country;
    private String agencyName;
    private String agencyContactNumber;
    private String agencyAddress;

    private String billingMethod;
    private String billingBranchCode;
    private String billingBranch;
    private String billingName;
    private String billingAccountNo;
    private String billingAccountName;

}
