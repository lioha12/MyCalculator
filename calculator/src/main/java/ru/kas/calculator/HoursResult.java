package ru.kas.calculator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import static ru.kas.calculator.HoursAndMinutes.minus;
import static ru.kas.calculator.HoursAndMinutes.plus;

/**
 * Created by User on 21.06.2016.
 */
public class HoursResult {
    //static ArrayList<String> resultList = new ArrayList<>();

    transient String result;
    transient HoursAndMinutes res;

    public HoursResult(){
    }

    public String getResult(String in)throws Exception {

        result = "";
        String [] strings = in.split("[+-]");
        ArrayList<String> plusAndMinuses = new ArrayList<>();
        char[] chars = in.toCharArray();
        for(int i = 0; i < chars.length; i++)
        {
            if(chars[i] == '+')
            {
                plusAndMinuses.add("+");
            }
            else if(chars[i] == '-') plusAndMinuses.add("-");
        }
        int index = 0;
        for(int i = 0; i < strings.length; i++)
        {
            HoursAndMinutes a;
            HoursAndMinutes b;
            if(res == null) {
                if (strings[i].contains(":")) {
                    String[] str1 = strings[i].split(":");
                    int er = str1.length;
                    String sq = str1[0];
                    a = new HoursAndMinutes(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]));
                } else
                    a = new HoursAndMinutes(Integer.parseInt(strings[i]), 0);

                if (strings[i+1].contains(":"))
                {
                    String[] str2 = strings[i+1].split(":");
                    b = new HoursAndMinutes(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]));
                }
                else b = new HoursAndMinutes(Integer.parseInt(strings[i+1]), 0);
                if(plusAndMinuses.get(index).equals("+"))
                {
                   res = plus(a, b);
                    index++;
                    i++;
                }
                else if(plusAndMinuses.get(index).equals("-"))
                {
                    res = minus(a, b);
                    index++;
                    i++;
                }
            }
            else
            {
                if(strings[i].contains(":"))
                {
                    String[]str1 = strings[i].split(":");
                    b = new HoursAndMinutes(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]));
                }
                else b = new HoursAndMinutes(Integer.parseInt(strings[i]), 0);

                if(plusAndMinuses.get(index).equals("+"))
                {
                    res = plus(res, b);
                    index++;
                }
                else if(plusAndMinuses.get(index).equals("-"))
                {
                    res = minus(res, b);
                    index++;
                }
            }
        }
        result = String.valueOf(res.hours) + ":" + String.valueOf(res.min);
        //resultList.add(result);

        return result;
    }

    /*@Override
    public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
        resultList = (ArrayList<String>) input.readObject();
    }

    @Override
    public void writeExternal(ObjectOutput output) throws IOException {
        output.writeObject(resultList);
    }*/
}
