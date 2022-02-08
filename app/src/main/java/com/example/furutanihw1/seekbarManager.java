package com.example.furutanihw1;

import static android.graphics.Color.red;

import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * <!-- class seekbarManager -->
 *
 * Takes the progress from our seekbar displays the RGB value (0-255)
 * alows
 *
 * @author Austen Furutani
 * @version 2/7/2022
 *
 */

public class seekbarManager implements SeekBar.OnSeekBarChangeListener {
    private TextView updatedText = null;
    private int progress;;
    private Drawing drawing;
    private CustomElement element;
    private int RGB;
    public seekbarManager(TextView initTV , Drawing drawing){
        this.updatedText = initTV;
        this.drawing = drawing;
    }
    public seekbarManager(TextView initTV , Drawing drawing, CustomElement element, int RGB){
        this.updatedText = initTV;
        this.drawing = drawing;
        this.element = element;
        this.RGB = RGB;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        this.progress = progress;


        /**
         * each seek bar has value identifying it its the R, G, OR B
         * To set the color we get the color of the Object and try to isolate the R G OR B value
         * Color.___ finds the isolated RBG value of the object
         */
        if (RGB == 1){
            element.setColor( element.getColor() - (Color.red(element.getColor()) - progress)*65536 );
        }
        else if (RGB == 2){
            element.setColor( element.getColor() - (Color.green(element.getColor()) - progress)*256 );
        }
        else if (RGB == 3){
            element.setColor( element.getColor() - (Color.blue(element.getColor()) - progress) );
        }
        this.updatedText.setText("" + this.progress);
        this.drawing.invalidate();
    }





    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



}
