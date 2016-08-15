package ru.kas.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

/**
 * Created by User on 21.06.2016.
 */
public class HourseMain extends AppCompatActivity implements View.OnClickListener{

    TextView textView2;
    Button btnCH;
    Button btnDELH;
    Button btn1H;
    Button btn2H;
    Button btn3H;
    Button btn4H;
    Button btn5H;
    Button btn6H;
    Button btn7H;
    Button btn8H;
    Button btn9H;
    Button btn0H;
    Button btnPlH;
    Button btnMinusH;
    Button btnEqH;
    Button btnTchH;

    String str = "";

    SharedPreferences sPr;
    final String LIST_SIZE = "listSize";

    ArrayList<String> resultList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hourscalc);
        btn0H = (Button)findViewById(R.id.btn0H);
        btn1H = (Button)findViewById(R.id.btn1H);
        btn2H = (Button)findViewById(R.id.btn2H);
        btn3H = (Button)findViewById(R.id.btn3H);
        btn4H = (Button)findViewById(R.id.btn4H);
        btn5H = (Button)findViewById(R.id.btn5H);
        btn6H = (Button)findViewById(R.id.btn6H);
        btn7H = (Button)findViewById(R.id.btn7H);
        btn8H = (Button)findViewById(R.id.btn8H);
        btn9H = (Button)findViewById(R.id.btn9H);
        btnCH = (Button)findViewById(R.id.btnCH);
        btnDELH = (Button)findViewById(R.id.btnDELH);
        btnEqH = (Button)findViewById(R.id.btnEqH);
        btnMinusH = (Button)findViewById(R.id.btnMinusH);
        btnPlH = (Button)findViewById(R.id.btnPlH);
        btnTchH = (Button)findViewById(R.id.btnTchH);
        textView2 = (TextView)findViewById(R.id.tvH);

        btn0H.setOnClickListener(this);
        btn1H.setOnClickListener(this);
        btn2H.setOnClickListener(this);
        btn3H.setOnClickListener(this);
        btn4H.setOnClickListener(this);
        btn5H.setOnClickListener(this);
        btn6H.setOnClickListener(this);
        btn7H.setOnClickListener(this);
        btn8H.setOnClickListener(this);
        btn9H.setOnClickListener(this);
        btnEqH.setOnClickListener(this);
        btnTchH.setOnClickListener(this);
        btnMinusH.setOnClickListener(this);
        btnPlH.setOnClickListener(this);
        btnDELH.setOnClickListener(this);
        btnCH.setOnClickListener(this);

        load();

        registerForContextMenu(textView2);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        save();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        switch (v.getId()){
            case R.id.tvH:
                for(int i = 1; i <= resultList.size(); i++)
                {
                    menu.add(0, i, 0, resultList.get(i-1));
                }
                break;
        }
    }
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case 1:
                str = resultList.get(0);
                textView2.setText(str);
                break;
            case 2:
                str = resultList.get(1);
                textView2.setText(str);
                break;
            case 3:
                str = resultList.get(2);
                textView2.setText(str);
                break;
            case 4:
                str = resultList.get(3);
                textView2.setText(str);
                break;
            case 5:
                str = resultList.get(4);
                textView2.setText(str);
                break;
            case 6:
                str = resultList.get(5);
                textView2.setText(str);
                break;
            case 7:
                str = resultList.get(6);
                textView2.setText(str);
                break;
            case 8:
                str = resultList.get(7);
                textView2.setText(str);
                break;
            case 9:
                str = resultList.get(8);
                textView2.setText(str);
                break;
            case 10:
                str = resultList.get(9);
                textView2.setText(str);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0H:
                str += "0";
                textView2.setText(str);
                break;
            case R.id.btn1H:
                str += "1";
                textView2.setText(str);
                break;
            case R.id.btn2H:
                str += "2";
                textView2.setText(str);
                break;
            case R.id.btn3H:
                str += "3";
                textView2.setText(str);
                break;
            case R.id.btn4H:
                str += "4";
                textView2.setText(str);
                break;
            case R.id.btn5H:
                str += "5";
                textView2.setText(str);
                break;
            case R.id.btn6H:
                str += "6";
                textView2.setText(str);
                break;
            case R.id.btn7H:
                str += "7";
                textView2.setText(str);
                break;
            case R.id.btn8H:
                str += "8";
                textView2.setText(str);
                break;
            case R.id.btn9H:
                str += "9";
                textView2.setText(str);
                break;
            case R.id.btnPlH:
                str += "+";
                textView2.setText(str);
                break;
            case R.id.btnMinusH:
                str += "-";
                textView2.setText(str);
                break;
            case R.id.btnEqH:
                if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-"))
                {
                    textView2.setText(str);
                    break;
                }
                try {
                    String s = new HoursResult().getResult(str);
                    if(resultList.size() < 10) {
                        resultList.add(s);
                    }
                    else if(resultList.size() >= 10)
                    {
                        resultList.remove(0);
                        resultList.add(s);
                    }
                    textView2.setText(str + "\n" + "= " + s);
                    str = s;
                    break;
                }
                catch (Exception e)
                {
                    Toast.makeText(this, "Неверный ввод!", Toast.LENGTH_LONG).show();
                    break;
                }

            case R.id.btnCH:
                str = "";
                textView2.setText(str);
                break;
            case R.id.btnDELH:
                try {
                    str = str.substring(0, str.length() - 1);
                    textView2.setText(str);
                }catch (Exception e)
                {
                    str = "";
                    textView2.setText(str);
                }
                break;
            case R.id.btnTchH:
                if(str.endsWith(":"))
                {
                    textView2.setText(str);
                    break;
                } else if (str.endsWith("+") || str.endsWith("-"))
                {
                    str = str + "0:";
                    textView2.setText(str);
                    break;
                }
                else {
                    str += ":";
                    textView2.setText(str);
                    break;
                }
        }
    }

    void save()
    {
        sPr = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPr.edit();
        editor.putInt(LIST_SIZE, resultList.size());
        editor.commit();

        for(int i = 0; i < resultList.size(); i++)
        {
            editor.putString(String.valueOf(i), resultList.get(i));
            editor.commit();
        }
    }
    void load()
    {
        sPr = getPreferences(MODE_PRIVATE);
        int si = sPr.getInt(LIST_SIZE, 0);

        for(int i = 0; i < si; i++)
        {
            String s = sPr.getString(String.valueOf(i), "");
            resultList.add(i, s);
        }
        //SharedPreferences.Editor ed = sPr.edit();
        sPr.edit().clear();
    }
}
