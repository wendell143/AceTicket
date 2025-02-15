package com.example.demo3;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TicketProperty {
    private LongProperty id = new SimpleLongProperty();
    private StringProperty name = new SimpleStringProperty();

    private StringProperty department = new SimpleStringProperty();

    private StringProperty concern = new SimpleStringProperty();

    private StringProperty staff= new SimpleStringProperty();

    private StringProperty Status = new SimpleStringProperty();

    public long getId(long id) {
        return this.id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {

        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDepartment() {
        return department.get();
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department.set(department);
    }
    public String getConcern() {
        return concern.get();
    }
    public StringProperty concernProperty() {
        return concern;
    }
    public void setConcern(String concern)
    {
        this.concern.set(concern);
    }



    public String getstaff() {

        return staff.get();
    }

    public StringProperty staffProperty() {
        return staff;
    }

    public void setstaff(String staff) {
        this.staff.set(staff);
    }

    public String getStatus() {
        return Status.get();
    }

    public StringProperty statusProperty() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }


}
