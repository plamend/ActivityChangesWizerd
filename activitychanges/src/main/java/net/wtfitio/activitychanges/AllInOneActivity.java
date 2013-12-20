package net.wtfitio.activitychanges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by plamend on 12/15/13.
 */
public class AllInOneActivity extends Activity {
    public static String fistName="FIRST_NAME";
    public static String lastName="LAST_NAME";
    public static String hisEmail="HIS_EMAIL";
    public static String hisPassword = "HIS_PASSWORD";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_in_one_activity);
        TextView fist_out=(TextView)findViewById(R.id.first_name_out);
        TextView last_out=(TextView)findViewById(R.id.last_name_out);
        TextView email_out=(TextView)findViewById(R.id.email_out);

        output_toview(fist_out,last_out,email_out);


    }

    private void output_toview(TextView fist_out, TextView last_out, TextView email_out) {
        fist_out.setText(getIntent().getStringExtra(fistName));
        last_out.setText(getIntent().getStringExtra(lastName));
        email_out.setText(getIntent().getStringExtra(hisEmail));

    }


}
