package com.bka.fragment;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.mariuszgromada.math.mxparser.*;

import java.util.regex.Pattern;

public class FragmentCaculator extends Fragment {
    private EditText display;
    private EditText equal;
    private boolean checkResult = false;
    private boolean checkCE = false;
    private boolean checkDone = false;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caculator,container, false);
        display = view.findViewById(R.id.calculation);
        equal = view.findViewById(R.id.result);
        display.setFocusable(false);
        equal.setFocusable(false);
        return view;
    }


    private void updateText (String strToAdd) {
        String oldString = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftString = oldString.substring(0, cursorPos);
        String rightString = oldString.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftString, strToAdd, rightString));
        display.setSelection(cursorPos + 1);
        checkCE = true;
    }

    private void updateNumber (String number) {
        if (checkDone) {
            display.setText("");
            updateText(number);
            checkDone = false;
        }
        else {
            updateText(number);
        }
    }

    private void updateOperator (String operator) {
        if (checkResult) {
            if (checkCE && !display.getText().toString().isEmpty()) {
                updateText(operator);
            }
            else {
                String resultPre = equal.getText().toString();
                display.setText(String.format("%s%s", resultPre, operator));
                display.setSelection(display.getText().length());
                checkResult = false;
            }
        }
        else {
            updateText(operator);
        }
        checkDone = false;
    }

    public void zeroBT (View view)  { updateNumber("0"); }
    public void oneBT (View view)  { updateNumber("1"); }
    public void twoBT (View view)  { updateNumber("2"); }
    public void threeBT (View view)  { updateNumber("3"); }
    public void fourBT (View view)  { updateNumber("4"); }
    public void fiveBT (View view)  { updateNumber("5"); }
    public void sixBT (View view)  { updateNumber("6"); }
    public void sevenBT (View view)  { updateNumber("7"); }
    public void eightBT (View view)  { updateNumber("8"); }
    public void nineBT (View view)  { updateNumber("9"); }
    public void plusBT (View view)  { updateOperator("+"); }
    public void subtractBT (View view)  { updateOperator("-"); }
    public void multiplyBT (View view)  { updateOperator("x"); }
    public void divideBT (View view)  { updateOperator("÷"); }

    public void dotBT (View view)  {
        int textLen = display.getText().length();
        if (textLen > 0) {
            char checkNumber = display.getText().charAt(textLen - 1);
            if (Character.isDigit(checkNumber) && !checkDone) {
                updateText(".");
            }
        }
    }
    public void changeBT (View view)  {
        int textLen = display.getText().length();
        if (textLen > 0) {
            display.setSelection(0);
            int index = display.getSelectionStart();
            String oldString = display.getText().toString();
            String leftString = oldString.substring(0, index);
            String rightString = oldString.substring(index);
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

            if (pattern.matcher(rightString).matches()) {
                char check = rightString.charAt(0);
                if (Character.isDigit(check)) {
                    display.setText(String.format("%s%s%s", leftString, "-", rightString));
                } else {
                    String text = display.getText().toString();
                    text = text.replaceFirst("-", "");
                    display.setText(text);
                }
            }
        }
        textLen = display.getText().length();
        display.setSelection(textLen);
    }
    public void CBT (View view)  {
        display.setText("");
        equal.setText("0");
        checkResult = false;
    }
    public void CEBT (View view)  {
        display.setText("");
        checkCE = true;
    }
    public void deleteBT (View view)  {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
            checkDone = false;
        }
    }
    public void equalBT (View view)  {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("x", "*");
        userExp = userExp.replaceAll("--", "\\+");
        userExp = userExp.replaceAll("\\+-", "-");
        userExp = userExp.replaceAll("-\\+", "-");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());
        if (result.equals("NaN")) {
            equal.setText("Error");
            checkResult = false;
        }
        else {
            String[] value = result.split("\\.");
            if (value[1].equals("0")) {
                equal.setText(value[0]);
            }
            else {
                equal.setText(result);
            }
            checkResult = true;
            checkCE = false;
            checkDone = true;
        }
    }
}
