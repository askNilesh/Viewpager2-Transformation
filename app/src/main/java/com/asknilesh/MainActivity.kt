package com.asknilesh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listOfPageTransformer = resources.getStringArray(R.array.selectPageTransformer)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, listOfPageTransformer
        )
        selectPageTransformer.adapter = adapter
        selectPageTransformer.onItemSelectedListener


        selectPageTransformer.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                pagerOne.adapter = MyAdapter(this@MainActivity)

                changePageTransformer(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        pagerOne.adapter = MyAdapter(this)


    }

    private fun changePageTransformer(position: Int) {

        when (position) {
            0 -> pagerOne.setPageTransformer(AntiClockSpinTransformation())
            1 -> pagerOne.setPageTransformer(CubeInScalingTransformation())
            2 -> pagerOne.setPageTransformer(CubeOutRotationTransformation())
            3 -> pagerOne.setPageTransformer(DepthTransformation())
            4 -> pagerOne.setPageTransformer(FadeOutTransformation())
            5 -> pagerOne.setPageTransformer(FanTransformation())
            6 -> pagerOne.setPageTransformer(FidgetSpinTransformation())
            7 -> pagerOne.setPageTransformer(HeaderFloatTransformer(ViewPager2.ORIENTATION_HORIZONTAL))
            8 -> pagerOne.setPageTransformer(HingeTransformation())
            9 -> pagerOne.setPageTransformer(OverlapSliderTransformer(ViewPager2.ORIENTATION_HORIZONTAL))
            10 -> pagerOne.setPageTransformer(PopTransformation())
            11 -> pagerOne.setPageTransformer(SimpleSliderTransformer())
            12 -> pagerOne.setPageTransformer(SpinTransformation())
            13 -> pagerOne.setPageTransformer(
                StackSliderTransformer(
                    ViewPager2.ORIENTATION_HORIZONTAL,
                    0.2f,
                    0.5f

                )
            )
            14 -> pagerOne.setPageTransformer(VerticalFlipTransformation())
            15 -> pagerOne.setPageTransformer(VerticalShutTransformation())
            16 -> pagerOne.setPageTransformer(ZoomOutTransformation())

        }
    }
}
