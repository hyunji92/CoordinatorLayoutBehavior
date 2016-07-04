package UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import sample.coordinatebehavior.hyunji.coordinatorlayoutbehavior.R;

/**
 * Created by hyunji on 16. 6. 18..
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerItemViewHolder> {

    public final ArrayList mItemList;

    public RecyclerViewAdapter() {
        mItemList = null;
    }

    @Override
    public ListRecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ListRecyclerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListRecyclerItemViewHolder viewHolder, int position) {
        final TextView titleView = (TextView) viewHolder.itemView.findViewById(R.id.test1);
        if (titleView != null) {
            titleView.setText(String.valueOf(position));
        }
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }
}

class ListRecyclerItemViewHolder extends RecyclerView.ViewHolder {
    public ListRecyclerItemViewHolder(View itemView) {
        super(itemView);
    }
}
