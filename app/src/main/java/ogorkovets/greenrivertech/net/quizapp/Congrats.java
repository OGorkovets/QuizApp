package ogorkovets.greenrivertech.net.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by galex on 4/24/2016.
 */
public class Congrats  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congrats);

        setButton();
    }

    public void setButton(){
        TextView finish = (TextView) findViewById(R.id.finish);
        finish.setText(" Congratulations you have finished the quiz");

        Button restart = (Button) findViewById(R.id.restartButton);
        restart.setText("Restart");
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                restartQuiz(view);
            }
        });
    }

    public void restartQuiz(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
