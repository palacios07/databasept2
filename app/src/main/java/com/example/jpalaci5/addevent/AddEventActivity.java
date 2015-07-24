package com.example.jpalaci5.addevent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddEventActivity extends ActionBarActivity implements View.OnClickListener {

    protected Button mSignUpButton, mLoginButton;
    protected EditText mEmail, mPassword;

    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        mEmail = (EditText)findViewById(R.id.email);
        mPassword = (EditText)findViewById(R.id.password);
        mSignUpButton = (Button)findViewById(R.id.bSignUp);
        mLoginButton = (Button)findViewById(R.id.bLogin);

        mLoginButton.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                    //Intent intent = new Intent(AddEventActivity.this, EnterEventActivity.class);
                   // startActivity(intent);

                User user = new User(null, null);
                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);


                break;

            case R.id.bSignUp:
                   startActivity(new Intent(this, SignUpActivity.class));

                //    Intent intent = new Intent(AddEventActivity.this, SignUpActivity.class);
                //  startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
