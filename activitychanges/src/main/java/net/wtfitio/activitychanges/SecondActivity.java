package net.wtfitio.activitychanges;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by plamend on 12/15/13.
 */
public class SecondActivity extends Activity {
EditText email_first;
    EditText email_second;
    Bundle first_screen;
    String email;
    Context cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.secon_activity);
        this.email_first = (EditText)findViewById(R.id.email);
        this.email_second=(EditText)findViewById(R.id.conferm_email);
        this.cont=this;

        Button email_but = (Button)findViewById(R.id.email_next);

        this.first_screen=getIntent().getExtras();

        email_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email =  email_first.getText().toString();
                if(!email.equals("")||email.length()>0) {
                    boolean test = validateemail(email);
                    if (validateemail(email)) {
                    String email2 = email_second.getText().toString();
                    if (!email2.equals("") || email2.length() > 0) {
                        if (checkemail(email, email2)) {
                            movetopass();
                        }
                        else{
                            Toast.makeText(cont,"Email did not match",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(cont,"Empty conferm email",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(cont,"not valide email",Toast.LENGTH_SHORT).show();
                }
            }
                else{
                    Toast.makeText(cont,"Empty emaEmpty emailil",Toast.LENGTH_SHORT).show();
                }

            }
        });

}

    private void movetopass() {

        Intent intent = new Intent(this,passwordActivity.class);
        intent.putExtra(AllInOneActivity.fistName,first_screen.get(AllInOneActivity.fistName).toString());
        intent.putExtra(AllInOneActivity.lastName,first_screen.get(AllInOneActivity.lastName).toString());
        intent.putExtra(AllInOneActivity.hisEmail,email);
        startActivity(intent);
    }



    private boolean checkemail(String email, String email2) {
        if (email.equals(email)){
            return true;
        }
        return false;
    }


    @TargetApi(Build.VERSION_CODES.FROYO)
    private boolean validateemail(String email) {

        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
