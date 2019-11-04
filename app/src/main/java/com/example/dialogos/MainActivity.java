package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoConfirmacionListener {
    private DialogoLogin dialogoLogin;
    private FragmentManager fragmentManager;
    private final String USUARIO = "usuario1";
    private final String CONTRASENIA = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fragmentManager,"Dialogo");




    }


    @Override
    public void onPossitiveButtonClick() {
        String usuario = dialogoLogin.getEdUsuario().getText().toString();
        String contrasenia = dialogoLogin.getEdContrasenia().getText().toString();

        if(usuario.equals(USUARIO) && contrasenia.equals(CONTRASENIA)){
            Toast.makeText(this,"CORRECTO",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"INCORRECTO",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this,"Es necesario usuario y contraseña",Toast.LENGTH_LONG).show();

    }
}
