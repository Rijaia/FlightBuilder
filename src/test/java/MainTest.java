import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import filters.ArrivalBeforeDepartureFilter;
import filters.DepartureBeforeCurrentTimeFilter;
import filters.Interface.FilterInterface;
import filters.TimeOnEarthFilter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void ArrivalBeforeDepartureFilterTest() {
        List<Flight> flights = FlightBuilder.createFlights();
        FilterInterface arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlight = arrivalBeforeDepartureFilter.filter(flights);
        assertEquals (filteredFlight.size(),5);
        assertEquals(filteredFlight.get(0), flights.get(0));
    }

    @Test
    public void DepartureBeforeCurrentTimeFilterTest() {
        List<Flight> flights = FlightBuilder.createFlights();
        FilterInterface departureBeforeCurrentTimeFilter = new DepartureBeforeCurrentTimeFilter();
        List<Flight> filteredFlight = departureBeforeCurrentTimeFilter.filter(flights);
        assertEquals(filteredFlight.size(), 5);
        assertEquals(filteredFlight.get(0), flights.get(0));

    }

    @Test
    public void TimeOnEarthFilterTest() {
        List<Flight> flights = FlightBuilder.createFlights();
        FilterInterface timeOnEarthFilter = new TimeOnEarthFilter();
        List<Flight> filteredFlight = timeOnEarthFilter.filter(flights);
        assertEquals(filteredFlight.size(),6);
        assertEquals(filteredFlight.get(0),flights.get(0));
    }
}
