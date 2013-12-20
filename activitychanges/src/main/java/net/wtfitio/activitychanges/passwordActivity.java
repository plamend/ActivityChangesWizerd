package net.wtfitio.activitychanges;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
public class passwordActivity extends Activity {
    EditText password1;
    EditText password2;
    Bundle all;
    Context cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_activity);
        this.password1 = (EditText)findViewById(R.id.first_pass);
        this.password2 = (EditText)findViewById(R.id.conf_pass);
        Button pass_next = (Button)findViewById(R.id.pass_next);
        this.cont=this;
        this.all=getIntent().getExtras();
        pass_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pass1 = password1.getText().toString();
                if(Pass1!=""&&Pass1.length()>0){
                    if (ValidatePassword(Pass1)){
                        String Pass2 =password2.getText().toString();
                        if(Pass2!=""&&Pass2.length()>0){
                           if( CheckPassword(Pass1,Pass2)){
                               movetoall(Pass1);
                           }
                           else{
                               Toast.makeText(cont, "Passwords did not match", Toast.LENGTH_SHORT).show();
                           }
                        }
                        else{
                            Toast.makeText(cont, "empty conferm password", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(cont, "Not valide password", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(cont, "Empty password", Toast.LENGTH_SHORT).show();
                }
            }


        });



    }
    private void movetoall(String pass1) {
        Intent intent = new Intent(this,AllInOneActivity.class);
       // String test =all.get(AllInOneActivity.fistName).toString();
        intent.putExtra(AllInOneActivity.fistName,all.get(AllInOneActivity.fistName).toString());
        intent.putExtra(AllInOneActivity.lastName,all.get(AllInOneActivity.lastName).toString());
        intent.putExtra(AllInOneActivity.hisEmail,all.get(AllInOneActivity.hisEmail).toString());
        intent.putExtra(AllInOneActivity.hisPassword,pass1);
        startActivity(intent);
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
