package club.rooftop.raus.common.coil.transform

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import androidx.core.graphics.applyCanvas
import androidx.core.graphics.createBitmap
import club.rooftop.raus.common.dp2px
import coil.size.Size
import coil.transform.Transformation

class BorderedCircleCropTransformation(
    private val imgSize: Int,
    private val outerBorderSize: Float = 1.5.dp2px,
    private val outerBorderColor: Int,
) : Transformation {

    override val cacheKey: String
        get() = BorderedCircleCropTransformation::class.java.name

    override suspend fun transform(input: Bitmap, size: Size): Bitmap {
        val minSize = imgSize
        val output = createBitmap(minSize, minSize, input.safeConfig)
        output.applyCanvas {
            val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
            val radius = minSize / 2f
            drawCircle(radius, radius, radius, paint)

            // Draw Image
            drawImage(paint, input, minSize)

            // Draw outer border
            drawCircleBorder(paint, radius, outerBorderColor, outerBorderSize)
        }

        return output
    }

    private fun Canvas.drawImage(
        paint: Paint,
        input: Bitmap,
        minSize: Int,
    ) {
        paint.xfermode = XFERMODE
        val src = when (input.width >= input.height) {
            true -> {
                val min = input.height
                val offset = (input.width - min) / 2
                Rect(offset, 0, input.width - offset, min)
            }
            else -> {
                val min = input.width
                val offset = (input.height - min) / 2
                Rect(0, offset, min, input.height - offset)
            }
        }
        val dst = Rect(0, 0, minSize, minSize)
        drawBitmap(input, src, dst, paint)
    }

    private fun Canvas.drawCircleBorder(
        paint: Paint,
        radius: Float,
        color: Int,
        strokeWidth: Float
    ) {
        paint.style = Paint.Style.STROKE
        paint.color = color
        paint.strokeWidth = strokeWidth.dp2px
        drawCircle(radius, radius, radius, paint)
    }

    private val Bitmap.safeConfig: Bitmap.Config
        get() = config ?: Bitmap.Config.ARGB_8888

    private companion object {
        val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    }

}
