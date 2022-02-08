package com.example.furutanihw1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.session.PlaybackState;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * <!-- class Drawing -->
 *
 * Creates and draws Custom elements along with creating touch Objects
 *
 * @author Austen Furutani
 * @version 2/7/2022
 *
 */

public class Drawing extends SurfaceView {
    public CustomRect sky = null;
    public  CustomRect leftPlat = null;
    public  CustomRect trunk = null;
    public  CustomCircle leaves = null;
    public  CustomRect rightPlat = null;
    public  CustomRect topPlat = null;
    public  CustomRect ground = null;
    public  CustomRect grass = null;
    public  CustomCircle randall = null;
    public  CustomElement[] customElArray = null;
    private Paint black = new Paint();
    private Paint red = new Paint();
    private Context context;

    public Drawing(Context context) {
        super(context);
        this.context = context;
        init();
        setWillNotDraw(false);
    }
    public Drawing(Context context, AttributeSet attirs){
        super(context, attirs);
        this.context = context;
        init();
        setWillNotDraw(false);//sets visible
    }



    public Drawing(Context context, AttributeSet attirs, int defStyle){
        super(context, attirs, defStyle);
        this.context = context;
        init();
        setWillNotDraw(false);//sets visible
    }

    private void init(){
        //Sets randells eye color
        this.black.setColor(0xFF000000);
        this.black.setStyle(Paint.Style.FILL);
        //sets randells beautiful smile color
        this.red.setColor(0xFFFF0000);
        this.red.setStyle(Paint.Style.STROKE);

        /**
         * Creating customElement objects and storing them in a list
         */
        sky = new CustomRect("Sky", 0xFF87ceeb, 0, 0, 5000, 5000);
        leftPlat = new CustomRect("Left Platform", 0xFFFF0000, 500, 350, 900, 400);
        rightPlat = new CustomRect("Right Platform", 0xFFFF0000, 1600, 350, 2000, 400);
        topPlat = new CustomRect("Top Platform", 0xFFFF0000, 1000, 100, 1500, 150);
        trunk = new CustomRect("Trunk", 0xFF66493A, 1150, 500, 1350, 700);
        leaves = new CustomCircle("Leaves", 0xFF567d46, 1250, 400, 200);
        ground = new CustomRect("Ground", 0xFF9b7653, 500, 900, 2000, 5000);
        grass = new CustomRect("Grass", 0xFF228b22, 500, 700, 2000, 900);
        randall = new CustomCircle("Randell", 0xFFF3EEE1, 300, 800, 100);
        customElArray = new CustomElement[]{ leftPlat, rightPlat, topPlat, leaves, trunk, ground, grass, randall, sky};

        //On touch listener all passing the Context of the activity and the drawing
        TouchListener listener = new TouchListener(this, this.context);

        this.setOnTouchListener(listener);


    }





    public void onDraw(Canvas canvas) { //Draws our customELements
        sky.drawMe(canvas);
        topPlat.drawMe(canvas);
        trunk.drawMe(canvas);
        leaves.drawMe(canvas);
        rightPlat.drawMe(canvas);
        leftPlat.drawMe(canvas);
        ground.drawMe(canvas);
        grass.drawMe(canvas);
        randall.drawMe(canvas);

        //DRAWING FACE ON RANDELl
        canvas.drawOval(250, 770, 280, 800, black);
        canvas.drawOval(330, 770, 360, 800, black);
        canvas.drawOval(280, 830, 330, 860, red);


    }

}
