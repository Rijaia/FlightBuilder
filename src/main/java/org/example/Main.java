package org.example;

import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.Segment;
import filters.ArrivalBeforeDepartureFilter;
import filters.DepartureBeforeCurrentTimeFilter;
import filters.Interface.FilterInterface;
import filters.TimeOnEarthFilter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*тестовые перелеты*/
        List<Flight> flights = FlightBuilder.createFlights();

        /*выводим в консоль все тестовые перелеты*/
        System.out.println("Все перелеты:");
        printFlights(flights);

        /*Выводим в консоль полеты с временем отправления до настоящего времени*/
        System.out.println("Перелеты с временем вылета до настоящего времени: ");
        FilterInterface departureBeforeCurrentTimeFilter = new DepartureBeforeCurrentTimeFilter();
        printFlights(departureBeforeCurrentTimeFilter.filter(flights));

        /*Выводим в консоль перелеты с сегментами с вылетом позже отправления*/
        System.out.println("Перелеты с сегментами с временем вылета позже времени прилета: ");
        FilterInterface arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        printFlights(arrivalBeforeDepartureFilter.filter(flights));

        /*Выводим в консоль перелеты, в которых время нахождения на земле более 2х часов*/
        System.out.println("Перелеты, в которых время нахождения на земле более 2х часов: ");
        FilterInterface timeOnEarthFilter = new TimeOnEarthFilter();
        printFlights(timeOnEarthFilter.filter(flights));
    }


        /*Формат вывода перелетов в консоль*/
    private static void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Перелет: ");
            for (Segment segment : flight.segments) {
                System.out.println(segment.getDepartureDate()+"-"+segment.getArrivalDate());
            }
        }
    }



}