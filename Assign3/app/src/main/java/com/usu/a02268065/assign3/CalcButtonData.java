package com.usu.a02268065.assign3;

public class CalcButtonData {
    public enum ButtonType {
        NUMBER,
        OPERATOR,
        EQUALS,
        DUMP,
        CLEAR,
        UNDO
    }

    public String text;
    public int row;
    public int col;
    public int colspan;
    public ButtonType type;
    public CalcButtonData(String str, int rowSpec, int colSpec, int colSpan, ButtonType type) {
        this.text = str;
        this.row = rowSpec;
        this.col = colSpec;
        this.colspan = colSpan;
        this.type = type;
    }
    public CalcButtonData(String str, int rowSpec, int colSpec, int colSpan) {
        this.text = str;
        this.row = rowSpec;
        this.col = colSpec;
        this.colspan = colSpan;
        this.type = ButtonType.NUMBER;
    }

}
