package org.techtown.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MAIN=100;
    public static final int REQUEST_CODE_MENU = 101;

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText =findViewById(R.id.editText);
                editText2 = findViewById(R.id.editText2);

                String value = editText.getText().toString();

                if(value.equals("노장군")) {
                    Toast.makeText(getApplicationContext(), "노장군님 환영합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
                else if(value.equals("")){
                    Toast.makeText(getApplicationContext(),"다시 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), value + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivityForResult(intent,REQUEST_CODE_MAIN);
    }
}