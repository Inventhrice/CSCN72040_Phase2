package vrmaster_station;
public class PartyRoomUnbookCommand implements Command
{
    private PartyRoom room;

    PartyRoomUnbookCommand(PartyRoom newRoom)
    {
        this.room = newRoom;
    }
    
    public void setRoom(PartyRoom newRoom)
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
