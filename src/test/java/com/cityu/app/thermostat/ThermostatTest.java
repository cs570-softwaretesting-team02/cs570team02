package com.cityu.app.thermostat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ThermostatTest {

    @Test
    // Ther-T01 - tttt - all clauses are True
    public void TTTT() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        set.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(63);
        ther.setThresholdDiff(5);
        ther.setOverride(true);
        ther.setOverTemp(70);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(12);
        assertEquals(true, ther.turnHeaterOn(set));
    }

    @Test
    // Ther-T02 - ffff - all clauses are False
    public void FFFF() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        set.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(75);
        ther.setThresholdDiff(5);
        ther.setOverride(false);
        ther.setOverTemp(70);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(5);
        assertEquals(false, ther.turnHeaterOn(set));
    }

    @Test
    // Ther-T03 - ttft -- Major clause is a. Main predicate is True.
    public void TTFT() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        set.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(63);
        ther.setThresholdDiff(5);
        ther.setOverride(true);
        ther.setOverTemp(65);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(12);
        assertEquals(true, ther.turnHeaterOn(set));
    }

    @Test
    // Ther-T04 - fftt -- Major clause is a. Main predicate is False.
    public void FFTT() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        set.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(66);
        ther.setThresholdDiff(5);
        ther.setOverride(false);
        ther.setOverTemp(75);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(12);
        assertEquals(false, ther.turnHeaterOn(set));
    }

    @Test
    // Ther-T05 - ftft -- Major clause is a. Main predicate is False.
    public void FTFT() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        set.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(67);
        ther.setThresholdDiff(5);
        ther.setOverride(true);
        ther.setOverTemp(65);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(12);
        assertEquals(false, ther.turnHeaterOn(set));
    }

    @Test
    // Ther-T06 - Major clause is d. Main predicate is False.
    public void TTTF() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        set.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(63);
        ther.setThresholdDiff(5);
        ther.setOverride(true);
        ther.setOverTemp(70);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(5);
        assertEquals(false, ther.turnHeaterOn(set));
    }

    @Test
    // Ther-T07 - Major clause is d. Main predicate is True.
    public void TFTT() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        set.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(63);
        ther.setThresholdDiff(5);
        ther.setOverride(false);
        ther.setOverTemp(70);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(15);
        assertEquals(true, ther.turnHeaterOn(set));
    }

    @Test
    // Fault
    // Ther-T08 - Heater should not turn on
    public void testInvalidMinLag() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(63);
        ther.setThresholdDiff(5);
        ther.setOverride(false);
        ther.setOverTemp(70);
        ther.setMinLag(-8);
        ther.setTimeSinceLastRun(15);
        assertEquals(false, ther.turnHeaterOn(set));
    }

    @Test
    // Fault
    // Ther-T09 - Heater should not turn on
    public void testInvalidTimeSinceLastRun() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        ther.setPeriod(Period.MORNING);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(58);
        ther.setThresholdDiff(5);
        ther.setOverride(false);
        ther.setOverTemp(70);
        ther.setMinLag(-18);
        ther.setTimeSinceLastRun(-15);
        assertEquals(false, ther.turnHeaterOn(set));
    }

    @Test
    // Fault
    // Ther-T10 - Heater should not turn on
    public void testInvalidPeriod() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        ther.setPeriod(null);
        ther.setDay(DayType.WEEKDAY);
        ther.setCurrentTemp(63);
        ther.setThresholdDiff(5);
        ther.setOverride(false);
        ther.setOverTemp(70);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(15);
        assertEquals(false, ther.turnHeaterOn(set));
    }

    @Test
    // Fault
    // Ther-T11 - Heater should not turn on
    public void testInvalidDay() {
        Thermostat ther = new Thermostat();
        ProgrammedSettings set = new ProgrammedSettings();

        ther.setPeriod(Period.MORNING);
        ther.setDay(null);
        ther.setCurrentTemp(63);
        ther.setThresholdDiff(5);
        ther.setOverride(false);
        ther.setOverTemp(70);
        ther.setMinLag(8);
        ther.setTimeSinceLastRun(15);
        assertEquals(false, ther.turnHeaterOn(set));
    }
}
