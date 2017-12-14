package com.aliletter.carouselbannar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aliletter.carouselbannar.R;
import com.aliletter.carouselbannar.base.CarouselBannerBase;
import com.aliletter.onhttp.OnHttp;

import java.util.List;

/**
 * Created by test on 2017/11/22.
 */


public class MzBannerAdapter extends BaseBannerAdapter<MzBannerAdapter.MzViewHolder> {

    private CarouselBannerBase.OnBannerItemClickListener onBannerItemClickListener;

    public MzBannerAdapter(Context context, List<String> urlList, CarouselBannerBase.OnBannerItemClickListener onBannerItemClickListener) {
        super(context, urlList);
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @Override
    protected MzBannerAdapter.MzViewHolder createCustomViewHolder(ViewGroup parent, int viewType) {
        return new MzViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void bindCustomViewHolder(MzViewHolder holder, final int position) {
        if (urlList == null || urlList.isEmpty())
            return;
        String url = urlList.get(position % urlList.size());
        ImageView img = (ImageView) holder.imageView;

        OnHttp.imageLoader().url(url).view(img).build();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBannerItemClickListener != null) {
                    onBannerItemClickListener.onItemClick(position % urlList.size());
                }
            }
        });
    }

    class MzViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        MzViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
