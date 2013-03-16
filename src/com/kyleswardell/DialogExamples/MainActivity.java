package com.kyleswardell.DialogExamples;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onClickAlertDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog");
        builder.setIcon(R.drawable.ic_launcher);
        builder.setMessage("This is an alert dialog!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "OK Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void onClickMultiDialog(View v) {
        final CharSequence[] items = {"Google", "Apple", "Microsoft", "Citrix", "Adobe"};
        boolean[] checkedItems = new boolean[items.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Multi Alert Dialog");
        builder.setIcon(R.drawable.ic_launcher);
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getBaseContext(), (items[which] + (isChecked ? " checked!" : " unchecked!")), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "OK Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void onClickProgressDialog(View v) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Progress Dialog");
        dialog.setIcon(R.drawable.ic_launcher);
        dialog.setMessage("This is a progress dialog!");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    dialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    public void onClickDetailedProgressDialog(View v) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Progress Dialog");
        dialog.setIcon(R.drawable.ic_launcher);
        dialog.setMessage("This is a detailed progress dialog!");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCancelable(true);
        dialog.setProgress(0);
        dialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Operation Canceled!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        for(int i = 0; i < 5; i++) {
                            Thread.sleep(1000);
                            dialog.incrementProgressBy(100/5);
                        }
                        dialog.dismiss();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }).start();
    }
}
