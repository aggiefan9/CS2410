package com.usu.a02268065.assign3;

import android.content.Context;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;

public class CalcButton extends AppCompatButton {
    public CalcButton(Context context, CalcButtonData data, OnClickListener onClickListener) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.columnSpec = GridLayout.spec(data.col, data.colspan, 1);
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        setLayoutParams(params);
        setText(data.text);
        setTextSize(22);
        if(data.type == CalcButtonData.ButtonType.NUMBER) {
            setBackgroundColor(getResources().getColor(R.color.NumberButtonColor));
        } else if(data.type == CalcButtonData.ButtonType.OPERATOR) {
            setBackgroundColor(getResources().getColor(R.color.OperatorButtonColor));
        } else {
            setBackgroundColor(getResources().getColor(R.color.ActionButtonColor));
        }
        setOnClickListener(onClickListener);
    }
}
