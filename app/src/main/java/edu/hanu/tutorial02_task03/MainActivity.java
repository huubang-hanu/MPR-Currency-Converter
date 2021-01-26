package edu.hanu.tutorial02_task03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner moneySpinner;
    private Button btnConvert;
    private TextView txtMoney;
    private double rs;
    private TextView txtResult;
    //Exchange rate
    private final double USD_VND = 23036.57;
    private final double EUR_VND = 27983.65;
    //Format number
    private final NumberFormat formatter = new DecimalFormat("0.00");
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneySpinner = findViewById(R.id.spinnerMoney);
        btnConvert = findViewById(R.id.btnConvert);
        txtMoney = findViewById(R.id.editTxtMoney);
        txtResult = findViewById(R.id.txtResult);

        //Set event listener for Convert Button
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Get position of type convert in spinner
        int index = moneySpinner.getSelectedItemPosition();

        double inputMoney = 0;
        //Catch error if user input wrong value
        try {
            inputMoney = Double.parseDouble(txtMoney.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Wrong format input!", Toast.LENGTH_SHORT).show();
        }

        switch (index) {
            case 0: //VND to USD
                rs = inputMoney / USD_VND; //Convert money
                str = formatter.format(rs); //Format with 0.00
                txtResult.setText("Result: " + str + " USD");
                break;

            case 1: //USD to VND
                rs = inputMoney * USD_VND;
                str = formatter.format(rs);
                txtResult.setText("Result: " + str + " VND");
                break;

            case 2:  //VND to EUR
                rs = inputMoney / EUR_VND;
                str = formatter.format(rs);
                txtResult.setText("Result: " + str + " EUR");
                break;

            case 3: //EUR to VND
                rs = rs = inputMoney * EUR_VND;
                str = formatter.format(rs);
                txtResult.setText("Result: " + str + " VND");
                break;
            default:
                break;
        }
    }

}