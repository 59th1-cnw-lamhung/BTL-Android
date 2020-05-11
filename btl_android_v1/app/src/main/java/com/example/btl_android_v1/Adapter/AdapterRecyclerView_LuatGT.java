package com.example.btl_android_v1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.btl_android_v1.Object.LuatGT;
import com.example.btl_android_v1.R;

import java.util.ArrayList;
import java.util.List;

import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderAdapter;


public class AdapterRecyclerView_LuatGT extends RecyclerView.Adapter<AdapterRecyclerView_LuatGT.RecyclerViewHolder>
        implements StickyHeaderAdapter<AdapterRecyclerView_LuatGT.HeaderHolder> {
    List<LuatGT> listLuatGT = new ArrayList<LuatGT>();
    Context context;
    private LayoutInflater mInflater;
    public AdapterRecyclerView_LuatGT(Context context, List<LuatGT> listLuatGT) {
        this.listLuatGT = listLuatGT;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_recyclerview_luatgt,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv_noiDung.setText(listLuatGT.get(position).getNoiDung());

    }

    @Override
    public int getItemCount() {
        return listLuatGT.size();
    }

    @Override
    public long getHeaderId(int position) {
        return (long) listLuatGT.get(position).getLoai();
    }

    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.header_bienbao, parent, false);
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        String headerName = "";
        if (getHeaderId(position)==0){
            headerName = "LUẬT GT1";
        } else if (getHeaderId(position)==1){
            headerName = "LUẬT GT2";
        } else if (getHeaderId(position)==2){
            headerName = "LUẬT GT3";
        }else if (getHeaderId(position)==3){
            headerName = "LUẬT GT4";
        }
        viewholder.header.setText(headerName);
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tv_noiDung;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_noiDung = itemView.findViewById(R.id.tv_noiDung);
        }
    }
    static class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView header;

        public HeaderHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView;
        }
    }
}
