package com.example.dialogos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DialogoLogin extends DialogFragment {

    private EditText edUsuario,edContrasenia;

    // Interfaz de comunicación
    DialogoLogin.OnDialogoConfirmacionListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialogo_login, null);
        builder.setView(dialogView)
                .setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onPossitiveButtonClick();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onNegativeButtonClick();
                        dialog.cancel();
                    }
        });

        edUsuario = dialogView.findViewById(R.id.editTextUsuario);
        edContrasenia = dialogView.findViewById(R.id.editTextContrasenia);

        return builder.create();
    }

    public EditText getEdUsuario() {
        return edUsuario;
    }

    public EditText getEdContrasenia() {
        return edContrasenia;
    }


    public interface OnDialogoConfirmacionListener{
        void onPossitiveButtonClick(); //Eventos Botón Positivos
        void onNegativeButtonClick();  //Eventos Botón Negativo}
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{listener = (DialogoLogin.OnDialogoConfirmacionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +" no Implemento OnDialogoConfirmacionListener");
        }
    }

}
