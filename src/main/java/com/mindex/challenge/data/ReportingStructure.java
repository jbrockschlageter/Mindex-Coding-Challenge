package com.mindex.challenge.data;

public class ReportingStructure {
    
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){}

    public int setEmployee(Employee e){
        if(e == null){
            return 1;
        }
        employee = e;
        return 0;
    }

    public Employee getEmployee(){
        return employee;
    }

    public int setNumberOfReports(int num){
        if(num < 0){
            return 1;
        }
        numberOfReports = num;
        return 0;
    }

    public int getNumOfReports(){
        return numberOfReports;
    }
    
}
