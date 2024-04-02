package interfaces.ex3;

public class Programmer implements Person {

    int ageStarted = 18;

    @Override
    public int workExperience(){
       return  age - ageStarted;
    }

}
