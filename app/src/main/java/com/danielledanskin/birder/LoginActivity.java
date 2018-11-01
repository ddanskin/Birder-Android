package com.danielledanskin.birder;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = LoginActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_button = (Button) findViewById(R.id.login_submit_button);

        final EditText email_address_input = (EditText) findViewById(R.id.email_address_text_input);
        final EditText password_input = (EditText) findViewById(R.id.password_text_input);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "";
                int toastColor = R.color.toastInfo;

                String email_address = email_address_input.getText().toString();
                String password = password_input.getText().toString();
                if(!validEmail(email_address)){
                    message = "invalid email";
                    toastColor = R.color.toastWarning;
                } else if(!validPassword(password)){
                    message = "invalid password";
                    toastColor = R.color.toastWarning;
                } else {
                    message = "logging in..";
                    toastColor = R.color.toastWarning;
                }

                LayoutInflater inflater = getLayoutInflater();
                View toast_layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                TextView toastText = (TextView) toast_layout.findViewById(R.id.toast_text);
                toastText.setText(message);
                toastText.setTextColor(toastColor);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(toast_layout);
                toast.show();

            }
        });
    }

    private static boolean validEmail(String email){
        return LoginUtils.isValidEmailAddress(email) && LoginUtils.getLocalPartLength(email) > 1;
    }

    private static boolean validPassword(String password) {
        return LoginUtils.isValidPassword(password);
    }
}
