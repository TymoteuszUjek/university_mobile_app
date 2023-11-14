package com.example.apka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button startButton;
    Button redButton;
    Button greenButton;
    Button yellowButton;
    Button blueButton;
    int[] zapamietane = new int [5];
    int pomocnicza = 0;
    int zgadnij = 2;
    int licznik = 0 ;
    public Random losowa;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inny_layout);

        startButton = (Button) findViewById(R.id.buttonStart);
        redButton = (Button) findViewById(R.id.buttonRed);
        greenButton = (Button) findViewById(R.id.buttonGreen);
        yellowButton = (Button) findViewById(R.id.buttonYellow);
        blueButton = (Button) findViewById(R.id.buttonBlue);

        Random losowa = new Random();
        int zmienna = losowa.nextInt(4);

        redButton.setEnabled(false);
        greenButton.setEnabled(false);
        yellowButton.setEnabled(false);
        blueButton.setEnabled(false);

    }

    public void StartGame(View v)
    {
        Toast.makeText(this, "Start za", Toast.LENGTH_SHORT).show();
        redButton.setEnabled(true);
        greenButton.setEnabled(true);
        yellowButton.setEnabled(true);
        blueButton.setEnabled(true);

        Random losowa = new Random();
        int zmienna = losowa.nextInt(4)+1;
        for (int i = 3; i >=1 ; i--)

        {
            Toast.makeText(this, String.valueOf(i), Toast.LENGTH_SHORT).show();
        }

        for (int i=0 ; i < zgadnij ; i++)
        {
            pomocnicza = losowa.nextInt(4)+1;
            Toast toast = Toast.makeText(this, "Number: "
                    + String.valueOf(i+1) + setTextVal(pomocnicza), Toast.LENGTH_SHORT);
            View view = toast.getView();
            view.setBackgroundResource(android.R.drawable.toast_frame);
            TextView toastMessage = (TextView) view.findViewById(android.R.id.message);
        }
    }
    public String SetColor(int nr)
    {
        String col = "#00ff00"; // 1 - RED; 2 - GREEN, 3 - BLUE, 4 - YELLOW
        switch (nr)
        {
            case 1:
            {
                col = "#ff0000";
                break;
            }
            case 2:
            {
                col = "#00ff00";
                break;
            }
            case 3:
            {
                col = "#0000ff";
                break;
            }
            case 4:
            {
                col = "#ffff00";
                break;
            }
        }
        return col;
    }

    public String setTextVal(int nr)
    {
        String text = "";
        switch(nr)
        {
            case 1:
            {
                text = "    Czerwony";
                break;
            }
            case 2:
            {
                text = "    Zielony";
                break;
            }
            case 3:
            {
                text = "    Niebieski";
                break;
            }
            case 4:
            {
                text = "    Źółty";
                break;
            }
        }
        return text;
    }

    public void checkButton (View v) // 1 - RED, 2 - GREEN, 3 - BLUE, 4 - YELLOW
    {
        if ( (redButton.getId() == v.getId()) && (zapamietane[licznik] == 1) )
        {
            Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show();
            licznik++;
            System.out.println("Czerowny");
        }
        else if ( ( yellowButton.getId() == v.getId()) && (zapamietane[licznik] == 2 ))
        {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            licznik++;
            System.out.println("Zloty");
        }
        else if ( ( blueButton.getId() == v.getId()) && (zapamietane[licznik] == 3))
        {
            Toast.makeText(this,"ok", Toast.LENGTH_SHORT).show();
            licznik++;
            System.out.println("Niebieski");
        }
        else if ( ( greenButton.getId() == v.getId()) && (zapamietane[licznik] == 4 ))
        {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            licznik++;
            System.out.print("Zielony");
        }
        else
        {
            Toast.makeText(this, "Źle. Zacznij jezcze raz", Toast.LENGTH_SHORT).show();
            redButton.setEnabled(false);
            greenButton.setEnabled(false);
            yellowButton.setEnabled(false);
            blueButton.setEnabled(false);
            zgadnij = 2;
        }

        if (( licznik == 100) || (zapamietane[licznik] == 0))
        {
            Toast.makeText(this, "Brawo, odgadłeś wszystko", Toast.LENGTH_SHORT).show();
            redButton.setEnabled(false);
            greenButton.setEnabled(false);
            yellowButton.setEnabled(false);
            blueButton.setEnabled(false);
            startButton.setEnabled(true);
            zgadnij++;
        }
    }
}