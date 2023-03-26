package vrmaster_station;

public class Station extends Bookable
{
    Station()
    {
        available = false;
    }
    
    public Station(int id, boolean avail)
    {
        this.id = id;
    	available = avail;
    }

    @Override
    public void book() 
    {
        available = false;
    }

    @Override
    public void unbook() 
    {
        available = true;
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
        if(o instanceof Station) {
        	Station s = (Station) o;
            return this.id == s.id && this.available == s.available;
        }
        else return false;
    }
}