package vrmaster_station;
public class StationBookCommand implements Command
{
    private Station station;

    public StationBookCommand(Station newStation)
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
