package com.hugoguillin.roomwordssample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.hugoguillin.roomwordssample.REPLY";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        editText = findViewById(R.id.edit_word);

        final Button boton = findViewById(R.id.button_save);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(TextUtils.isEmpty(editText.getText())){
                    setResult(RESULT_CANCELED, intent);
                }else{
                    String palabra = editText.getText().toString();
                    intent.putExtra(EXTRA_REPLY, palabra);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}
