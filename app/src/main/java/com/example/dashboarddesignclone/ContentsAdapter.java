package com.example.dashboarddesignclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.ContentsHolder>{

    private final List<Contents> contents;

    public ContentsAdapter(List<Contents> contents) {
        this.contents = contents;
    }

    @NonNull
    @Override
    public ContentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContentsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContentsHolder holder, int position) {
        holder.setContents(contents.get(position));
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }


    static class ContentsHolder extends RecyclerView.ViewHolder {

        private final RoundedImageView image;
        private final TextView textName, textCategory, textExplan;
        private final RatingBar ratingBar;

        public ContentsHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            textName = view.findViewById(R.id.textName);
            textCategory = view.findViewById(R.id.textCategory);
            textExplan = view.findViewById(R.id.textExplan);
            ratingBar = view.findViewById(R.id.ratingBar);
        }

        void setContents(Contents contents) {
            image.setImageResource(contents.poster);
            textName.setText(contents.name);
            textCategory.setText(contents.category);
            textExplan.setText(contents.explanation);
            ratingBar.setRating(contents.rating);
        }

    }

}
