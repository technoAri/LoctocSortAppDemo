package com.loctoc.sortappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button sort;
    String sortedStr = "";
    int len;
    String[] strArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.edittext_input);
        sort = (Button) findViewById(R.id.button_sort);

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputString = input.getText().toString();
                if (!inputString.isEmpty()) {
                    String formattedString = inputString.trim().replaceAll(",+", ",");
                    strArr = formattedString.split(",");
                    len = strArr.length;

                    int[] intArr = new int[len];
                    for (int i = 0; i < len; i++) {
                        intArr[i] = Integer.parseInt(strArr[i]);
                    }

                    int[] sorted = bubbleSort(intArr);
                    for (int i = 0; i < sorted.length; i++)
                        if (sortedStr.isEmpty()) {
                            sortedStr += sorted[i];
                        } else {
                            sortedStr += "," + sorted[i];
                        }

                    System.out.println(sortedStr);
                    Toast.makeText(getApplicationContext(), sortedStr, Toast.LENGTH_LONG).show();
                    sortedStr = "";

                } else
                    Toast.makeText(getApplicationContext(), "Please insert numbers in the input section", Toast.LENGTH_SHORT).show();
            }
        });

    }

    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
