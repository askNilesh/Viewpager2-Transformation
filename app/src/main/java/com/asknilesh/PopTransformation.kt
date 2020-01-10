package com.asknilesh

import android.view.View

import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class PopTransformation : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {

        page.translationX = -position * page.width

        if (abs(position) < 0.5) {
            page.visibility = View.VISIBLE
            page.scaleX = 1 - abs(position)
            page.scaleY = 1 - abs(position)
        } else if (abs(position) > 0.5) {
            page.visibility = View.GONE
        }


    }
}
