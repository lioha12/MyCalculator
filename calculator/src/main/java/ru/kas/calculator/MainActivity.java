package ru.kas.calculator;

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btn00;
    Button btnTChK;
    Button btnPlus;
    Button btnMinus;
    Button btnDivision;
    Button btnMultiply;
    Button btnEqually;
    Button btnClear;
    Button btnDel;

    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatorscreen);

        textView = (TextView)findViewById(R.id.textView);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);
        btn00 = (Button)findViewById(R.id.btn00);
        btnClear = (Button)findViewById(R.id.btnclear);
        btnDel = (Button)findViewById(R.id.btnDel);
        btnDivision = (Button)findViewById(R.id.btnDivision);
        btnEqually = (Button)findViewById(R.id.btnEqually);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMultiply = (Button)findViewById(R.id.btnMultiply);
        btnPlus = (Button)findViewById(R.id.btnPlus);
        btnTChK = (Button)findViewById(R.id.btnTChK);


        btn0.setOnClickListener(this);
        btn00.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqually.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnTChK.setOnClickListener(this);

        //textView.setText("");

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 1, 0, "Калькулятор часов");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == 1)
        {
            Intent intent = new Intent(this, HourseMain.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                str = str + "0";
                textView.setText(str);
                break;
            case R.id.btn00:
                str += "00";
                textView.setText(str);
                break;
            case R.id.btn1:
                str += "1";
                textView.setText(str);
                break;
            case R.id.btn2:
                str += "2";
                textView.setText(str);
                break;
            case R.id.btn3:
                str += "3";
                textView.setText(str);
                break;
            case R.id.btn4:
                str += "4";
                textView.setText(str);
                break;
            case R.id.btn5:
                str+= "5";
                textView.setText(str);
                break;
            case R.id.btn6:
                str += "6";
                textView.setText(str);
                break;
            case R.id.btn7:
                str += "7";
                textView.setText(str);
                break;
            case R.id.btn8:
                str += "8";
                textView.setText(str);
                break;
            case R.id.btn9:
                str += "9";
                textView.setText(str);
                break;
            case R.id.btnTChK:
                if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    textView.setText(str);
                }
                else {
                    str += ".";
                    textView.setText(str);
                }
                break;
            case R.id.btnclear:
                str = "";
                textView.setText(str);
                break;
            case R.id.btnEqually:
                if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    textView.setText(str);
                    break;
                }
                String s = new Result(str).getResult();
                if(s.equals("Wrong input"))
                {
                    Toast.makeText(this, "Неверный ввод", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    textView.setText(str + "\n" + "= " + s);
                    str = s;
                    break;
                }
            case R.id.btnDivision:
                if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    textView.setText(str);
                    break;
                }
                str += "/";
                textView.setText(str);
                break;
            case R.id.btnMinus:
                /*if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    textView.setText(str);
                    break;
                }*/
                str += "-";
                textView.setText(str);
                break;
            case R.id.btnMultiply:
                if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    textView.setText(str);
                    break;
                }
                str += "*";
                textView.setText(str);
                break;
            case R.id.btnPlus:
                if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    textView.setText(str);
                    break;
                }
                str += "+";
                textView.setText(str);
                break;
            case R.id.btnDel:
                try {
                    str = str.substring(0, str.length() - 1);
                    textView.setText(str);
                }catch(Exception e) {
                    textView.setText("");
                }
                break;
        }
    }
}

