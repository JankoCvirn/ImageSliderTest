package com.ursastudio.imageslider.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ursastudio.imageslider.R
import com.ursastudio.imageslider.model.ImageModel
import kotlin.collections.ArrayList

/**
 * ImageSlider
 * com.ursastudio.imageslider.adapter
 * Created by janko on 17.01.18..
 * Description:
 * Usage:
 */

class DoubleSlidingImageAdapter(private val context: Context, private val imageModels: ArrayList<ImageModel>?) : PagerAdapter() {
    private val layoutInflater: LayoutInflater

    init {
        this.layoutInflater = LayoutInflater.from(context)
    }


    override fun getCount(): Int {
        return imageModels!!.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


    private fun nextPosition(position: Int): Int {

        return if (position == count) {
            0
        } else {
            position + 1
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val imageLayout = layoutInflater.inflate(R.layout.slider_image_holder, container, false)!!
        val imageView = imageLayout.findViewById<ImageView>(R.id.imageViewFull)
        val imageViewNext = imageLayout.findViewById<ImageView>(R.id.imageViewNext)

        imageView.setImageResource(imageModels!![position].imageDrawable)
        val nextPosition = nextPosition(position)
        imageViewNext.setImageResource(imageModels[nextPosition].imageDrawable)



        container.addView(imageLayout, 0)

        return imageLayout
    }
}
