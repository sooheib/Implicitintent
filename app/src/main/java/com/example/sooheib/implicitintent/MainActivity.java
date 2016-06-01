package com.example.sooheib.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToSecond(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void WhereIsWhiteHouse(View view) {
        //36.4687738,-86.704283
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:36.4687738,-86.704283"));
        Intent chooser=Intent.createChooser(intent,"lunch map");
        startActivity(chooser);
    }

    public void LunchMyAppFromAppstore(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.google.android.finsky&hl=en"));
        Intent chooser=Intent.createChooser(intent,"openapp");
        startActivity(chooser);
    }

    public void SendEmail(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[]={"soosel93@gmail.com","souheib.selmi@esprit.tn"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"HELLO FROM APP");
        intent.putExtra(Intent.EXTRA_TEXT,"this is text");
        intent.setType("message/rfc882");

        Intent chooser=Intent.createChooser(intent,"Email");
        startActivity(chooser);
    }

    public void ShareText(View view) {
        EditText editText = (EditText) findViewById(R.id.edittext);
        String str=editText.getText().toString();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,str);
        Intent chooser=Intent.createChooser(intent,"Share text");
        startActivity(chooser);
    }
}
