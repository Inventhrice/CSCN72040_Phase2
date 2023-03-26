package vrmaster_station;
public class PartyRoomUnbookCommand implements Command
{
    private PartyRoom room;

    public PartyRoomUnbookCommand(PartyRoom newRoom)
    {
        this.room = newRoom;
    }

    PartyRoom getPartyRoom()
    {
        return room;
    }

    @Override
    public void execute()
    {
        room.unbook();
    }
}
