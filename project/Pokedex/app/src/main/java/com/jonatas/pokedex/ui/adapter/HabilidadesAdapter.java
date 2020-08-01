package com.jonatas.pokedex.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.HabilidadeItemBinding;
import com.jonatas.pokedex.model.Habilidade;

import java.util.List;

public class HabilidadesAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Habilidade> mHabilidades;
    private HabilidadeItemBinding mBinding;

    public HabilidadesAdapter(Context context, List<Habilidade> mHabilidades) {
        this.mContext = context;
        this.mHabilidades = mHabilidades;
    }


    @Override
    public int getCount() {
        return mHabilidades.size();
    }

    @Override
    public Object getItem(int position) {
        return mHabilidades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.habilidade_item,
                parent,false);

        Habilidade habilidade = mHabilidades.get(position);

        mBinding.habilidadeNome.setText(habilidade.getNome());


        return mBinding.getRoot();
    }


}
