package com.ursastudio.image

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.ursastudio.imageslider.R
import com.ursastudio.imageslider.adapter.DoubleSlidingImageAdapter
import com.ursastudio.imageslider.model.ImageModel


class MainActivity : AppCompatActivity() {

    private val myImageList = intArrayOf(R.drawable.harley2, R.drawable.benz2, R.drawable.vecto, R.drawable.webshots, R.drawable.bikess, R.drawable.img1)

    private lateinit var imageList: ArrayList<ImageModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateList()

    }

    private fun populateList() {

        imageList = ArrayList()

        val size: Int = myImageList.size;

        for (i in 0..5) {
            imageList.add(ImageModel(myImageList[i]))
        }
        initPager()
    }

    private fun initPager() {
        var mPager: ViewPager = findViewById(R.id.viewPager)
        mPager.setAdapter(DoubleSlidingImageAdapter(this, imageList))

    }


}
