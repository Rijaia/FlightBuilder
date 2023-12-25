package filters;

import com.gridnine.testing.Flight;
import filters.Interface.FilterInterface;

import java.util.List;
import java.util.stream.Collectors;
/*Прилет раньше вылета*/

public class ArrivalBeforeDepartureFilter implements FilterInterface {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
