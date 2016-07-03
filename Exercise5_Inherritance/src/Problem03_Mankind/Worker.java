package Problem03_Mankind;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class Worker extends Human{
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName){
        if(lastName.length() < 4){
            throw new IllegalArgumentException(Exceptions.WORKER_LAST_NAME_LENGTH);
        }

        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if(weekSalary <= 10){
            throw new IllegalArgumentException(Exceptions.INVALID_SALARY);
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if(workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException(Exceptions.INVALID_WORK_HOURS);
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double calculateSalaryPerHour(){
        return weekSalary / (workHoursPerDay * 7);
    }

    @Override
    public String toString(){
        return String.format("First Name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f%n",
                super.getFirstName(),
                super.getLastName(),
                weekSalary,
                workHoursPerDay,
                this.calculateSalaryPerHour());
    }
}
