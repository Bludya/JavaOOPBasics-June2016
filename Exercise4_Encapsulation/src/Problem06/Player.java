package Problem06;

/**
 * Created by Bludya on 1.7.2016 г..
 * All rights reserved!
 */
class Player{
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public Player(String name, double endurance, double sprdouble, double dribble, double passing, double shooting) throws IllegalArgumentException{
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprdouble);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

   private void setName(String name) throws IllegalArgumentException {
       if(name == null || name.trim().length() == 0){
           throw new IllegalArgumentException("A name should not be empty.");
       }
        this.name = name;
    }

    private void setEndurance(double endurance) throws IllegalArgumentException{
        validateInput(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(double sprint) throws IllegalArgumentException {
        validateInput(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(double dribble) throws IllegalArgumentException {
        validateInput(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(double passing) throws IllegalArgumentException {
        validateInput(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(double shooting) throws IllegalArgumentException {
        validateInput(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void validateInput(double input, String statName){
        if(input < 0 || input > 100){
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }

    public double getAverageRating(){
        return (endurance + sprint + dribble + passing + shooting) / 5;
    }

    public String getName() {
        return name;
    }
}
