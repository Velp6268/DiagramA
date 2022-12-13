package com.example.cardiagram

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.TextView


class CustomProgress(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
        View(context, attrs, defStyleAttr) {

        private val onePaint: Paint = Paint()
        private val twoPaint: Paint = Paint()
        private val threePaint: Paint = Paint()
        private val fourPaint: Paint = Paint()
        private val fivePaint: Paint = Paint()


        private val onePaintText: Paint = Paint()



        var oneNum = 240f
        var twoNum = 100f
        var threeNum = 70f
        var fourNum = 320f
        var fiveNum = 150f

        var text1 = "Диаграмма"
        var fontSize = 100
        var numSize = 65

        var numSum = oneNum + twoNum + threeNum + fourNum + fiveNum

        fun Math(a: Float, numberAll: Float ) : Float {

            return (a/numberAll) * 360
        }

        fun MathProcent (num: Float) : Float {

            return (num/360) * 100
        }







        private var startAngleOneOval = 0f
        private var sweepAngleOneOval = Math(oneNum, numSum)

        private var startAngleTwoOval = sweepAngleOneOval;
        private var sweepAngleTwoOval = Math(twoNum, numSum)

        private var startAngleThreeOval = sweepAngleTwoOval + sweepAngleOneOval
        private var sweepAngleThreeOval = Math(threeNum, numSum)

        private var startAngleFourOval = sweepAngleThreeOval + sweepAngleTwoOval + sweepAngleOneOval
        private var sweepAngleFourOval = Math(fourNum, numSum)

        private var startAngleFiveOval = sweepAngleFourOval + sweepAngleThreeOval + sweepAngleTwoOval + sweepAngleOneOval
        private var sweepAngleFiveOval = Math(fiveNum, numSum)




        constructor(context: Context?) : this(context, null) {}
        constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {}


        override fun onDraw(canvas: Canvas) {
            onePaint.color = Color.RED
            twoPaint.color = Color.GREEN
            threePaint.color = Color.YELLOW
            fourPaint.color = Color.BLUE
            fivePaint.color = Color.MAGENTA

            onePaintText.color = Color.RED


            val x = ((width - height / 2) / 2).toFloat()
            val y = (height / 4).toFloat()
            val oval = RectF(x, y, width - x, height - y)

            var oneNum = MathProcent(sweepAngleOneOval).toInt()
            var twoNum = MathProcent(sweepAngleTwoOval).toInt()
            var threeNum = MathProcent(sweepAngleThreeOval).toInt()
            var fourNum = MathProcent(sweepAngleFourOval).toInt()
            var fiveNum = MathProcent(sweepAngleFiveOval).toInt()

            onePaintText.textSize = fontSize.toFloat()
            onePaint.textSize = numSize.toFloat()
            twoPaint.textSize = numSize.toFloat()
            threePaint.textSize = numSize.toFloat()
            fourPaint.textSize = numSize.toFloat()
            fivePaint.textSize = numSize.toFloat()

            canvas.drawArc(oval, startAngleOneOval, sweepAngleOneOval  , true, onePaint)
            canvas.drawArc(oval, startAngleTwoOval, sweepAngleTwoOval, true, twoPaint)
            canvas.drawArc(oval, startAngleThreeOval, sweepAngleThreeOval, true, threePaint)
            canvas.drawArc(oval, startAngleFourOval, sweepAngleFourOval, true, fourPaint)
            canvas.drawArc(oval, startAngleFiveOval, sweepAngleFiveOval, true, fivePaint)

            canvas.drawText(text1, 200f, 300f, onePaintText)

            canvas.drawText(oneNum.toString() + "%", 70f, 1600f, onePaint)
            canvas.drawText(twoNum.toString() + "%", 250f, 1600f, twoPaint)
            canvas.drawText(threeNum.toString() + "%", 460f, 1600f, threePaint)
            canvas.drawText(fourNum.toString() + "%", 630f, 1600f, fourPaint)
            canvas.drawText(fiveNum.toString() + "%", 780f, 1600f, fivePaint)





        }



    }