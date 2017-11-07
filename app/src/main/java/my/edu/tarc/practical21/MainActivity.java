package my.edu.tarc.practical21;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_PFOFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "my.edu.tarc.practical21.name";
    public static final String PROFILE_EMAIL = "my.edu.tarc.practical21.email";
    private TextView textViewName, textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);
    }

    public void updateProfile(View view)
    {
        //Explicit intent
        Intent intent= new Intent(this,ProfileActivity.class);
        startActivityForResult(intent,REQUEST_PFOFILE_UPDATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //RequestCode = a unique code to identify an intent
        //ResultCode = result of an intent call; either OK or Cancel
        //date = the actual data returned by and intent
        if(requestCode == REQUEST_PFOFILE_UPDATE) //&& resultCode == RESULT_OK)
        {
            String name,email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.name) + name);
            textViewEmail.setText(getString(R.string.email) + email);

        }
    }

    public void showMain(View v)
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View v)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"0123536128"));
        startActivity(intent);
    }

    public void showSendTo(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+"lkw_xoras@hotmail.com"));
        startActivity(intent);

    }

    public void visitTARUC(View v)
    {
        String uri="http://www.tarc.edu.my";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }
}
