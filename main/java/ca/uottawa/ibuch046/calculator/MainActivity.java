package ca.uottawa.ibuch046.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, minus, multiply, divide};
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numButtonClick (View view) {
        int pressID = view.getId();

        TextView curText = (TextView)findViewById(R.id.resultEdit);

        switch (pressID) {
            case R.id.btn00:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button00)));
                break;
            case R.id.btn01:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button01)));
                break;
            case R.id.btn02:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button02)));
                break;
            case R.id.btn03:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button03)));
                break;
            case R.id.btn04:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button04)));
                break;
            case R.id.btn05:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button05)));
                break;
            case R.id.btn06:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button06)));
                break;
            case R.id.btn07:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button07)));
                break;
            case R.id.btn08:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button08)));
                break;
            case R.id.btn09:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.button09)));
                break;
            case R.id.btnDot:
                curText.setText(String.format("%s%s", curText.getText(), getText(R.string.buttonDot)));
                break;
            default:
                curText.setText(getText(R.string.error));
                Log.d("Error","Error: Unknown button pressed");
                break;


        }
    }

    public void btnPlusClick (View view) {
        optr = Operator.add;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMinusClick (View view) {
        optr = Operator.minus;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMultClick (View view) {
        optr = Operator.multiply;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivClick (View view) {
        optr = Operator.divide;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearClick (View view) {
        optr = Operator.none;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText("");
    }

    public void btnEqClick (View view) {
        if (optr != Operator.none) {
            EditText eText = (EditText)findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr == Operator.add) {
                result = data1 + data2;
            }
            else if (optr == Operator.minus) {
                result = data1 - data2;
            }
            else if (optr == Operator.multiply) {
                result = data1 * data2;
            }
            else if (optr == Operator.divide) {
                result = data1 / data2;
            }
            optr = Operator.none;
            data1 = result;


            if((result - (int)result) != 0){
                eText.setText(String.valueOf(result).toString());
            }
            else {
                eText.setText(String.valueOf((int)result).toString());
            }
        }
    }

}
