import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Race implements Serializable {
   private static final long serialVersionUID = 1002L;
   private Date date;
   private Formula1Driver[] positions;
   public Race(String raceDate, Formula1Driver[] positions) throws ParseException {
      this.date = new SimpleDateFormat("dd/MM/yyyy").parse(raceDate);;
      this.positions = positions;

   }

   public Date getDate() { //making
      return date;
   }

   public Formula1Driver[] getPositions() {
      return positions;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public void setPositions(Formula1Driver[] positions) {
      this.positions = positions;
   }
}
