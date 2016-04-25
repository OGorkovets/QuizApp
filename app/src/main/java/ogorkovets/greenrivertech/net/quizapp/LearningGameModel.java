package ogorkovets.greenrivertech.net.quizapp;

import java.util.ArrayList;

import java.util.ArrayList;
/**
 * @author  Oleksandr Gorkovets
 * @version 1.0
 * @date 4/11/2016
 */
public class LearningGameModel {
    private boolean finish;
    private boolean leftButt;
    private boolean rightButt;
    private int questionNum;
    private int answerNum;
    private int gamesPlayed;
    private int gamesWon;

    /**
     * This is default constructor
     */
    public LearningGameModel(){
        gamesPlayed = 0;
        gamesWon = 0;
        questionNum = 0;
        finish = false;
        leftButt = true;
        rightButt =false;
    }


    public boolean getLeft(){
        return leftButt;
    }

    public boolean getRight(){
        return rightButt;
    }

    public int getGamesPlayed(){
        return gamesPlayed;
    }

    public int getGamesWon(){
        return gamesWon;
    }

    public String getQuestion(){
        String q1 = "Are there 7 days in a week?";
        String q2 = "Sun is spinning around the Earth?";
        String q3 = "Square has oval shape?";
        String q4 = "Orange is blue";
        String q5 = "Cats like dogs";
        ArrayList questions = new ArrayList();
        questions.add(0, q1);
        questions.add(1,q2);
        questions.add(2,q3);
        questions.add(3, q4);
        questions.add(4,q5);
        String answer = questions.get(questionNum).toString();
        if(questionNum < 4) {
            questionNum++;
        }
        else {
            finish = true;
        }
        return answer;
    }

    public boolean getAnswer(){
        boolean a1 = true;
        boolean a2 = false;
        boolean a3 = false;
        boolean a4 = false;
        boolean a5 = false;
        boolean[] answers = new boolean[5];
        answers[0] = a1;
        answers[1] = a2;
        answers[2] = a3;
        answers[3] = a4;
        answers[4] = a5;
        boolean answer = answers[answerNum];
        if(answerNum < 4) {
            answerNum++;
        }
        else {
            finish = true;
        }
        return answer;
    }

    public void setPlayed(){
        gamesPlayed++;
    }

    public void setWon(){
        gamesWon++;
    }

    public boolean getFinish(){
        return finish;
    }
}
