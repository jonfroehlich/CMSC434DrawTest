package edu.umd.hcil.cmsc434drawtest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawTestView drawTestView1 = (DrawTestView)findViewById(R.id.viewDrawTest1);
        drawTestView1.setDrawMode(DrawMode.Objects);

        DrawTestView drawTestView2 = (DrawTestView)findViewById(R.id.viewDrawTest2);
        drawTestView2.setDrawMode(DrawMode.OffscreenBitmap);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButtonHighlightHistoricalPoints);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DrawTestView drawTestView1 = (DrawTestView)findViewById(R.id.viewDrawTest1);
                DrawTestView drawTestView2 = (DrawTestView)findViewById(R.id.viewDrawTest2);

                // if checked, will draw historical points in gray and current point in red
                drawTestView1.setHighlightHistoricalPoints(isChecked);
                drawTestView2.setHighlightHistoricalPoints(isChecked);
            }
        });
    }

    public void onButtonClickClearAll(View v){
        DrawTestView drawTestView1 = (DrawTestView)findViewById(R.id.viewDrawTest1);
        DrawTestView drawTestView2 = (DrawTestView)findViewById(R.id.viewDrawTest2);
        drawTestView1.clearDrawing();
        drawTestView2.clearDrawing();

    }
}
