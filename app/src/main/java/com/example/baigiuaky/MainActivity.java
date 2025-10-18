package com.example.baigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private static final  int LUNAR = 1001;
    private TextInputEditText edtCelsius;
    private TextInputEditText edtFahrenheit;

    private Button btnConvertTemp;
    private Button btnGoToLunar;

    private TextView tvLastLunarResult;

    private boolean isCInputMode = true;
    private String lastTempResult = "";


    private void convertCtoF()
    {
        String str = edtCelsius.getText().toString();
        if(TextUtils.isEmpty(str)){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double c = Double.parseDouble(str);
            double f = c*1.8 + 32;
            String result = String.format("%.2f", f);
            edtFahrenheit.setText(result);
            lastTempResult = result;
            setMode(false);
        }catch (NumberFormatException e)
        {
            Toast.makeText(this, "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtCelsius = findViewById(R.id.edt_celsius);
        edtFahrenheit = findViewById(R.id.edt_fahrenheit);

        btnConvertTemp = findViewById(R.id.btn_convert_temp);

        btnGoToLunar = findViewById(R.id.btn_go_to_lunar);

        tvLastLunarResult = findViewById(R.id.tv_Last_lunar_result);

        setMode(true);

        btnConvertTemp.setOnClickListener(v->{
            if(isCInputMode){
                convertCtoF();
            }
        });

        btnGoToLunar.setOnClickListener(v->{
            Intent intent = new Intent(this, LunarConverterActivity.class);
            intent.putExtra("lastTempResult", lastTempResult);
            startActivityForResult(intent, LUNAR);
        });
    }

    private void setMode(boolean b) {
        isCInputMode = b;
        if (isCInputMode) {
            edtCelsius.setEnabled(true);
            edtFahrenheit.setEnabled(false);
            btnConvertTemp.setText("Chuyển đổi sang độ F");
        } else {
            edtCelsius.setEnabled(false);
            edtFahrenheit.setEnabled(true);
            btnConvertTemp.setText("Chuyển đổi sang độ C");
        }
    }
}