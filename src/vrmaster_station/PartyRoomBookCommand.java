package vrmaster_station;
public class PartyRoomBookCommand implements Command
{
    private PartyRoom room;

    PartyRoomBookCommand(PartyRoom newRoom)
    {
        room = newRoom;
    }

    public void setRoom(PartyRoom newRoom) 
    {
        room = newRoom;
    }

    PartyRoom getPartyRoom()
    {
        return room;
    }

    @Override
    public void execute()
    {
        room.book();
    }
}
