import java.text.ParseException;

public interface ChampionshipManager {
    public void newDriver();
    public void delete_Driver();
    public void changeTheDriver();
    public void displayDriverStatics();
    public void newRace() throws ParseException;
    public void fullInformationTable();
    public void save();
    public void load();
    //since Formula1ChampionshipManager is implemented by championship manager all methods are set to public
}

