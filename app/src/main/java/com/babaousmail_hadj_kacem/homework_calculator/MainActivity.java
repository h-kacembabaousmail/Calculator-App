package com.babaousmail_hadj_kacem.homework_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.text.UStringsKt;

public class MainActivity extends AppCompatActivity {
    EditText operations;
    TextView resultat;
    Button button_CE , button_Div , button_Mul , button_Sup , button_Sub , button_Add , button_Equal ;
    Button button_point , button_0 , button_1 , button_2 , button_3 , button_4 , button_5 , button_6 , button_7 , button_8 , button_9 ;
    double N1 , N2 , result ;
    String Rus="" , NRus;
    boolean isDivision , isMultiplication , isSubtraction , isAddition ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operations = findViewById(R.id.operations);
        resultat = findViewById(R.id.resultat);
        button_CE = findViewById(R.id.button_CE);
        button_Sup = findViewById(R.id.button_Sup);

        button_Div = findViewById(R.id.button_Div);
        button_Mul = findViewById(R.id.button_Mul);
        button_Sub = findViewById(R.id.button_Sub);
        button_Add = findViewById(R.id.button_Add );
        button_Equal = findViewById(R.id.button_Equal);


        button_point = findViewById(R.id.button_point);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);

        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operations.getText().length() > 0) {
                    Rus = Rus.concat((operations.getText().toString())+ " / ");
                    N1 = Double.parseDouble(operations.getText().toString());
                    isDivision = true;
                    operations.setText("");
                }
            }
        });

        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operations.getText().length() > 0) {
                    Rus = Rus.concat((operations.getText().toString())+ " x ");
                    N1 = Double.parseDouble(operations.getText().toString());
                    isMultiplication= true;
                    operations.setText("");
                }
            }
        });

        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operations.getText().length() > 0) {
                    Rus = Rus.concat((operations.getText().toString())+ " - ");
                    N1 = Double.parseDouble(operations.getText().toString());
                    isSubtraction= true;
                    operations.setText("");
                }
            }
        });

        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operations.getText().length() > 0) {
                    Rus = Rus.concat((operations.getText().toString())+ " + ");
                    N1 = Double.parseDouble(operations.getText().toString());
                    isAddition = true;
                    operations.setText("");
                }
            }
        });

        button_CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operations.setText("");
                resultat.setText("0");
                Rus="";
                isDivision = false;
                isMultiplication = false;
                isSubtraction = false;
                isAddition = false;
            }
        });

        button_Equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (operations.getText().length() > 0) {
                    N2 = Double.parseDouble(operations.getText().toString().replace(Rus, "").trim());
                    if (isAddition) {
                        result = N1 + N2;
                    } else if (isSubtraction) {
                        result = N1 - N2;
                    } else if (isMultiplication) {
                        result = N1 * N2;
                    } else if (isDivision) {
                        if (N2 != 0) {
                            result = N1 / N2;
                        } else {
                            resultat.setText("Erreur");
                            return;
                        }
                    }
                    String formattedN2;
                    if (N2 == (int) N2) {
                        formattedN2 = String.valueOf((int) N2);
                    } else {
                        formattedN2 = String.valueOf(N2);
                    }
                    Rus = Rus + formattedN2;
                    operations.setText(Rus);

                    if (result == (int) result) {
                        resultat.setText(String.valueOf((int) result));
                    } else {
                        resultat.setText(String.valueOf(result));
                    }
                    isDivision = false;
                    isMultiplication = false;
                    isSubtraction = false;
                    isAddition = false;
                }
            }
        });



        button_Sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = operations.getText().toString();
                if (!text.isEmpty()) {
                    operations.setText(text.substring(0, text.length() - 1));
                    operations.setSelection(operations.getText().length());
                }
            }
        });


        button_point.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (!operations.getText().toString().contains(".")) {
                    operations.setText(operations.getText().toString() + ".");
                }
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "0");
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                operations.setText(operations.getText().toString() + "9");
            }
        });
    }
}