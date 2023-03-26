package vrmaster_station;

public class PartyRoom extends Bookable
{
    PartyRoom()
    {
        available = false;
    }

    @Override
    public void book() 
    {
        available = true;
    }

    @Override
    public void unbook() 
    {
        available = false;
    }

    public boolean getAvailability()
    {
        return available;
    }

    @Override
    public void setAvailability(boolean newAvailable)
    {
        this.available = newAvailable;
    }

    @Override
    public void setId(int newId) 
    {
        this.id = newId;
    }

    @Override
    public int getId() 
    {
        return id;
    }
    @Override
    public boolean equals(Object o)
    {
    	if(o instanceof PartyRoom) {
    		PartyRoom s = (PartyRoom) o;
            return this.id == s.id && this.available == s.available;
        }
        else return false;
    }
}