package com.example.lab2;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// ❌ SUPPRIME cette ligne si elle existe :
// import com.example.lab2.R;

public class MainActivity extends AppCompatActivity {

    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);

        // 🔴 Vérification anti-crash
        if (surfaceInput == null || piecesInput == null || resultView == null) {
            Toast.makeText(this, "Erreur XML (IDs incorrects)", Toast.LENGTH_LONG).show();
            return;
        }

        findViewById(R.id.button_calcul).setOnClickListener(v -> calculer());
    }

    private void calculer() {

        String surfaceText = surfaceInput.getText().toString().trim();
        String piecesText = piecesInput.getText().toString().trim();

        // 🔴 Vérification champs vides
        if (surfaceText.isEmpty() || piecesText.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double surface = Double.parseDouble(surfaceText);
            int pieces = Integer.parseInt(piecesText);
            boolean piscine = piscineCheckbox.isChecked();

            double impotBase = surface * 2;
            double supplement = pieces * 50;

            if (piscine) {
                supplement += 100;
            }

            double total = impotBase + supplement;

            resultView.setText("Impôt total : " + total + " DH");

        } catch (Exception e) {
            Toast.makeText(this, "Erreur de saisie", Toast.LENGTH_SHORT).show();
        }
    }
}