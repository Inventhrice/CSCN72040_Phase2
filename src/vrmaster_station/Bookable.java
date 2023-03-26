package vrmaster_station;

public abstract class Bookable 
{
    protected int id;
    protected boolean available;
    public abstract void book();
    public abstract void unbook();
    public abstract boolean getAvailability();
    public abstract void setAvailability(boolean newAvailable);
    public abstract void setId(int newId);
    public abstract int getId();
}