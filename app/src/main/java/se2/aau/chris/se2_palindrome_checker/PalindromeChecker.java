package se2.aau.chris.se2_palindrome_checker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PalindromeChecker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome_checker);

        Button checkBtn = findViewById(R.id.checkBtn);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = ((TextView) findViewById(R.id.inputText)).getText().toString();
                TextView output = findViewById(R.id.outputField);
                switch(isPalindrome(input)){
                    case EMPTY:
                        output.setText(R.string.label_empty);
                        break;
                    case TOOSHORT:
                        output.setText(R.string.label_toShort);
                        break;
                    case ISPALINDROME:
                        output.setText(R.string.label_isPalindrome);
                        break;
                    case NOTPALINDROME:
                        output.setText(R.string.label_notPalindrome);
                        break;
                }

            }
        });

    }

    protected static Status isPalindrome(String input){
        if(input.length() == 0) return Status.EMPTY;
        if(input.length()<5) return Status.TOOSHORT;
        if(input.equals(new StringBuilder(input).reverse().toString())) return Status.ISPALINDROME;
        return Status.NOTPALINDROME;
    }

    public enum Status{
        ISPALINDROME, NOTPALINDROME, TOOSHORT, EMPTY;
    }
}
