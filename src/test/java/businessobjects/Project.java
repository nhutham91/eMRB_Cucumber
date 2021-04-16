package businessobjects;

public class Project {

    public Project(String projectNo, String projectName, String serialNo) {
        ProjectNo = projectNo;
        ProjectName = projectName;
        SerialNo = serialNo;
    }

    public String getProjectNo() {
        return ProjectNo;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    String ProjectNo;
    String ProjectName;

    public void setProjectNo(String projectNo) {
        ProjectNo = projectNo;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    String SerialNo;


}
