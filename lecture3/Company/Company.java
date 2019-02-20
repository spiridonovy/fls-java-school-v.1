package Company;

import Office.OfficeBuilding;

import java.util.ArrayList;

public class Company {
    private String CompanyName;
    private ArrayList<OfficeBuilding> companyOffices;

    public Company(String CompanyName) {
        this.CompanyName = CompanyName;
        this.companyOffices = new ArrayList<OfficeBuilding>();
    }

    public void addNewOfficeBuilding(OfficeBuilding office) {
        this.companyOffices.add(office);
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public OfficeBuilding getOfficeByName(String officeName) {
        for (var office : this.companyOffices) {
            if (office.getOfficeName() == officeName)
                return office;
        }
        return null;
    }
}
