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
public class SecondActivity extends Activity {
EditText email_first;
    EditText email_second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.secon_activity);
        this.email_first = (EditText)findViewById(R.id.email);
        this.email_second=(EditText)findViewById(R.id.email_next);
        Button email_but = (Button)findViewById(R.id.email_next);
        email_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email =  email_first.getText().toString();
                if(email!=""||email.length()>0){
                    if (validateemail(email)) {
                        String email2=email_second.getText().toString();
                        if (email2!=""||email2.length()>0) {
                            if(checkemail(email,email2)){

                            }
                        }
                    }

                }


            }
        });

}

    private boolean checkemail(String email, String email2) {
        if (email.equals(email)){
            return true;
        }
        return false;
    }

    private boolean validateemail(String email) {
        String email_PATTERN ="((?=.*[@]))";
        Pattern pattern = Pattern.compile(email_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
