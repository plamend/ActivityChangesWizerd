package net.wtfitio.activitychanges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by plamend on 12/15/13.
 */
public class MainActivity extends Activity {

    EditText first_input;
    EditText last_input;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Button send = (Button)findViewById(R.id.flname_next);
        this.first_input = (EditText)findViewById(R.id.first_name);
        this.last_input = (EditText)findViewById(R.id.second_name);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendtoemail();
            }


        });



    }



    private void sendtoemail() {

        String first_name_input = first_input.getText().toString();
        String last_name_input = last_input.getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("FirstName",first_name_input);
        intent.putExtra("LastName",last_name_input);
        startActivity(intent);

    }
}
