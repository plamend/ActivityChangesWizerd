package net.wtfitio.activitychanges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by plamend on 12/15/13.
 */
public class passwordActivity extends Activity {
    EditText password1;
    EditText password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_activity);
        this.password1 = (EditText)findViewById(R.id.first_pass);
        this.password2 = (EditText)findViewById(R.id.conf_pass);
        Button pass_next = (Button)findViewById(R.id.pass_next);
        pass_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pass1 = password1.getText().toString();
                if(Pass1!=""&&Pass1.length()>0){
                    if (ValidatePassword(Pass1)){
                        String Pass2 =password2.getText().toString();
                        if(Pass2!=""&&Pass2.length()>0){
                            CheckPassword(Pass1,Pass2);
                        }
                    }
                }
            }
        });



    }

    private boolean CheckPassword(String pass1, String pass2) {
        if(pass1.equals(pass2)){
            return true;
        }
        return false;
    }


    private boolean ValidatePassword(String input) {

        String PASSWORD_PATTERN ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();


    }
}
