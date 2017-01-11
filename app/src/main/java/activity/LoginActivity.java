package activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yourapp.developer.karrierbay.R;

import Model.LoginRequest;
import Model.LoginResponse;
import Utilities.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {


    private TextView SignUp, haveAccount, forgotPassword;
    private Button signIn;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignUp = (TextView)findViewById(R.id.sign_up);
        haveAccount = (TextView)findViewById(R.id.account);
        forgotPassword = (TextView)findViewById(R.id.forgot_password);
        signIn = (Button)findViewById(R.id.email_sign_in_button);
        email = (EditText)findViewById(R.id.phone_number);
        password = (EditText)findViewById(R.id.password);

        signIn.setTypeface(mTfBold);
        haveAccount.setTypeface(mTfRegular);
        SignUp.setTypeface(mTfSemiBold);
        forgotPassword.setTypeface(mTfRegular);
        email.setTypeface(mTfSemiBold);
        password.setTypeface(mTfRegular);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<LoginResponse> call = apiService.getLogin(new LoginRequest(email.getText().toString(),password.getText().toString()));
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        if(response.code()==200) {
                            Log.d("LoginResponse", response.body().getData().getEmail().toString());
                            // Log.d("Error",response.body().getErrors().toString());
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"Password Incorrect",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
        // Set up the login form.

    }


}

