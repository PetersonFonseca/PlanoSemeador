package br.com.planosemeador.planosemeador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Fornecedor> listaFornecedores;

    public Adapter(List<Fornecedor> lista) {
        this.listaFornecedores = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Fornecedor fornecedor = listaFornecedores.get( position );
        holder.nomeFornecedor.setText( fornecedor.getNomeFornecedor() );
        holder.telefoneFornecedor.setText( fornecedor.getTelefoneFornecedor() );
        holder.enderecoFornecedor.setText( fornecedor.getEnderecoFornecedor() );
        holder.subcategoria.setText(fornecedor.getSubcategoria());
        holder.desconto.setText( fornecedor.getDesconto() );

    }

    @Override
    public int getItemCount() {
        return listaFornecedores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomeFornecedor;
        TextView telefoneFornecedor;
        TextView enderecoFornecedor;
        TextView subcategoria;
        TextView desconto;

        public MyViewHolder(View itemView) {
            super(itemView);
            nomeFornecedor = itemView.findViewById(R.id.nomeFornecedorId);
            telefoneFornecedor = itemView.findViewById(R.id.telefoneFornecedorId);
            enderecoFornecedor = itemView.findViewById(R.id.enderecoFornecedorId);
            subcategoria = itemView.findViewById(R.id.subcategoriaId);
            desconto = itemView.findViewById(R.id.descontoId);

        }
    }

}
