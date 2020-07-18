package com.example.favrlist;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView firstText;
    TextView secondText;
    Button btn;
    public RecyclerViewHolder(@NonNull View view) {
        super(view);
         firstText = view.findViewById(R.id.firstText);
         secondText = view.findViewById(R.id.secondText);
//         btn = view.findViewById(R.id.btn);

//         btn.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//               //  Toast.makeText(MainActivity.this,"Button clicked",Toast.LENGTH_SHORT).show();
//                 btn.setText("Clicked");
//
//             }
//         });
        }



    public TextView getFirstText() {
        return firstText;
    }

    public TextView getSecondText() {
        return secondText;
    }
}



