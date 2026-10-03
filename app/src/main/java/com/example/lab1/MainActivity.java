package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.app.Activity;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processPress(View view)
            throws java.io.IOException {

        TextView tv;
        EditText et1;
        EditText et2;
        String infilename;
        String outfilename;

        tv = (TextView) findViewById(R.id.text_main);

        tv.setText("Hello everyone.  We're in the method.\n");

        // get the values from the EditTexts and
        // display them

        et1 = (EditText) findViewById(R.id.edit_infile);
        et2 = (EditText) findViewById(R.id.edit_outfile);

        infilename = et1.getText().toString();
        outfilename = et2.getText().toString();

        Scanner input = new Scanner(
                getAssets().open(infilename)
        );

        ArrayList<Double> numbers = new ArrayList<>();

        while (input.hasNext()) {
            numbers.add(input.nextDouble());
        }

        input.close();

        String output = "";



            floor_it(numbers, numbers.size());
        File outputFile = new File(getExternalFilesDir(null), outfilename);
        PrintWriter endfile = new PrintWriter(outputFile);
            for (int i = 0; i < numbers.size(); i++) {
                tv.append(String.format("%.2f\n", numbers.get(i)));

                endfile.println(numbers);


        } // end processPress

        endfile.close();
    }
    public void floor_it(ArrayList<Double> a, int nums) {
        for (int i = 0; i < nums; i++) {
            a.set(i, Math.floor(a.get(i)));
        }
    }
}