import java.util.Comparator;

public class ComparePositionByFirst implements Comparator<Formula1Driver>{

    @Override
    public int compare(Formula1Driver d1, Formula1Driver d2) {
        if(d1.getFirst_position()==d2.getFirst_position()){ //if d1 and d2 have same first positions ,return 0
            return 0;
        }else if(d1.getFirst_position()>d2.getFirst_position()){ //if d1 has first positions more than d2 ,return 1
            return 1;
        }else{ //if d2 has first positions more than d1 ,return -1
            return -1;
        }
    }
}
