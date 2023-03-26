package vrmaster_station;
public class StationUnbookCommand implements Command
{
    private Station station;

    public StationUnbookCommand(Station newStation)
    {
        this.station = newStation;
    }

    public Station getStation()
    {
        return station;
    }

    @Override
    public void execute()
    {
        station.unbook();
    }
}
