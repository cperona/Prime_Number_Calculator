package com.example.posicio_nombre_primer;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private TreeMap<Integer, Integer> primeNumbers = new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onCalculateButton(View view) {
        Toast.makeText(this, getString(R.string.calculatingToast), Toast.LENGTH_SHORT).show();
        EditText primeNumberPositionTextField = findViewById(R.id.primeNumberPositionTextField);
        TextView primeNumberResultDescription = findViewById(R.id.primeNumberResultDescription);
        TextView primeNumberResult = findViewById(R.id.primeNumberResult);

        int primeNumberPositionValue = Integer.parseInt(primeNumberPositionTextField.getText().toString());

        int primeNumber = findPrimeNumberByPosition(primeNumberPositionValue);

        primeNumberResultDescription.setVisibility(View.VISIBLE);
        primeNumberResultDescription.setText(getResources().getString(R.string.resultDescription) + "\n" + primeNumberPositionValue);
        primeNumberResult.setVisibility(View.VISIBLE);
        primeNumberResult.setText(getResources().getString(R.string.primeNumberResult) + "\n" + primeNumber);
    }

    public int findPrimeNumberByPosition(int primeNumberPosition){
        //If the prime number we are searching is already in the primeNumber TreeMap:
        if(this.primeNumbers.get(primeNumberPosition) != null){
            return this.primeNumbers.get(primeNumberPosition);
        }
        //If the prime number we are searching is not already in the primeNumber TreeMap:
            //positionCounter starts by the last key in the primeNumbers TreeMap
        int positionCounter = 1;
        if(!this.primeNumbers.isEmpty()){
            positionCounter = this.primeNumbers.size();
        }
        for (int i = 2; this.primeNumbers.size() < primeNumberPosition; i++){
            if(isPrimeNumber(i)){
                this.primeNumbers.put(positionCounter, i);
                positionCounter++;
            }
        }

        return this.primeNumbers.get(primeNumberPosition);
    }

    public boolean isPrimeNumber(int num){
        for (int i = 2; i <= num / 2; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}