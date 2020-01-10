package com.asknilesh

import androidx.core.view.ViewCompat.setAlpha
import androidx.core.view.ViewCompat.setRotationY
import androidx.core.view.ViewCompat.setPivotX
import android.opengl.ETC1.getWidth
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2


class CubeOutRotationTransformation : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {

        if (position < -1) {    // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.alpha = 0f

        } else if (position <= 0) {    // [-1,0]
            page.alpha = 1f
            page.pivotX = page.width.toFloat()
            page.rotationY = -90 * Math.abs(position)

        } else if (position <= 1) {    // (0,1]
            page.alpha = 1f
            page.pivotX = 0f
            page.rotationY = 90 * Math.abs(position)

        } else {    // (1,+Infinity]
            // This page is way off-screen to the right.
            page.alpha = 0f

        }
    }
}