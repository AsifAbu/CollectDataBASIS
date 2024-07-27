package pages;

public class CompanyInfo {
    String companyName, companyAddress, companyEmail, companyWebAddress, companyPhone, affiliateNumber, memberFrom, validTill;
    String representatorName, representatorDesignation, representatorEmail;


    public CompanyInfo(String companyName, String companyAddress, String companyEmail, String companyWebAddress, String companyPhone,
                       String affiliateNumber, String memberFrom, String validTill, String representatorName, String representatorDesignation,
                       String representatorEmail) {
        super();
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyEmail = companyEmail;
        this.companyWebAddress = companyWebAddress;
        this.companyPhone = companyPhone;
        this.affiliateNumber = affiliateNumber;
        this.memberFrom = memberFrom;
        this.validTill = validTill;

        this.representatorName = representatorName;
        this.representatorDesignation = representatorDesignation;
        this.representatorEmail = representatorEmail;
        //this.representatorContact = representatorContact;
    }
    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public String getCompanyWebAddress() {
        return companyWebAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getAffiliateNumber() {
        return affiliateNumber;
    }

    public String getMemberFrom() {
        return memberFrom;
    }

    public String getValidTill() {
        return validTill;
    }
    public String getRepresentatorName() {
        return representatorName;
    }

    public String getRepresentatorDesignation() {
        return representatorDesignation;
    }

    public String getRepresentatorEmail() {
        return representatorEmail;
    }

//    public String getRepresentatorContact() {
//        return representatorContact;
//    }


}
