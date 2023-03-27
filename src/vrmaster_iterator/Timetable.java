package vrmaster_iterator;

import java.time.LocalDateTime;
import java.util.ArrayList;

import vrmaster_database.BookingInfo;
import vrmaster_station.Station;

public class Timetable implements Aggregate
{
    private ArrayList<BookingInfo> timetable;
    
    private class TimetableIterator implements Iterator
    {
        private ArrayList<BookingInfo> timetable;
        private int index;
        
        public TimetableIterator(Timetable newTimetable) 
        {
            this.timetable = newTimetable.getTimetable();
        }

        @Override
        public boolean hasNext()
        {
            return index < timetable.size();
        }

        @Override
        public Object next()
        {
            if(hasNext()) return timetable.get(index++);
            else return null;
        }
        
    } 

    @Override
    public Iterator iterator() {
        return new TimetableIterator(this);
    }

    public ArrayList<BookingInfo> getTimetable() 
    {
        return timetable;
    }
    
    public void setTimetable(ArrayList<BookingInfo> newTimetable) 
    {
        this.timetable = newTimetable;
    }

    public void addBooking(BookingInfo toAdd) 
    {
        timetable.add(toAdd);
    }

    public Timetable getDemoTimetable() {
		
		ArrayList<BookingInfo> bookingList = new ArrayList<BookingInfo>();
		BookingInfo temp;
		Station stationtemp;
		for(int roomNum = 1; roomNum <= 10; roomNum++) {
			for(int hour = 9; hour <= 16; hour++) {
				stationtemp = new Station(roomNum, true);
				
				temp = new BookingInfo();
				temp.setBookingDateTime(LocalDateTime.of(2023, 3, 31, hour, 0));
				temp.setRoom(stationtemp);
				
				bookingList.add(temp);
			}
		}

		Timetable newTimetable = new Timetable();
        newTimetable.setTimetable(bookingList);
		return newTimetable;
	}
}
