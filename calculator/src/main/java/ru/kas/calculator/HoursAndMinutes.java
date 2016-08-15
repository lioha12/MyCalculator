package ru.kas.calculator;

/**
 * Created by User on 21.06.2016.
 */
public class HoursAndMinutes {

    int min;
    int hours;

    public HoursAndMinutes(int hours, int min)
    {
        this.hours = hours;
        this.min = min;
        if(min >= 60)
        {
            int q = (int)(min/60);
            if(q >= 1) {
                this.hours += q;
                this.min = min - q * 60;
            }
            if (q < 1)
            {
                this.hours++;
                this.min = 60 - min;
            }
        }
    }

    public static HoursAndMinutes plus(HoursAndMinutes a, HoursAndMinutes b) throws Exception
    {
        int minut = 0;
        int hour = 0;
        hour = a.hours + b.hours;
        minut = a.min + b.min;
        if(minut >= 60)
        {
            int q = (int)minut/60;
            if(q >= 1) {
                hour += q;
                minut = minut - 60 * q;
            }
            else if(q < 1)
            {
                hour++;
                minut = 60 - minut;
            }
        }

        return new HoursAndMinutes(hour, minut);
    }
    public static HoursAndMinutes minus(HoursAndMinutes a, HoursAndMinutes b)throws Exception
    {
        int minut = 0;
        int hour = 0;

        hour = a.hours - b.hours;
        minut = a.min - b.min;
        if (minut < 0)
        {
            int q = (int)(minut / -60);
            if (q == 0)
            {
                hour--;
                minut = 60 + minut;
            }
        }
        return new HoursAndMinutes(hour, minut);
    }
}
