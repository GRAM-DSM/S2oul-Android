package com.newgram.s2oul_android.recommend

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.TheaterInfo
import com.newgram.s2oul_android.util.DecodeBitmapTask
import kotlinx.android.synthetic.main.item_recommend.view.*

class SliderCard(itemView: View): RecyclerView.ViewHolder(itemView), DecodeBitmapTask.Listener {

    private var viewWidth = 0
    private var viewHeight = 0

    var imageView = itemView.findViewById<ImageView>(R.id.recommend_image_iv)

    private lateinit var task: DecodeBitmapTask

    fun setContent(resId: Int) {
        if (viewWidth == 0) {
            itemView.viewTreeObserver.addOnGlobalLayoutListener {
                itemView.viewTreeObserver.removeOnGlobalLayoutListener{}
                viewWidth = itemView.width
                viewHeight = itemView.height
                loadBitmap(resId)
            }
        } else {
            loadBitmap(resId)
        }
    }

    fun clearContent() {
        if (task != null) {
            task.cancel(true)
        }
    }

    fun loadBitmap(resId: Int) {
        task = DecodeBitmapTask(itemView.resources, resId, viewWidth, viewHeight, this)
        task.execute()
    }

    fun bind(item: TheaterInfo) {
        with(itemView) {
            Glide.with(itemView).load(item.theaterImage).centerCrop().into(recommend_image_iv)
        }
    }

    override fun onPostExecuted(bitmap: Bitmap?) {
        imageView!!.setImageBitmap(bitmap)
    }

}