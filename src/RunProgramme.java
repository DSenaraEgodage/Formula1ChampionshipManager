import java.text.ParseException;
public class RunProgramme {
    public static void main(String[] args) throws ParseException {
        Formula1ChampionshipManager f = new Formula1ChampionshipManager();
        f.loadRace();
        f.load();
        while (true) {
            f.mainmenu();
        }
    }
}

