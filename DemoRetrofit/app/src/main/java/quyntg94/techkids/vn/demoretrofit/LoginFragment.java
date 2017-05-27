package quyntg94.techkids.vn.demoretrofit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private CheckBox cbRemember;

    private int count = 0;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        if (SharedPreferences.getInstance().getRemember() != null) {
            if (SharedPreferences.getInstance().getRemember().equals("true"))
                changeFragment(new SayHelloFragment(), false, null);
        }

        etUsername = (EditText) view.findViewById(R.id.et_username);
        etPassword = (EditText) view.findViewById(R.id.et_password);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        cbRemember = (CheckBox) view.findViewById(R.id.cb_remember);


        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    SharedPreferences.getInstance().putRemember("true");
                } else {
                    SharedPreferences.getInstance().putRemember("false");
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnLogin.getText().equals("Login")) {
                    SharedPreferences.getInstance().putUsername(etUsername.getText().toString());
                    SharedPreferences.getInstance().putPassword(etPassword.getText().toString());
                    changeFragment(new SayHelloFragment(), true, null);
                } else {
                    if (validate()) {
                        register();

                    }
                }
            }
        });
        return view;
    }
    private boolean validate() {
        if (etUsername.getText().toString().trim().equals("") || etPassword.getText().toString().trim().equals("")) {
            Toast.makeText(getContext(), "Please fill Username/Password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            for (int i = 0; i < etUsername.getText().length(); i++) {
                if (Character.isWhitespace(etUsername.getText().charAt(i))) {
                    count++;
                }
            }
            for (int i = 0; i < etUsername.getText().length(); i++) {
                if (Character.isWhitespace(etUsername.getText().charAt(i))) {
                    count++;
                    Log.d("count", String.valueOf(count));
                }
            }
            if (count == 0) {
                return true;
            } else {
                Toast.makeText(getContext(), "Username/Password must have no white space", Toast.LENGTH_SHORT).show();
                count = 0;
                return false;
            }
        }
    }

    private void register() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://a-server.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterService registerService = retrofit.create(RegisterService.class);
        registerService.register(new RegisterRequest(etUsername.getText().toString(), etPassword.getText().toString())).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.code() == 200) {
                    RegisterResponse registerResponse = response.body();
                    if (registerResponse.getCode() == 1) {
                        Toast.makeText(getContext(), "Registered", Toast.LENGTH_SHORT).show();
                        btnLogin.setText("Login");
                    } else {
                        Toast.makeText(getContext(), "User already exists", Toast.LENGTH_SHORT).show();
                        btnLogin.setText("Register");

                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(getContext(), "No connection", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void changeFragment(Fragment fragment, boolean addToBackstack, String tag) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }
}
