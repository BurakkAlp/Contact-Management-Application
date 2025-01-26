public class BusinessContact extends Contact {
    private String companyName;
    private String jobTitle;

    public BusinessContact(String name, String phoneNumber, String email, String companyName, String jobTitle) {
        super(name, phoneNumber, email);
        this.companyName = companyName;
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public void displayContact() {
        super.displayContact();
        System.out.println("Company Name: " + companyName);
        System.out.println("Job Title: " + jobTitle);
    }
}
