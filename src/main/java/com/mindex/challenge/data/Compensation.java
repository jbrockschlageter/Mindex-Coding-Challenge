package com.mindex.challenge.data;

import java.util.Date;

public class Compensation {
    
    private String employeeId; //Needed to register MongoDB with Compensation & link to ID
    
    private Employee employee;
    private int salary;
    private Date effectiveDate;


    public String getEmployeeId(){
        return employeeId;
    }

    public String setEmployeeId(){
        employeeId = employee.getEmployeeId();
        return employeeId;
    }
    
    public Employee getEmployee(){
        return employee;
    }

    public int setEmployee(Employee e){
        if(e == null){
            return 1;
        }
        employee = e;
        return 0;
    }

    public int getSalary(){
        return salary;
    }

    public int setSalary(int num){
        if(num < 0){
            return 1;
        }
        salary = num;
        return 0;
    }

    public Date getEffectiveDate(){
        return effectiveDate;
    }

    public int setEffectiveDate(Date date){
        if(date == null){
            return 1;
        }
        effectiveDate = date;
        return 0;
    }
}
