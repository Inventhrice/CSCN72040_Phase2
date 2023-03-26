package vrmaster_station;
public class StationBookCommand implements Command
{
    private Station station;

    StationBookCommand(Station newStation)
    {
        station = newStation;
    }

    public void setStation(Station newStation) 
    {
        station = newStation;
    }

    public Station getStation()
    {
        return station;
    }

    @Override
    public void execute()
    {
        station.book();
    }
}
