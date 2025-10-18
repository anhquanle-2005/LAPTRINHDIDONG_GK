package com.example.baigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class LunarConverterActivity extends AppCompatActivity {

    private TextInputEditText edtNamDuongLich;
    private TextInputEditText edtNamAmLich;
    private Button btnConvertCalendar;
    private TextView tvLastLunarResult;


    private final String [] arrCan = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh"};
    private final String [] arrChi = {"Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        edtNamAmLich = findViewById(R.id.edt_nam_am_lich);
        edtNamDuongLich = findViewById(R.id.edt_nam_duong_lich);
        btnConvertCalendar = findViewById(R.id.btn_convert_calendar);

        tvLastLunarResult = findViewById(R.id.tv_Last_lunar_result);

        Intent intent = getIntent();
        String lastTempResult = intent.getStringExtra("lastTempResult");

        if (lastTempResult != null && !lastTempResult.isEmpty()) {
            tvLastLunarResult.setText("Nhiet do doi gan nhat: " + lastTempResult);
            tvLastLunarResult.setVisibility(View.VISIBLE);
        } else {
            tvLastLunarResult.setVisibility(View.GONE);

        }
        btnConvertCalendar.setOnClickListener(v -> doiLich());
    }

        private void doiLich() {
            String namDuongStr = edtNamDuongLich.getText().toString();
            if(TextUtils.isEmpty(namDuongStr)){
                Toast.makeText(this, "Vui lòng nhập năm dương lịch", Toast.LENGTH_SHORT);
                return;
        }
    }
}


