package com.example.furutanihw1;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.method.Touch;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.sql.Struct;

/**
 * <!-- class TouchListener -->
 *
 * The onTouch Listener, allows us to recognize when a custom element has been touched
 * Creates seekbar Objects that edit the color of customElements
 *
 * @author Austen Furutani
 * @version 2/7/2022
 *
 */

public class TouchListener implements View.OnTouchListener {
    private Drawing drawing = null;
    Context context = null;

    public TouchListener(Drawing drawing, Context context) {
        this.drawing = drawing;
        this.context = context;
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        /**
         External Citation
         Date: 6 February 2022
         Problem: Couldnt edit textview out of Mainactivity
         Resource:
         https://stackoverflow.com/questions/10996479/how-to-update-a-textview-of-an-activity-from-another-class
         Solution: I used the example code from this post.
         */
        TextView selectedObj = (TextView) ((Activity) context).findViewById(R.id.selectedObject);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int i = 0;
        int red = 0;
        int green = 0;
        int blue = 0;


        //CREATING RED SEEKBAR LISTENER AND OBJECT
        //finds the textView that will display our red value
        TextView redValue = ((Activity) context).findViewById(R.id.redValue);
        SeekBar.OnSeekBarChangeListener redSBListener = new seekbarManager(redValue, this.drawing);
        //creating the seekbar Object and linking with listener
        SeekBar redSeekbar = ((Activity) context).findViewById(R.id.redSeekbar);
        redSeekbar.setOnSeekBarChangeListener(redSBListener);

        //CREATING GREEN SEEKBAR LISTENER AND OBJECT
        TextView greenValue = ((Activity) context).findViewById(R.id.greenValue);
        SeekBar.OnSeekBarChangeListener greenSBListener = new seekbarManager(greenValue, this.drawing);
        SeekBar greenSeekbar = ((Activity) context).findViewById(R.id.greenSeekbar);
        greenSeekbar.setOnSeekBarChangeListener(greenSBListener);


        //CREATING BLUE LISTENER AND OBJECT
        TextView blueValue = ((Activity) context).findViewById(R.id.blueValue);
        SeekBar.OnSeekBarChangeListener blueSBListener = new seekbarManager(blueValue, this.drawing);
        SeekBar blueSeekbar = ((Activity) context).findViewById(R.id.blueSeekbar);
        blueSeekbar.setOnSeekBarChangeListener(blueSBListener);
        CustomElement[] CEarray = this.drawing.customElArray;

        /**
         * Traverse our List of customElements and checking if any are within our tap radius
         * If its found sequence breaks and seekbars are able to modify the object
         */
        for (i = 0; i < CEarray.length; i++) {
            if (CEarray[i].containsPoint(x, y)) {
                selectedObj.setText(CEarray[i].getName());
                red = Color.red(CEarray[i].getColor());
                redSeekbar.setProgress(red);
                green = Color.green(CEarray[i].getColor());
                greenSeekbar.setProgress(green);
                blue = Color.blue(CEarray[i].getColor());
                blueSeekbar.setProgress(blue);
                break;
            }
        }


        /**
         * Creates new instance of seekbar objects after its selected everytime
         * Probably not the most effective but it works
         */
        redSBListener = new seekbarManager(redValue, this.drawing, CEarray[i], 1);
        redSeekbar.setOnSeekBarChangeListener(redSBListener);
        greenSBListener = new seekbarManager(greenValue, this.drawing, CEarray[i], 2);
        greenSeekbar.setOnSeekBarChangeListener(greenSBListener);

        blueSBListener = new seekbarManager(blueValue, this.drawing, CEarray[i], 3);
        blueSeekbar.setOnSeekBarChangeListener(blueSBListener);

        //FOR BUG TESTING
        Log.i("TOUCH", "onTouch: touch at " + x + " " + y + " " + CEarray[i].getName());
        Log.i("TOUCH", "COLOR " + red + " " + green + " " + blue);

        drawing.invalidate();
        return true;
    }
}

