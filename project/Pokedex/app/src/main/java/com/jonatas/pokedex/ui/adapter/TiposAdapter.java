package com.jonatas.pokedex.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.TipoItemBinding;
import com.jonatas.pokedex.model.Tipo;

import java.util.List;

public class TiposAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Tipo> mTipos;
    private TipoItemBinding mBinding;

    public TiposAdapter(Context mContext, List<Tipo> mTipos) {
        this.mContext = mContext;
        this.mTipos = mTipos;
    }

    @Override
    public int getCount() {
        return mTipos.size();
    }

    @Override
    public Object getItem(int position) {
        return mTipos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.tipo_item,
                parent,false);
        Tipo tipo = mTipos.get(position);
        mBinding.tipoNome.setText(tipo.getNome());
        return mBinding.getRoot();

    }
}
