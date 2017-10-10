package com.zyyoona7.lib;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * LinearLayoutManager 空隙的分割线，draw内部没做任何处理
 */

public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL = LinearLayout.HORIZONTAL;
    public static final int VERTICAL = LinearLayout.VERTICAL;

    /**
     * Current orientation. Either {@link #HORIZONTAL} or {@link #VERTICAL}.
     */
    private int mOrientation;
    private int mSpacing;

    public SpacingItemDecoration(int spacing) {
        this.mSpacing = spacing;
    }

    public SpacingItemDecoration(int spacing, int orientation) {
        this.mSpacing = spacing;
        setOrientation(orientation);
    }

    /**
     * Sets the orientation for this divider. This should be called if
     * {@link RecyclerView.LayoutManager} changes orientation.
     *
     * @param orientation {@link #HORIZONTAL} or {@link #VERTICAL}
     */
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw new IllegalArgumentException(
                    "Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        mOrientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        if (mOrientation == VERTICAL) {
            outRect.set(0, 0, 0, mSpacing);
        } else {
            outRect.set(0, 0, mSpacing, 0);
        }
    }
}
