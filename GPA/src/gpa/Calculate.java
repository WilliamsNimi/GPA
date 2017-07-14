package gpa;

public class Calculate {
    static int qualityPoint = 0;
    static int sumQP = 0;
    static int creditUnitSum = 0;
    public static double qualityPoint(char grade, int creditUnit){
        switch(grade)
        {
            case 'A':
                qualityPoint = creditUnit*5;
                break;
            case 'B':
                qualityPoint = creditUnit*4;
                break;
            case 'C':
                qualityPoint = creditUnit*3;
                break;
            case 'D':
                qualityPoint = creditUnit*2;
                break;
            case 'E':
                qualityPoint = creditUnit*1;
                break;
            case 'F':
                qualityPoint = creditUnit*0;
                break;
            default: System.out.println("Print error to screen");
            
        }
        return qualityPoint;
    }
    
    public static double GPA(int sumQP, int creditUnitSum){
        int GPA = sumQP/creditUnitSum;
        return GPA;
    }
    
}
