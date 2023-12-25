package filters;

import com.gridnine.testing.Flight;
import filters.Interface.FilterInterface;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/*вылет до текущего времени
* */
public class DepartureBeforeCurrentTimeFilter implements FilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream().
                filter(flight -> flight.getSegments().stream().
                        allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
