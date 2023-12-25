package filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import filters.Interface.FilterInterface;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TimeOnEarthFilter implements FilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(flight -> calculateTimeOnEarth(flight) <= 2)
                .collect(Collectors.toList());
    }

    private long calculateTimeOnEarth(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long timeOnEarth = 0;
        for (int i = 0; i < segments.size()-1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime departure = segments.get(i).getDepartureDate();
            timeOnEarth = timeOnEarth + arrival.until(departure, ChronoUnit.HOURS);
        }
        return timeOnEarth;
    }
}
