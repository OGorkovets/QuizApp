package ogorkovets.greenrivertech.net.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * @author  Oleksandr Gorkovets
 * @version 2.0
 * @date 4/11/2016
 */

public class MainActivity extends AppCompatActivity {
    private LearningGameModel game = new LearningGameModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set buttons to display true and false
        setButton();
    }

    public void setButton(){
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(game.getQuestion());

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(game.getLeft() + " ");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(game.getRight() + "");

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                checkOnclick(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                checkOnclick(view);
            }
        });
    }


    public void checkOnclick(View view){
        int clicked = view.getId();
        boolean result;
        String answer = "";
        if (clicked == R.id.button1) {
            result = game.getLeft();
        } else {
            result = game.getRight();
        }
        boolean checked = game.getAnswer();
        if (result == checked) {
            answer = "Good job!";
            game.setWon();
            game.setPlayed();
        } else {
            answer = "Try more!";
            game.setPlayed();
        }
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
        dispayMessages();
        boolean finished = game.getFinish();
        if(finished != true){
            setButton();
        }
        else{
            Intent i = new Intent(MainActivity.this, Congrats.class);
            startActivity(i);
        }
    }

    public void dispayMessages(){
        TextView displayTotal = (TextView) findViewById(R.id.displayTotal);
        displayTotal.setText("Total number of questions answered : " + game.getGamesPlayed());

        TextView displayCorrect = (TextView) findViewById(R.id.displayCorrect);
        displayCorrect.setText("Correct number of answers : " + game.getGamesWon());
    }


}
