package com.example.parsestarterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Boolean signUpModeActive = true;
    TextView loginTextView;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loginTextView) {

            Button signUpButton = findViewById(R.id.signUpButton);

            if (signUpModeActive) {
                signUpModeActive = false;
                signUpButton.setText("Login");
                loginTextView.setText("or, Sign Up");
            } else {
                signUpModeActive = true;
                signUpButton.setText("Sign Up");
                loginTextView.setText("or, Login");
            }

        }
    }

    public void signUpClicked(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {
            Toast.makeText(this, "A username and a password are required.",Toast.LENGTH_SHORT).show();

        } else {
            if (signUpModeActive) {
                ParseUser user = new ParseUser();
                user.setUsername(usernameEditText.getText().toString());
                user.setPassword(passwordEditText.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.i("Signup", "Success");
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                // Login
                ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Log.i("Login","ok!");
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(this);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
    ParseObject score = new ParseObject("Score");
    score.put("username", "sean");
    score.put("score", 65);
    score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          // OK
          Log.i("Success", "We saved the score");
        } else {
          e.printStackTrace();
        }
      }
    });


    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    query.getInBackground("goUksCODyS", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {

          object.put("score",85);
          object.saveInBackground();

          Log.i("username",object.getString("username"));
          Log.i("score",Integer.toString(object.getInt("score")));
        }
      }
    });

    */

        // Create a tweet class, username tweet, save it to parse, query it, update the tweet

        /*ParseObject tweet = new ParseObject("Tweet");

        tweet.put("username","nickchuckwalter");
        tweet.put("tweet","I like cheese!");

        tweet.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("OK!","Save success");
                } else {
                    e.printStackTrace();
                }
            }
        });

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

        query.getInBackground("xETFOXuFZE", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object != null) {

                    object.put("tweet","Cheese is ok...");
                    object.saveInBackground();

                    Log.i("username",object.getString("username"));
                    Log.i("tweet",object.getString("tweet"));
                }
            }
        });

        ParseAnalytics.trackAppOpenedInBackground(getIntent());*/

        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

        query.whereGreaterThan("score", 50);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null && objects != null) {
                    for (ParseObject score : objects) {
                        score.put("score", score.getInt("score") + 20);
                        score.saveInBackground();
                    }
                }
            }
        });*/

        /*
    ParseUser user = new ParseUser();

    user.setUsername("nick");
    user.setPassword("myPass");

    user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
            if (e == null) {
                // OK
                Log.i("Sign Up OK!", "We did it");

            } else {
                e.printStackTrace();
            }
        }
    });


    ParseUser.logInInBackground("nick", "myPas", new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
            if (user != null) {
                Log.i("Success", "We logged in");
            } else {
                e.printStackTrace();
            }
        }
    });

    */

        /*ParseUser.logOut();

        if (ParseUser.getCurrentUser() != null) {
            Log.i("Signed In", ParseUser.getCurrentUser().getUsername());
        } else {
            Log.i("not luck", "Not signed in");
        }

        ParseAnalytics.trackAppOpenedInBackground(getIntent());*/
    //}
}
