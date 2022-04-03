import java.util.Comparator;

public class PointCompare implements Comparator<Formula1Driver>{

    @Override
    public int compare(Formula1Driver d1, Formula1Driver d2) {
        if(d1.getNum_of_points()==d2.getNum_of_points()){  // if d1 and d2 have same number of position  check first position
            if(d1.getFirst_position()>d2.getFirst_position()){//if d1 has first positions more than d2 ,return 1
                return 1;
            }else if(d1.getFirst_position()==d2.getFirst_position()){//if d1 and d2 have same first positions ,return 0
                return 0;
            }else{ //if d2 has first positions more than d1 ,return -1
                return -1;
            }
        }else if(d1.getNum_of_points()>d2.getNum_of_points()){ //if d1 has number of position more than d2 ,return 1
            return 1;
        }else{ //if d2 has number of positions more than d1 ,return -1
            return -1;
        }
    }
}



