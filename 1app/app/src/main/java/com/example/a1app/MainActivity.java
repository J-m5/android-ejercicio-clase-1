package com.example.a1app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSaludo;
    TextView tvSaludo;
    EditText etSaludoInput; // Nuevo EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSaludo = findViewById(R.id.btnsaludo);
        tvSaludo = findViewById(R.id.tvSaludo);
        etSaludoInput = findViewById(R.id.etSaludoInput); // Inicializar EditText

        btnSaludo.setOnClickListener(view -> {
            String saludoIngresado = etSaludoInput.getText().toString();
            if (saludoIngresado.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa un saludo", Toast.LENGTH_SHORT).show();
            } else {
                tvSaludo.setText(saludoIngresado);
                // Opcional: Mostrar un Toast de confirmación
                // Toast.makeText(this, "Saludo mostrado: " + saludoIngresado, Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
