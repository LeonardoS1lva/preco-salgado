package com.example.calculadoradesalgados.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadoradesalgados.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private double sCru = 50.0/100;
    private double sFrito = 60.0/100;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textCru = findViewById(R.id.text_cru);
        this.mViewHolder.textFrito = findViewById(R.id.text_frito);
        this.mViewHolder.buttonCalcular = findViewById(R.id.button_calcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calcular){
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)){
                Toast.makeText(this, this.getString(R.string.Informe_valor), Toast.LENGTH_LONG).show();
            } else {
                int quant = Integer.valueOf(value);

                this.mViewHolder.textCru.setText("R$ "+String.format("%.2f", (sCru * quant)));
                this.mViewHolder.textFrito.setText("R$ "+String.format("%.2f", (sFrito * quant)));
            }
        }
    }

    private void clearValues(){
        this.mViewHolder.textCru.setText("");
        this.mViewHolder.textFrito.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textCru;
        TextView textFrito;
        Button buttonCalcular;
    }
}
